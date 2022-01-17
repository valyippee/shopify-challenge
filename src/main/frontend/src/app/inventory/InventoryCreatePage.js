import React, { Component } from 'react';
import { Form } from 'react-bootstrap';
import axios from 'axios'
import { Link } from "react-router-dom";


class InventoryCreatePage extends Component {
    state = {
        name: (typeof this.props.location.state !== 'undefined' ? this.props.location.state.name : ""),
        description: (typeof this.props.location.state !== 'undefined' ? this.props.location.state.description : ""),
        minimumRequired: (typeof this.props.location.state !== 'undefined' ? this.props.location.state.minimumRequired : ""),
        inventoryAtHand: (typeof this.props.location.state !== 'undefined' ? this.props.location.state.inventoryAtHand : ""),
        id: (typeof this.props.location.state !== 'undefined' ? this.props.location.state.productId : ""),
        titleText: (typeof this.props.location.state !== 'undefined' ? "Edit Product Details" : "Create New Product"),
        buttonText: (typeof this.props.location.state !== 'undefined' ? "Edit" : "Submit")
    }

    constructor(props) {
        super(props);
        this.createProduct = this.createProduct.bind(this);
    }

    createProduct(e) {
        e.preventDefault();
        console.log("submit pressed")
        console.log(this.state);
        if (typeof this.props.location.state !== 'undefined') {
            // means it is edit page
            axios.put("/products" + this.state.id, {
                id: this.state.id,
                name: this.state.name,
                description: this.state.description,
                inventoryAtHand: this.state.inventoryAtHand,
                minimumRequired: this.state.minimumRequired
            }).then((response) => console.log(response))
        } else {
            axios.post("/products", {
                name: this.state.name,
                description: this.state.description,
                inventoryAtHand: this.state.inventoryAtHand,
                minimumRequired: this.state.minimumRequired
            }).then((response) => console.log(response));
        }

    }

    render() {
        return (
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
                            <textarea value={this.state.description} onChange={e => this.setState({ description: e.target.value })} className="form-control" id="inputDescription" rows="8"></textarea>
                        </Form.Group>
                        <Form.Group>
                            <label htmlFor="inputMinimumRequired">Minimum Inventory Required</label>
                            <Form.Control value={this.state.minimumRequired} onChange={e => this.setState({ minimumRequired: e.target.value })} type="text" className="form-control" id="inputMinimumRequired" placeholder="Minimum Required" />
                        </Form.Group>
                        <Form.Group>
                            <label htmlFor="inputCurrentInventory">Current Inventory Available</label>
                            <Form.Control value={this.state.inventoryAtHand} onChange={e => this.setState({ inventoryAtHand: e.target.value })} type="text" className="form-control" id="inputCurrentInventory" placeholder="Inventory" />
                        </Form.Group>
                        
                        <button onClick={this.createProduct} type="submit" className="btn btn-primary mr-2"><Link to="/inventory/view" className="btn btn-primary mr-2">{this.state.buttonText}</Link></button>
                        <button className="btn btn-light"><Link to="/inventory/view">Cancel</Link></button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default InventoryCreatePage;