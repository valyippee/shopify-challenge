import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Collapse } from 'react-bootstrap';
import { Trans } from 'react-i18next';

class Sidebar extends Component {
  state = {};

  toggleMenuState(menuState) {
    if (this.state[menuState]) {
      this.setState({[menuState] : false});
    } else if(Object.keys(this.state).length === 0) {
      this.setState({[menuState] : true});
    } else {
      Object.keys(this.state).forEach(i => {
        this.setState({[i]: false});
      });
      this.setState({[menuState] : true});
    }
  }

  componentDidUpdate(prevProps) {
    if (this.props.location !== prevProps.location) {
      this.onRouteChanged();
    }
  }

  onRouteChanged() {
    document.querySelector('#sidebar').classList.remove('active');
    Object.keys(this.state).forEach(i => {
      this.setState({[i]: false});
    });

    const dropdownPaths = [
      {path:'/apps', state: 'appsMenuOpen'},
      {path:'/inventory', state: 'inventoryMenuOpen'},
      {path:'/shipment', state: 'shipmentMenuOpen'},
    ];

    dropdownPaths.forEach((obj => {
      if (this.isPathActive(obj.path)) {
        this.setState({[obj.state] : true})
      }
    }));
 
  } 
  render () {
    return (
      <nav className="sidebar sidebar-offcanvas" id="sidebar">

        <ul className="nav">      
          <li className={ this.isPathActive('/inventory') ? 'nav-item active' : 'nav-item' }>
            <div className={ this.state.inventoryMenuOpen ? 'nav-link menu-expanded' : 'nav-link' } onClick={ () => this.toggleMenuState('inventoryMenuOpen') } data-toggle="collapse">
              <i className="mdi mdi-chart-line menu-icon"></i>
              <span className="menu-title"><Trans>Inventory</Trans></span>
              <i className="menu-arrow"></i>
            </div>
            <Collapse in={ this.state.inventoryMenuOpen }>
              <ul className="nav flex-column sub-menu">
                <li className="nav-item"> <Link className={ this.isPathActive('/inventory/view') ? 'nav-link active' : 'nav-link' } to="/inventory/view"><Trans>View</Trans></Link></li>
              </ul>
            </Collapse>
          </li>

          <li className={ this.isPathActive('/shipment') ? 'nav-item active' : 'nav-item' }>
            <div className={ this.state.shipmentMenuOpen ? 'nav-link menu-expanded' : 'nav-link' } onClick={ () => this.toggleMenuState('shipmentMenuOpen') } data-toggle="collapse">
              <i className="mdi mdi-crosshairs-gps menu-icon"></i>
              <span className="menu-title"><Trans>Shipment</Trans></span>
              <i className="menu-arrow"></i>
            </div>
            <Collapse in={ this.state.shipmentMenuOpen }>
              <ul className="nav flex-column sub-menu">
                <li className="nav-item"> <Link className={ this.isPathActive('/shipment/view') ? 'nav-link active' : 'nav-link' } to="/shipment/view"><Trans>View</Trans></Link></li>
                <li className="nav-item"> <Link className={ this.isPathActive('/shipment/create') ? 'nav-link active' : 'nav-link' } to="/shipment/create"><Trans>Create</Trans></Link></li>
              </ul>
            </Collapse>
          </li>
        </ul>
      </nav>
    );
  }

  isPathActive(path) {
    return this.props.location.pathname.startsWith(path);
  }

  componentDidMount() {
    this.onRouteChanged();
    // add className 'hover-open' to sidebar navitem while hover in sidebar-icon-only menu
    const body = document.querySelector('body');
    document.querySelectorAll('.sidebar .nav-item').forEach((el) => {
      
      el.addEventListener('mouseover', function() {
        if(body.classList.contains('sidebar-icon-only')) {
          el.classList.add('hover-open');
        }
      });
      el.addEventListener('mouseout', function() {
        if(body.classList.contains('sidebar-icon-only')) {
          el.classList.remove('hover-open');
        }
      });
    });
  }

}

export default withRouter(Sidebar);