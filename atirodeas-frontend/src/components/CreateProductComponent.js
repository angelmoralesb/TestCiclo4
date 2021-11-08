import React, { Component } from 'react'
import ProductService from '../services/ProductService'
const options = [
    { value: false, label: 'NO' },
    { value: true, label: 'SI' },
]

class CreateProductComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            nombre: '',
            categoria: '',
            disponibilidad: true,
            precio: 0,
            cantidad: 0,
            descripcion: '',
            imagen: ''
        }


        this.saveOrUpdateProduct = this.saveOrUpdateProduct.bind(this);
    }


    // step 3
    componentDidMount() {

        // step 4
        if (this.state.id === '_add') {
            return
        } else {
            ProductService.getProductById(this.state.id).then((res) => {
                let product = res.data;
                this.setState({
                    nombre: product.nombre,
                    categoria: product.categoria,
                    disponibilidad: product.disponibilidad,
                    precio: product.precio,
                    cantidad: product.cantidad,
                    descripcion: product.descripcion,
                    fotografia: product.fotografia
                });
            });
        }
    }
    saveOrUpdateProduct = (e) => {
        e.preventDefault();
        let product = {
            id: this.state.id,
            nombre: this.state.nombre,
            categoria: this.state.categoria,
            disponibilidad: this.state.disponibilidad,
            precio: this.state.precio,
            cantidad: this.state.cantidad,
            descripcion: this.state.descripcion,
            fotografia: this.state.fotografia
        };
        console.log('product => ' + JSON.stringify(product));

        // step 5
        if (this.state.id === '_add') {
            ProductService.createProduct(product).then(res => {
                this.props.history.push('/products');
            });
        } else {
            ProductService.updateProduct(product).then(res => {
                this.props.history.push('/products');
            });
        }
    }

    changeNombreHandler = (event) => {
        this.setState({ nombre: event.target.value });
    }

    changeCategoriaHandler = (event) => {
        this.setState({ categoria: event.target.value });
    }

    changeDisponibilidadHandler = (event) => {
        this.setState({ disponibilidad: event.target.value });
    }

    changePrecioHandler = (event) => {
        this.setState({ precio: event.target.value });
    }

    changeCantidadHandler = (event) => {
        this.setState({ cantidad: event.target.value });
    }

    changeDescripcionHandler = (event) => {
        this.setState({ descripcion: event.target.value });
    }

    changeFotografiaHandler = (event) => {
        this.setState({ fotografia: event.target.value });
    }
    changeFotografiaHandler

    cancel() {
        this.props.history.push('/products');
    }

    getTitle() {
        if (this.state.id === '_add') {
            return <h3 className="text-center">Add Product</h3>
        } else {
            return <h3 className="text-center">Actualizar Producto</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            {
                                this.getTitle()
                            }
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label> Nombre: </label>
                                        <input placeholder="Nombre" name="nombre" className="form-control"
                                            value={this.state.nombre} onChange={this.changeNombreHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Categoria: </label>
                                        <input placeholder="Categoria" name="categoria" className="form-control"
                                            value={this.state.categoria} onChange={this.changeCategoriaHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Disponiblilidad: </label>
                                        <select options={options} name="disponiblilidad" className="form-control"
                                            value={this.state.disponibilidad} onChange={this.changeDisponibilidadHandler}>
                                            <option value="true">SI</option>
                                            <option value="false">NO</option>
                                        </select>
                                    </div>
                                    <div className="form-group">
                                        <label> Precio: </label>
                                        <input placeholder="precio" name="precio" className="form-control"
                                            value={this.state.precio} onChange={this.changePrecioHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Cantidad: </label>
                                        <input placeholder="cantidad" name="cantidad" className="form-control"
                                            value={this.state.cantidad} onChange={this.changeCantidadHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Descripcion: </label>
                                        <input placeholder="descripcion" name="descripcion" className="form-control"
                                            value={this.state.descripcion} onChange={this.changeDescripcionHandler} />
                                    </div>

                                    <div className="form-group">
                                        <label> Fotografia: </label>
                                        <input placeholder="fotografia" name="fotografia" className="form-control"
                                            value={this.state.fotografia} onChange={this.changeFotografiaHandler} />
                                    </div>

                                    <button className="btn btn-success" onClick={this.saveOrUpdateProduct}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default CreateProductComponent
