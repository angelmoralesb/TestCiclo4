/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.casa.deportiva.atirodeas.controllers;

import com.casa.deportiva.atirodeas.models.ProductModel;
import com.casa.deportiva.atirodeas.services.ProductService;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ASUS RYZEN
 */
@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<ProductModel> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductModel getById(@PathVariable Integer id) {
        return productService.getById(id).get();
    }

    @PutMapping("/update")
    public ResponseEntity<ProductModel> put(@RequestBody ProductModel productModel) {
        ProductModel productModelupdate = productService.update(productModel);

        if (productModelupdate == null) {
            return new ResponseEntity(productModelupdate, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(productModelupdate, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductModel> post(@RequestBody ProductModel productModel) {
        ProductModel productModelcreate = productService.save(productModel);

        if (productModelcreate == null) {
            return new ResponseEntity(productModelcreate, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(productModelcreate, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        productService.deleteById(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/nombre/{nombre}")
    public List<ProductModel> findByNombreContaining(@PathVariable String nombre) {
        return productService.findByNombreContaining(nombre);
    }

    @GetMapping("/categoria/{categoria}")
    public List<ProductModel> findByCategoria(@PathVariable String categoria) {
        return productService.findByCategoria(categoria);
    }

    @GetMapping("/menorprecio/{precio}")
    public List<ProductModel> findByPrecioLessThanEqual(@PathVariable BigDecimal precio) {
        return productService.findByPrecioLessThanEqual(precio);
    }
}
