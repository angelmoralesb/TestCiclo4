import React, { Component } from 'react'
import ProductService from '../services/ProductService';
import Image from './ImageComponent';
class CatalogProductComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            products: [],
            categorias: [],
            nombre: "",
            categoria: "",
            precio: ""
        }
    }

    componentDidMount() {
        ProductService.getProducts().then((res) => {
            this.setState({ products: res.data });
            this.setState({ nombre: "" });
            this.setState({ precio: "" });
        });

        ProductService.getCategories().then((res) => {
            this.setState({ categorias: res.data });
        });

        this.componentDidMount= this.componentDidMount.bind(this);
        this.findByNombreContaining = this.findByNombreContaining.bind(this);
        this.findByCategoria = this.findByCategoria.bind(this);
        this.findByPrecioLessThanEqual = this.findByPrecioLessThanEqual.bind(this);
    }

    findByNombreContaining = (e) => {
        e.preventDefault();
        ProductService.findByNombreContaining(this.state.nombre).then((res) => {
            this.setState({ products: res.data });
        });

    }

    findByCategoria = (e) => {
        e.preventDefault();
        ProductService.findByCategoria(this.state.categoria).then((res) => {
            this.setState({ products: res.data });
        });
    }
    
    findByPrecioLessThanEqual = (e) => {
        e.preventDefault();
        ProductService.findByPrecioLessThanEqual(this.state.precio).then((res) => {
            this.setState({ products: res.data });
        });
    }

    changeNombreHandler = (event) => {
        this.setState({ nombre: event.target.value });
    }

    changeCategoriaHandler = (event) => {
        this.setState({ categoria: event.target.value.toLowerCase() });
    }

    changePrecioHandler = (event) => {
        this.setState({ precio: event.target.value });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Catalogo de productos</h2>
                <div className="row">
              
                </div>
                <div className="mb-3 row">
                    <label className="col-sm-3 col-form-label">Busqueda por menor precio</label>
                    <div className="col-sm-4">
                        <input type="text"  value={this.state.precio}  onChange={this.changePrecioHandler} className="form-control" placeholder="precio" />
                    </div>
                    <div className="col-sm-4">
                    <button className="btn btn-success" onClick={this.findByPrecioLessThanEqual}>Aceptar</button>
                    </div>
                </div>

                <div className="mb-3 row">
                    <label className="col-sm-3 col-form-label">Busqueda x categorias</label>
                    <div className="col-sm-4">
                        <select type="text" name={this.state.categoria}  onChange={this.changeCategoriaHandler} className="form-control" placeholder="categoria" >
                            <option value="">Seleccione una categoria</option>
                            {this.state.categorias.map((categoria) => {
                                return (
                                    <option key={categoria.id} value={categoria.nombre}>{categoria.nombre}</option>
                                )
                            })}
                        </select>
                    </div>
                    <div className="col-sm-4">
                    <button className="btn btn-success" onClick={this.findByCategoria}>Aceptar</button>
                    </div>
                </div>
                <div className="mb-3 row">
                    <label className="col-sm-3 col-form-label">Busqueda x nombre</label>
                    <div className="col-sm-4">
                    <input type="text"  value={this.state.nombre}  onChange={this.changeNombreHandler} className="form-control" placeholder="nombre" />
                    </div>
                    <div className="col-sm-4">
                    <button className="btn btn-success" onClick={this.findByNombreContaining}>Aceptar</button>
                    </div>
                    <button className="btn btn-info" onClick={this.componentDidMount}>Todos</button>
                </div>
               
                <br></br>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> Nombre</th>
                                <th> Categoria</th>
                                <th> Disponible</th>
                                <th> Precio</th>
                                <th> Stock</th>
                                <th> Imagen</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.products.map(
                                    product =>
                                        <tr key={product.id}>
                                            <td> {product.nombre} </td>
                                            <td> {product.categoria}</td>
                                            <td> {product.disponibilidad === true ? "si" : "no"}</td>
                                            <td> {product.precio}</td>
                                            <td> {product.cantidad}</td>
                                            <td> <Image src={product.fotografia} /></td>
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

export default CatalogProductComponent

