import { combineReducers } from 'redux';
import { connectRouter } from 'connected-react-router';
import inspector from './Inspector';

// create our root reducer
export default function createRootReducer (history) {
  return combineReducers({
    router: connectRouter(history),
    inspector,
  });
}
