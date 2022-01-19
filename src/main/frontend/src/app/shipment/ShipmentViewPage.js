import React, { Component } from 'react';
import axios from 'axios';
import {Link} from "react-router-dom";
import Alert from "react-popup-alert";

class ShipmentViewPage extends Component {
  state = {
      shipments: [],
      products: [],
      alert: {
          type: 'error',
          text: 'This is a alert message',
          show: false
      }
  }

  onShowAlert(type, text) {
      this.setState({
          alert: {
              type: type,
              text: text,
              show: true
          }
      })
  }

  componentDidMount() {

      const requestShipments = axios.get("/shipments");
      const requestProducts = axios.get("/products");

      axios.all([requestShipments, requestProducts])
          .then(axios.spread((...responses) => {
              const shipments = responses[0].data.data;
              const products = responses[1].data.data;
              this.setState({shipments});
              this.setState({products});
              console.log(this.state);
          }))
          .catch(err => {
              if (err.response.status === 400) {
                  this.onShowAlert('error', err.response.data.message);
              } else {
                  this.onShowAlert('error', "Unknown error. Shipments or products could not be loaded. " +
                      "Check if backend server is running on the correct port.")
              }
          });
  }

  renderProductAmount(productAmount) {
      let productArray = [];
      for (let key in productAmount) {
          for (let position in this.state.products) {
              const product = this.state.products[position];
              // note: key is a string, while product id is a number
              if (parseInt(key) === product.id) {
                  console.log("found matching product: " + product.name);
                  console.log("this is for key with value: " + key);
                  productArray.push([key, product.name, productAmount[key]]);
                  break;
              }
          }
      }
      return productArray.map((product) => {
          return (
              <tr key={product[0]}>
                  <td>{product[1]}</td>
                  <td>{product[2]}</td>
              </tr>
          )
      })

  }

  renderResultRows() {
    return this.state.shipments.map((shipment) => {
      return (
        <tr key={shipment.id}>
          <td data-title="Name">{shipment.name}</td>
          <td data-title="Description">{shipment.description}</td>
          <td data-title="Destination">{shipment.destination}</td>
          <td data-title="ProductAmount">
              <table>
                  <thead>
                    <tr>
                        <th>Product</th>
                        <th>Amount</th>
                    </tr>
                  </thead>
                  {this.renderProductAmount(shipment.productAmount)}
              </table>
          </td>
          <td data-title="Status">{shipment.status}</td>
        </tr>
      )
    })
  }

  render() {
    return (
        <div>
            <Alert
                header={'Error'}
                btnText={'Close'}
                text={this.state.alert.text}
                type={this.state.alert.type}
                show={this.state.alert.show}
                onClosePress={() => this.setState({
                    alert: {
                        type: '',
                        text: '',
                        show: false
                    }
                })}
                pressCloseOnOutsideClick={true}
                showBorderBottom={true}
                alertStyles={{}}
                headerStyles={{}}
                textStyles={{}}
                buttonStyles={{background: "#008CBA",
                    border: 'none',
                    color: 'white',
                    padding: '15px 32px',
                    display: 'inline-block',
                    margin: '4px 2px',
                    cursor: 'pointer'
                }}
            />
            <div>
                <div className="page-header">
                    <h3 className="page-title"> Shipment </h3>
                    <Link to="/shipment/create"><button className="btn btn-primary mr-2">Create</button></Link>
                </div>
                <div className="row">
                    <div className="col-lg-12 grid-margin stretch-card">
                        <div className="card">
                            <div className="card-body">
                                <div className="table-responsive">
                                    <table className="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Description</th>
                                            <th>Destination</th>
                                            <th>Products included</th>
                                            <th>Status</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        {
                                            this.renderResultRows()
                                        }
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
  }
}

export default ShipmentViewPage;