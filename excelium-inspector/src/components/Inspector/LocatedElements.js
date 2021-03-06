import React, { Component } from 'react';
import { CopyToClipboard } from 'react-copy-to-clipboard';
import { Input, Row, Col, Button } from 'antd';
import InspectorStyles from './Inspector.module.css';
import { withTranslation } from '../../util';

class LocatedElements extends Component {

  onSubmit () {
    const {locatedElements, locatorTestStrategy, locatorTestValue, searchForElement, clearSearchResults, hideLocatorTestModal} = this.props;
    if (locatedElements) {
      hideLocatorTestModal();
      clearSearchResults();
    } else {
      searchForElement(locatorTestStrategy, locatorTestValue);
    }
  }

  onCancel () {
    const {hideLocatorTestModal, clearSearchResults} = this.props;
    hideLocatorTestModal();
    clearSearchResults();
  }

  render () {
    const {
      locatedElements,
      applyClientMethod,
      setLocatorTestElement,
      locatorTestElement,
      clearSearchResults,
      t,
    } = this.props;

    return <Row>
      <p className={InspectorStyles['back-link-container']}>
        <a href="# " onClick={(e) => e.preventDefault() || clearSearchResults()}>{t('back')}</a>
      </p>
      {t('elementsCount', {elementCount: locatedElements.length})}
      <Col>
        <select className={InspectorStyles['locator-search-results']}
          multiple='true'
          onChange={(e) => setLocatorTestElement(e.target.value)}
          value={[locatorTestElement]}>
          {locatedElements.map((elementId) => (
            <option key={elementId} value={elementId}>{elementId}</option>
          ))}
          {locatedElements.length === 0 && <option disabled>{t('couldNotFindAnyElements')}</option>}
        </select>
        {locatedElements.length > 0 && <div className={InspectorStyles['locator-test-interactions-container']}>
          <div>
            <CopyToClipboard text={locatorTestElement}>
              <Button size='small'
                disabled={!locatorTestElement}
              >
                {t('Copy ID')}
              </Button>
            </CopyToClipboard>
          </div>
          <div>
            <Button size='small'
              disabled={!locatorTestElement}
              onClick={() => applyClientMethod({methodName: 'click', elementId: locatorTestElement, skipScreenshotAndSource: true})}
            >
              {t('Tap Element')}
            </Button>
          </div>
          <div>
            <Button size='small'
              disabled={!locatorTestElement}
              onClick={() => applyClientMethod({methodName: 'clear', elementId: locatorTestElement, skipScreenshotAndSource: true})}
            >
              {t('Clear')}
            </Button>
          </div>
          <div className={InspectorStyles['send-keys-container']}>
            <Input size='small' placeholder={t('Enter keys')} onChange={(e) => this.setState({...this.state, sendKeys: e.target.value})}/>
            <Button size='small'
              disabled={!locatorTestElement}
              onClick={() => applyClientMethod({methodName: 'sendKeys', elementId: locatorTestElement, args: [this.state.sendKeys || ''], skipScreenshotAndSource: true})}
            >
              {t('Send Keys')}
            </Button>
          </div>
        </div>}
      </Col>
    </Row>;
  }
}

export default withTranslation(LocatedElements);