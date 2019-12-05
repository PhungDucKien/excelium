import React, { Suspense } from 'react';
import { Switch, Route } from 'react-router';
import App from './containers/App';
import InspectorPage from './containers/InspectorPage';
import Spinner from './components/Spinner/Spinner';

export default () => (
  <Suspense fallback={<Spinner />}>
    <App>
      <Switch>
        <Route path="/inspector" component={InspectorPage} />
      </Switch>
    </App>
  </Suspense>
);
