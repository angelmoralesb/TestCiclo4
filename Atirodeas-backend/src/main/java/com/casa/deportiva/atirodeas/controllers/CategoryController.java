/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.casa.deportiva.atirodeas.controllers;

import com.casa.deportiva.atirodeas.models.CategoryModel;
import com.casa.deportiva.atirodeas.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ASUS RYZEN
 */
@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryModel> getAll() {
        return categoryService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryModel> post(@RequestBody CategoryModel categoryModel) {
        CategoryModel productModelcreate = categoryService.save(categoryModel);

        if (productModelcreate == null) {
            return new ResponseEntity(productModelcreate, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(productModelcreate, HttpStatus.CREATED);
    }
}
