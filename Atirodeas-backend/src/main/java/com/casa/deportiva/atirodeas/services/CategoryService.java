/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.casa.deportiva.atirodeas.services;


import com.casa.deportiva.atirodeas.models.CategoryModel;
import com.casa.deportiva.atirodeas.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS RYZEN
 */
@Service
public class CategoryService {
    
        
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAll() {
        return categoryRepository.getAll();
    }
    
     public CategoryModel save(CategoryModel categoriaModel) {
        return categoryRepository.save(categoriaModel);
    }
}
