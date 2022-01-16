import React, { Component } from 'react';

class ShipmentViewPage extends Component {
  state = {
    shipments: []
  }

  componentDidMount() {
    // axios.get("http://localhost:4567/shipments")
    //   .then(response => {
    //     const products = response.data.data;
    //     this.setState({ products })
    //   }).catch(err => console.log(err))
  }

  renderResultRows() {
    // return this.state.shipments.map((shipment) => {
    //   return (
    //     <tr key={shipment.id}>
    //       <td data-title="Name">{shipment.name}</td>
    //       <td data-title="Description">{shipment.description}</td>
    //       <td data-title="CurrInventory">{shipment.inventoryAtHand}</td>
    //       <td data-title="MinRequired">{shipment.minimumRequired}</td>
    //       <td>
    //         <button type="button" className="btn btn-outline-secondary btn-icon-text">  <i className="mdi mdi-file-check btn-icon-prepend"></i>Edit</button>
    //       </td>
    //       <td>
    //       <button type="button" className="btn btn-outline-danger btn-icon-text"><i className="mdi mdi-delete btn-icon-prepend"></i> Delete </button>
    //       </td>
    //     </tr>
    //   )
    // })
  }

  render() {

    return (
      <div>
        <div className="page-header">
          <h3 className="page-title"> Shipment </h3>
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
                        <th>Current Inventory</th>
                        <th>Minimum Inventory Required</th>
                        <th></th>
                        <th></th>
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