/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.casa.deportiva.atirodeas.repositories;

import com.casa.deportiva.atirodeas.models.ProductModel;
import com.casa.deportiva.atirodeas.repositories.CRUD.IProductCrudRepository;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS RYZEN
 */
@Repository
public class ProductRepository {

    @Autowired
    private IProductCrudRepository productCrudRepository;

    public List<ProductModel> getAll() {
        return productCrudRepository.findAll();
    }

    public Optional<ProductModel> getById(Integer id) {
        return productCrudRepository.findById(id);
    }

    public ProductModel save(ProductModel productModel) {

        productModel.setId((int) productCrudRepository.count() + 1);
        return productCrudRepository.save(productModel);
    }

    public ProductModel update(ProductModel productModel) {
        return productCrudRepository.save(productModel);
    }

    public void delete(ProductModel productModel) {
        productCrudRepository.delete(productModel);
    }

    public void deleteById(int id) {
        productCrudRepository.deleteById(id);
    }

    public List<ProductModel> findByNombreContaining(String nombre) {
        return productCrudRepository.findByNombreContaining(nombre);
    }

    public List<ProductModel> findByCategoria(String categoria) {
        return productCrudRepository.findByCategoria(categoria);
    }

    public List<ProductModel> findByPrecioLessThanEqual(BigDecimal precio) {
        return productCrudRepository.findByPrecioLessThanEqual(precio);
    }

    public void saveAll(List<ProductModel> products) {
        productCrudRepository.saveAll(products);
    }

    public void deleteAll() {
        productCrudRepository.deleteAll();
    }

}
