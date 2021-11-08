import axios from 'axios';

const PRODUCT_API_BASE_URL = "http://localhost:8080/api/product";

const CATEGORY_API_BASE_URL = "http://localhost:8080/category";

class ProductService {

    getProducts(){
        return axios.get(PRODUCT_API_BASE_URL+'/all');
    }

    createProduct(employee){
        return axios.post(PRODUCT_API_BASE_URL+"/save", employee);
    }

    getProductById(productId){
        return axios.get(PRODUCT_API_BASE_URL + '/' + productId);
    }

    updateProduct(product){
        return axios.put(PRODUCT_API_BASE_URL + '/update' , product);
    }

    deleteProduct(productId){
        return axios.delete(PRODUCT_API_BASE_URL + '/delete/' + productId);
    }

    findByNombreContaining(nombre){
        return axios.get(PRODUCT_API_BASE_URL + '/nombre/' + nombre);
    }
    findByCategoria(categoria){
        return axios.get(PRODUCT_API_BASE_URL + '/categoria/' + categoria);
    }
    findByPrecioLessThanEqual(precio){
        return axios.get(PRODUCT_API_BASE_URL + '/menorprecio/' + precio);
    }

    getCategories(){
        return axios.get(CATEGORY_API_BASE_URL +'/all');
    }
}

export default new ProductService()