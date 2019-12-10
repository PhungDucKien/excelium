import React, { Component } from 'react';
import { debounce } from 'lodash';
import { SCREENSHOT_INTERACTION_MODE, INTERACTION_MODE } from './shared';
import { Card, Icon, Button, Spin, Tooltip, Modal, Tabs } from 'antd';
import Screenshot from './Screenshot';
import SelectedElement from './SelectedElement';
import Source from './Source';
import InspectorStyles from './Inspector.module.css';
import RecordedActions from './RecordedActions';
import Actions from './Actions';
import { CopyToClipboard } from 'react-copy-to-clipboard';

const {SELECT, SWIPE, TAP} = SCREENSHOT_INTERACTION_MODE;

const { TabPane } = Tabs;

const ButtonGroup = Button.Group;

const isDevelopment = process.env.NODE_ENV === 'development';

const MIN_WIDTH = 1080;
const MIN_HEIGHT = 570;
const MAX_SCREENSHOT_WIDTH = 500;
const KEEP_ALIVE_PING_INTERVAL = 5 * 1000;
const NO_NEW_COMMAND_LIMIT = isDevelopment ? 30 * 1000 : 24 * 60 * 60 * 1000; // Set timeout to 24 hours
const WAIT_FOR_USER_KEEP_ALIVE = 60 * 60 * 1000; // Give user 1 hour to reply

export default class Inspector extends Component {

  constructor () {
    super();
    this.didInitialResize = false;
    this.state = {};
    this.screenAndSourceEl = null;
    this.lastScreenshot = null;
    this.updateSourceTreeWidth = debounce(this.updateSourceTreeWidth.bind(this), 50);
  }

  updateSourceTreeWidth () {
    // the idea here is to keep track of the screenshot image width. if it has
    // too much space to the right or bottom, adjust the max-width of the
    // screenshot container so the source tree flex adjusts to always fill the
    // remaining space. This keeps everything looking tight.
    if (!this.screenAndSourceEl) {
      return;
    }

    const screenshotBox = this.screenAndSourceEl.querySelector('#screenshotContainer');
    const img = this.screenAndSourceEl.querySelector('#screenshotContainer img#screenshot');

    if (!img) {
      return;
    }

    const imgRect = img.getBoundingClientRect();
    const screenshotRect = screenshotBox.getBoundingClientRect();
    screenshotBox.style.flexBasis = `${imgRect.width}px`;
    if (imgRect.width < screenshotRect.width) {
      screenshotBox.style.maxWidth = `${imgRect.width}px`;
    } else if (imgRect.height < screenshotRect.height) {
      // get what the img width would be if it fills screenshot box height
      const attemptedWidth = (screenshotRect.height / imgRect.height) * imgRect.width;
      screenshotBox.style.maxWidth = attemptedWidth > MAX_SCREENSHOT_WIDTH ?
        `${MAX_SCREENSHOT_WIDTH}px` :
        `${attemptedWidth}px`;
    }
  }

  componentDidMount () {
    const curHeight = window.innerHeight;
    const curWidth = window.innerWidth;
    const needsResize = (curHeight < MIN_HEIGHT) || (curWidth < MIN_WIDTH);
    if (!this.didInitialResize && needsResize) {
      const newWidth = curWidth < MIN_WIDTH ? MIN_WIDTH : curWidth;
      const newHeight = curHeight < MIN_HEIGHT ? MIN_HEIGHT : curHeight;
      // resize width to something sensible for using the inspector on first run
      window.resizeTo(newWidth, newHeight);
    }
    this.didInitialResize = true;
    this.props.setSessionId(this.props.match.params.sessionId);
    this.props.fetchSessionDetails(this.props.match.params.sessionId);
    this.props.getSavedActionFramework();
    window.addEventListener('resize', this.updateSourceTreeWidth);
  }

