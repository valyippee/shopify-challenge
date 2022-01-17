import React, { Component } from 'react';
import axios from 'axios';
import {Link} from "react-router-dom";

class ShipmentViewPage extends Component {
  state = {
    shipments: [],
      product: []
  }

  componentDidMount() {
    axios.get("/shipments")
      .then(response => {
        const shipments = response.data.data;
        this.setState({ shipments })
      }).catch(err => console.log(err))
  }

  getProductName(id) {
      axios.get("/products" + id)
          .then(response => {
              const product = response.data.data;
              this.setState({ product })
          }).catch(err => console.log(err))
  }

  renderProductAmount(productAmount) {
      // return productAmount.map((product) => {
      //     this.getProductName(product.id);
      //     return (
      //         <tr key={product.id}>
      //             <td data-title="ProductName">{this.state.product.name}</td>
      //             <td data-title="Amount">{product.amount}</td>
      //         </tr>
      //     )
      // })
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
                  {this.renderProductAmount(shipment.productAmount)}
              </table>
          </td>
        </tr>
      )
    })
  }

  render() {

    return (
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
    )
  }
}

export default ShipmentViewPage;