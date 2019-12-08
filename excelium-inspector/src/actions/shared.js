import { notification } from 'antd';
import i18n from '../configs/i18next.config';
import _ from 'lodash';
import Promise from 'bluebird';

function hasValue (val) {
  let hasVal = false;
  // avoid incorrectly evaluating `0` as false
  if (_.isNumber(val)) {
    hasVal = !_.isNaN(val);
  } else {
    hasVal = !_.isUndefined(val) && !_.isNull(val);
  }

  return hasVal;
}

export function callClientMethod (sessionId, params) {
  const searchParams = Object.keys(params).map((key) => {
    return encodeURIComponent(key) + '=' + encodeURIComponent(key === 'args' ? JSON.stringify(params[key]) : params[key]);
  }).join('&');

  return new Promise((resolve, reject) => {
    fetch('/api/session/execute', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8',
        'Accept': 'application/json; charset=utf-8',
      },
      body: `sessionId=${encodeURIComponent(sessionId)}&${searchParams}`
    })
    .then(res => res.json())
    .then(resp => {
      if (resp.e) {
        reject({message: resp.e});
      } else {
        // Rename 'id' to 'elementId'
        let {res, methodName} = resp;
  
        // Ignore empty objects
        if (_.isObject(res) && _.isEmpty(res)) {
          res = null;
        }
  
        const truncatedResult = _.truncate(JSON.stringify(res), {length: 2000});
  
        if (hasValue(res) && !resp.ignoreResult) {
          notification.success({
            message: i18n.t('methodCallResult', {methodName}),
            description: i18n.t('commandWasReturnedWithResult', {result: truncatedResult}),
            duration: 15,
          });
        }
        resp.elementId = resp.id;
        resolve(resp);
      }
    })
    .catch(e => reject(e));
  });
}
