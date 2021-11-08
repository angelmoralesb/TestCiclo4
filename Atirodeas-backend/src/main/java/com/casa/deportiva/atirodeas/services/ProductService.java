/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.casa.deportiva.atirodeas.services;

import com.casa.deportiva.atirodeas.models.ProductModel;
import com.casa.deportiva.atirodeas.repositories.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS RYZEN
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductModel> getById(Integer id) {
        return productRepository.getById(id);
    }

    public ProductModel save(ProductModel productModel) {

        if (productModel.getId() == null) {
            return productRepository.save(productModel);
        }

        return null;
    }

    public ProductModel update(ProductModel productModel) {

        if (productModel.getId() != null) {
            return productRepository.update(productModel);
        }

        return null;
    }

    public void delete(ProductModel productModel) {
        productRepository.delete(productModel);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    public List<ProductModel> findByNombreContaining(String nombre) {
        return productRepository.findByNombreContaining(nombre);
    }

    public List<ProductModel> findByCategoria(String categoria) {
        return productRepository.findByCategoria(categoria);
    }

    public List<ProductModel> findByPrecioLessThanEqual(BigDecimal precio) {
        return productRepository.findByPrecioLessThanEqual(precio);
    }
    
    public void saveAll(List<ProductModel> products) {
        productRepository.saveAll(products);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }
}
