import React, { Component } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom';
import Alert from "react-popup-alert";

export class InventoryViewPage extends Component {

  state = {
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
    axios.get("/products")
      .then(response => {
        console.log(response);
        const products = response.data.data;
        this.setState({ products });
      }).catch(err => {
        if (err.response.status === 400) {
            this.onShowAlert('error', err.response.data.message);
        } else {
            this.onShowAlert('error', "Unknown error. Products could not be loaded. " +
                "Check if backend server is running on the correct port.")
        }
    });
  }

  deleteProduct(productId) {
      axios.delete("/products/" + productId)
        .then(response => {
          console.log(response);
          window.location.reload();
        })
  }


  renderResultRows() {
    return this.state.products.map((product) => {
      return (
        <tr key={product.id}>
          <td data-title="Name">{product.name}</td>
          <td data-title="Description">{product.description}</td>
          <td data-title="CurrInventory">{product.inventoryAtHand}</td>
          <td data-title="MinRequired">{product.minimumRequired}</td>
          <td>
            <button type="button" className="btn btn-outline-secondary btn-icon-text">
                <Link to={{
                pathname: "/inventory/create",
                state: {name: product.name,
                        description: product.description,
                        minimumRequired: product.minimumRequired,
                        inventoryAtHand: product.inventoryAtHand,
                        id: product.id
                      }
                }}>
                <i className="mdi mdi-file-check btn-icon-prepend"/>Edit
                </Link>
            </button>
          </td>
          <td>
            <button onClick={() => this.deleteProduct(product.id)} type="button" className="btn btn-outline-danger btn-icon-text"><i className="mdi mdi-delete btn-icon-prepend"></i> Delete </button>
          </td>
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
                    <h3 className="page-title"> Inventory </h3>
                    <Link to="/inventory/create"><button className="btn btn-primary mr-2">Create</button></Link>
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
                                            <th/>
                                            <th/>
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

export default InventoryViewPage;