  componentDidUpdate () {
    const { screenshot, isSessionDone, isKeepingAlive } = this.props;
    // only update when the screenshot changed, not for any other kind of
    // update
    if (screenshot !== this.lastScreenshot) {
      this.updateSourceTreeWidth();
      this.lastScreenshot = screenshot;
    }
    if (!this.keepAlive) {
      if (isKeepingAlive && !isSessionDone) {
        this.runKeepAliveLoop();
      }
    } else {
      if (!isKeepingAlive || isSessionDone) {
        this.killKeepAliveLoop();
      }
    }
  }

  /**
   * Ping server every 30 seconds to prevent `newCommandTimeout` from killing session
   */
  runKeepAliveLoop () {
    this.keepAlive = setInterval(() => {
      this.props.fetchSessionDetails(this.props.match.params.sessionId, true); // Pings the Appium server to keep it alive
      const now = +(new Date());

      // If the new command limit has been surpassed, prompt user if they want to keep session going
      // Give them 30 seconds to respond
      if (now - this.props.lastActiveMoment > NO_NEW_COMMAND_LIMIT) {
        this.props.promptKeepAlive();

        // After the time limit kill the session (this timeout will be killed if they keep it alive)
        this.waitForUserTimeout = setTimeout(() => {
          this.killKeepAliveLoop();
          this.props.applyClientMethod({methodName: 'quit', args: ['Session closed due to inactivity']});
        }, WAIT_FOR_USER_KEEP_ALIVE);
      }
    }, KEEP_ALIVE_PING_INTERVAL);
  }

  /**
   * Get rid of the intervals to keep the session alive
   */
  killKeepAliveLoop () {
    clearInterval(this.keepAlive);
    if (this.waitForUserTimeout) {
      clearTimeout(this.waitForUserTimeout);
    }
  }

  /**
   * Reset the new command clock and kill the wait for user timeout
   */
  keepSessionAlive () {
    this.props.keepSessionAlive();
    this.props.setLastActiveMoment();
    if (this.waitForUserTimeout) {
      clearTimeout(this.waitForUserTimeout);
    }
  }

  screenshotInteractionChange (mode) {
    const {selectScreenshotInteractionMode, clearSwipeAction} = this.props;
    clearSwipeAction(); // When the action changes, reset the swipe action
    selectScreenshotInteractionMode(mode);
  }

