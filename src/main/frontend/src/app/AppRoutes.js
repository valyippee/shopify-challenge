import React, { Component,Suspense, lazy } from 'react';
import { Switch, Route, Redirect } from 'react-router-dom';

import Spinner from '../app/shared/Spinner';

const InventoryViewPage = lazy(() => import('./inventory/InventoryViewPage'));
const InventoryCreatePage = lazy(() => import('./inventory/InventoryCreatePage'));
const ShipmentViewPage = lazy(() => import('./shipment/ShipmentViewPage'));
const ShipmentCreatePage = lazy(() => import('./shipment/ShipmentCreatePage'));


class AppRoutes extends Component {
  render () {
    return (
      <Suspense fallback={<Spinner/>}>
        <Switch>

          <Route path="/inventory/view" component={ InventoryViewPage } />
          <Route path="/inventory/create" component={ InventoryCreatePage } />

          <Route path="/shipment/view" component={ ShipmentViewPage } />
          <Route path="/shipment/create" component={ ShipmentCreatePage } />
          <Redirect to="/inventory/view" />
        </Switch>
      </Suspense>
    );
  }
}

export default AppRoutes;