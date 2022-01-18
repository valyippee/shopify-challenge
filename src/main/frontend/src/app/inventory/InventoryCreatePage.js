import React, { Component } from 'react';
import { Form } from 'react-bootstrap';
import axios from 'axios';
import { Link } from "react-router-dom";
import Alert from 'react-popup-alert';


class InventoryCreatePage extends Component {
    state = {
        name: (typeof this.props.location.state !== 'undefined' ? this.props.location.state.name : ""),
        description: (typeof this.props.location.state !== 'undefined' ? this.props.location.state.description : ""),
        minimumRequired: (typeof this.props.location.state !== 'undefined' ? this.props.location.state.minimumRequired : ""),
        inventoryAtHand: (typeof this.props.location.state !== 'undefined' ? this.props.location.state.inventoryAtHand : ""),
        id: (typeof this.props.location.state !== 'undefined' ? this.props.location.state.id : ""),
        titleText: (typeof this.props.location.state !== 'undefined' ? "Edit Product Details" : "Create New Product"),
        buttonText: (typeof this.props.location.state !== 'undefined' ? "Edit" : "Submit"),
        alert: {
            type: 'error',
            text: 'This is a alert message',
            show: false
        }
    }

    constructor(props) {
        super(props);
        this.createProduct = this.createProduct.bind(this);
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

    createProduct(e) {
        e.preventDefault();
        if (typeof this.props.location.state !== 'undefined') {
            // means it is edit page
            axios.put("/products/" + this.state.id, {
                id: this.state.id,
                name: this.state.name,
                description: this.state.description,
                inventoryAtHand: this.state.inventoryAtHand,
                minimumRequired: this.state.minimumRequired
            }).then((response) => {
                console.log(response)
                this.props.history.push('/inventory/view');
            }).catch(err => {
                if (err.response.status === 400) {
                    this.onShowAlert('error', err.response.data.message);
                } else {
                    this.onShowAlert('error', "Unknown error. Product details could not be updated.")
                }
            });
        } else {
            axios.post("/products", {
                name: this.state.name,
                description: this.state.description,
                inventoryAtHand: this.state.inventoryAtHand,
                minimumRequired: this.state.minimumRequired
            }).then((response) => {
                console.log(response)
                this.props.history.push('/inventory/view');
            }).catch(err => {
                if (err.response.status === 400) {
                    this.onShowAlert('error', err.response.data.message);
                } else {
                    this.onShowAlert('error', "Unknown error. Product could not be created.")
                }
            });
        }
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

                    <div className="col-12 grid-margin stretch-card">
                        <div className="card">
                            <div className="card-body">
                                <h4 className="card-title">{this.state.titleText}</h4>
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
                                        <label htmlFor="inputMinimumRequired">Minimum Inventory Required</label>
                                        <Form.Control value={this.state.minimumRequired} onChange={e => this.setState({ minimumRequired: e.target.value })} type="text" className="form-control" id="inputMinimumRequired" placeholder="Minimum Required" />
                                    </Form.Group>
                                    <Form.Group>
                                        <label htmlFor="inputCurrentInventory">Current Inventory Available</label>
                                        <Form.Control value={this.state.inventoryAtHand} onChange={e => this.setState({ inventoryAtHand: e.target.value })} type="text" className="form-control" id="inputCurrentInventory" placeholder="Inventory" />
                                    </Form.Group>

                                    {/*<button onClick={this.createProduct} type="submit" className="btn btn-primary mr-2"><Link to="/inventory/view" className="btn btn-primary mr-2">{this.state.buttonText}</Link></button>*/}
                                    <button onClick={this.createProduct} type="submit" className="btn btn-primary mr-2">{this.state.buttonText}</button>
                                    <button className="btn btn-light"><Link to="/inventory/view">Cancel</Link></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        );
    }
}

export default InventoryCreatePage;