import './App.css';
import React, { Component } from 'react';
import ListProductComponent from './components/ListProductComponent';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom'
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateProductComponent from './components/CreateProductComponent';
import CatalogProductComponent from './components/CatalogProductComponent';
class App extends Component {
  render() {
    return (
      <div className="page-container"> 
        <Router>
          <HeaderComponent />
            <div className="container content-wrap">
              <br />
              <Link className="link" to="/">Listado de productos</Link>
              <Link className="link" to="/catalogo">Catalogo de productos</Link>
              <Switch>
                <Route path="/" exact component={ListProductComponent}></Route>
                <Route path="/products" component={ListProductComponent}></Route>
                <Route path="/add-product/:id" component={CreateProductComponent}></Route>
                <Route path="/catalogo" component={CatalogProductComponent}></Route>
              </Switch>
            </div>
            <FooterComponent />
        </Router>
      </div>

    );
  }
}

export default App;
