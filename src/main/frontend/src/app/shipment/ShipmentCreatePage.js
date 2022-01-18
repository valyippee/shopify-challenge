import React, { Component } from 'react';
import {Form} from "react-bootstrap";
import {Link} from "react-router-dom";
import axios from "axios";
import Alert from "react-popup-alert";

class ShipmentViewPage extends Component {
  state = {
    name: "",
    description: "",
    destination: "",
    productAmount: {},
    alert: {
      type: 'error',
      text: 'This is a alert message',
      show: false
    },
    products: []
  }

  constructor(props) {
    super(props);
    this.createShipment = this.createShipment.bind(this);
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
        this.onShowAlert('error', "Unknown error. Products could not be loaded.")
      }
    });

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

  createShipment(e) {
    console.log(this.state);
    e.preventDefault();
    axios.post("/shipments", {
      name: this.state.name,
      description: this.state.description,
      productAmount: this.state.productAmount,
      destination: this.state.destination
    }).then((response) => {
      console.log(response)
      this.props.history.push('/shipment/view');
    }).catch(err => {
      if (err.response.status === 400) {
        this.onShowAlert('error', err.response.data.message);
      } else {
        this.onShowAlert('error', "Unknown error. Shipment could not be created.")
      }
    });
  }

  renderProducts() {
    return this.state.products.map((product) => {
      return (
          <div>
            <p style={{paddingTop: "25px"}}>{product.name}</p>
            <p>Current inventory of this product: {product.inventoryAtHand}</p>
            <Form.Control onChange={e => this.state.productAmount[product.id] = e.target.value} type="text" className="form-control" id={product.id} placeholder="Amount (enter non-negative values)" />
          </div>
      );
    });
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
          <div className="col-12 grid-margin stretch-card">
            <div className="card">
              <div className="card-body">
                <h4 className="card-title">Create New Shipment</h4>
                <form className="forms-sample">
                  <Form.Group>
                    <label htmlFor="inputName">Name</label>
                    <Form.Control value={this.state.name} onChange={e => this.setState({ name: e.target.value })} type="text" className="form-control" id="inputName" placeholder="Name" />
                  </Form.Group>
                  <Form.Group>
                    <label htmlFor="inputDescription">Description</label>
                    <textarea value={this.state.description} onChange={e => this.setState({ description: e.target.value })} className="form-control" id="inputDescription" rows="8" />
                  </Form.Group>
                  <Form.Group>
                    <label htmlFor="inputDestination">Destination</label>
                    <Form.Control value={this.state.destination} onChange={e => this.setState({ destination: e.target.value })} type="text" className="form-control" id="inputDestination" placeholder="Destination" />
                  </Form.Group>
                  <Form.Group>
                    <label htmlFor="inputProductAmount">Product Amount: For each of the products below, choose an amount to be included in this shipment.</label>
                    {this.renderProducts()}
                  </Form.Group>

                  <button onClick={this.createShipment} type="submit" className="btn btn-primary mr-2">Submit</button>
                  <button className="btn btn-light"><Link to="/shipment/view">Cancel</Link></button>
                </form>
              </div>
            </div>
          </div>
        </div>
    );
  }
}

export default ShipmentViewPage;