import React, { Component } from 'react'
import ProductService from '../services/ProductService'
class ListProductComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            products: []
        }
        //this.addEmployee = this.addEmployee.bind(this);
        this.editProduct = this.editProduct.bind(this);
        this.deleteProduct = this.deleteProduct.bind(this);
    }

    deleteProduct(id) {
        ProductService.deleteProduct(id).then(res => {
            this.setState({ products: this.state.products.filter(product => product.id !== id) });
        });
    }
   
    editProduct(id) {
        this.props.history.push(`/add-product/${id}`);
    }

    componentDidMount() {
        ProductService.getProducts().then((res) => {
            this.setState({ products: res.data });
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Listado de productos</h2>
                <div className="row">

                </div>
                <br></br>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> Editar</th>
                                <th> Eliminar</th>
                                <th> Nombre</th>
                                <th> Categoria</th>
                                <th> Disponible</th>
                                <th> Precio</th>
                                <th> Stock</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.products.map(
                                    product =>
                                        <tr key={product.id}>
                                            <td>
                                                <button onClick={() => this.editProduct(product.id)} className="btn btn-info">Editar</button>
                                            </td>
                                            <td>
                                            <button style={{ marginLeft: "10px" }} onClick={() => this.deleteProduct(product.id)} className="btn btn-danger">Eliminar</button>
                                       </td>
                                            <td> {product.nombre} </td>
                                            <td> {product.categoria}</td>
                                            <td> {product.disponibilidad === true ? "si" : "no"}</td>
                                            <td> {product.precio}</td>
                                            <td> {product.cantidad}</td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ListProductComponent