  render () {
    const {screenshot, screenshotError, selectedElement = {},
           applyClientMethod, quitSession, isRecording, showRecord, startRecording,
           pauseRecording, showLocatorTestModal,
           stepOverDebugger, resumeDebugger, muteAndResumeDebugger,
           screenshotInteractionMode,
           selectedInteractionMode, selectInteractionMode,
           showKeepAlivePrompt, sourceXML, t} = this.props;
    const {path} = selectedElement;

    let main = <div className={InspectorStyles['inspector-main']} ref={(el) => {this.screenAndSourceEl = el;}}>
      <div id='screenshotContainer' className={InspectorStyles['screenshot-container']}>
        {screenshot && <Screenshot {...this.props} />}
        {screenshotError && t('couldNotObtainScreenshot', {screenshotError})}
        {!screenshot && !screenshotError &&
          <Spin size="large" spinning={true}>
            <div className={InspectorStyles.screenshotBox} />
          </Spin>
        }
      </div>
      <div id='sourceTreeContainer' className={InspectorStyles['interaction-tab-container']} >
        {showRecord &&
          <RecordedActions {...this.props} />
        }
        <Tabs activeKey={selectedInteractionMode}
          size="small"
          onChange={(tab) => selectInteractionMode(tab)}>
          <TabPane tab={t('Source')} key={INTERACTION_MODE.SOURCE}>
            <div className='action-row'>
              <div className='action-col'>
                <Card title={<span><Icon type="file-text" /> {t('App Source')}</span>}>
                  <Source {...this.props} />
                </Card>
              </div>
              <div id='selectedElementContainer'
                className={`${InspectorStyles['interaction-tab-container']} ${InspectorStyles['element-detail-container']} action-col`}>
                <Card title={<span><Icon type="tag-o" /> {t('selectedElement')}</span>}
                  className={InspectorStyles['selected-element-card']}>
                  {path && <SelectedElement {...this.props}/>}
                  {!path && <i>{t('selectElementInSource')}</i>}
                </Card>
              </div>
            </div>
          </TabPane>
          <TabPane tab={t('Actions')} key={INTERACTION_MODE.ACTIONS}>
            <Card
              title={<span><Icon type="thunderbolt" /> {t('Actions')}</span>}
              className={InspectorStyles['interaction-tab-card']}>
              <Actions {...this.props} />
            </Card>
          </TabPane>
        </Tabs>
      </div>
    </div>;

    let debuggerControls = <div className={InspectorStyles['debugger-controls']}>
    <ButtonGroup size="large">
      <Tooltip title={t('Step Over')}>
        <Button icon='step-forward' onClick={() => stepOverDebugger()}/>
      </Tooltip>
      <Tooltip title={t('Resume Test')}>
        <Button icon='fast-forward' onClick={() => resumeDebugger()}/>
      </Tooltip>
      <Tooltip title={t('Mute Breakpoints and Resume Test')}>
        <Button icon='forward' onClick={() => muteAndResumeDebugger()}/>
      </Tooltip>
    </ButtonGroup>
    </div>;

    let actionControls = <div className={InspectorStyles['action-controls']}>
      <ButtonGroup size="large" value={screenshotInteractionMode}>
        <Tooltip title={t('Select Elements')}>
          <Button icon='select' onClick={() => {this.screenshotInteractionChange(SELECT);}}
            type={screenshotInteractionMode === SELECT ? 'primary' : 'default'}
          />
        </Tooltip>
        <Tooltip title={t('Swipe By Coordinates')}>
          <Button icon='swap-right' onClick={() => {this.screenshotInteractionChange(SWIPE);}}
            type={screenshotInteractionMode === SWIPE ? 'primary' : 'default'}
          />
        </Tooltip>
        <Tooltip title={t('Tap By Coordinates')}>
          <Button icon='scan' onClick={() => {this.screenshotInteractionChange(TAP);}}
            type={screenshotInteractionMode === TAP ? 'primary' : 'default'}
          />
        </Tooltip>
      </ButtonGroup>
    </div>;

    let controls = <div className={InspectorStyles['inspector-toolbar']}>
      {debuggerControls}
      {actionControls}
      <ButtonGroup size="large">
        <Tooltip title={t('Back')}>
          <Button id='btnGoBack' icon='arrow-left' onClick={() => applyClientMethod({methodName: 'back'})}/>
        </Tooltip>
        <Tooltip title={t('refreshSource')}>
          <Button id='btnReload' icon='reload' onClick={() => applyClientMethod({methodName: 'source'})}/>
        </Tooltip>
        {!isRecording &&
          <Tooltip title={t('Start Recording')}>
            <Button id='btnStartRecording' icon="eye-o" onClick={startRecording}/>
          </Tooltip>
        }
        {isRecording &&
          <Tooltip title={t('Pause Recording')}>
            <Button id='btnPause' icon="pause" type="danger" onClick={pauseRecording}/>
          </Tooltip>
        }
        <Tooltip title={t('Search for element')}>
          <Button id='searchForElement' icon="search" onClick={showLocatorTestModal}/>
        </Tooltip>
        <Tooltip title={t('Copy XML Source to Clipboard')}>
          <CopyToClipboard text={sourceXML}>
            <Button id='btnSourceXML' icon="copy"/>
          </CopyToClipboard>
        </Tooltip>
        <Tooltip title={t('quitSessionAndClose')}>
          <Button id='btnClose' icon='close' onClick={() => quitSession()}/>
        </Tooltip>
      </ButtonGroup>
    </div>;

    return <div className={InspectorStyles['inspector-container']}>
      {controls}
      {main}
      <Modal
        title={t('Session Inactive')}
        visible={showKeepAlivePrompt}
        onOk={() => quitSession()}
        onCancel={() => this.keepSessionAlive()}
        okText={t('Quit Session')}
        cancelText={t('Keep Session Running')}
      >
        <p>{t('Your session is about to expire')}</p>
      </Modal>
    </div>;
  }
}
