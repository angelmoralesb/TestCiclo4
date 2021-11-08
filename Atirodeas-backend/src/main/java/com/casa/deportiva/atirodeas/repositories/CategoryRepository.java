/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.casa.deportiva.atirodeas.repositories;


import com.casa.deportiva.atirodeas.models.CategoryModel;
import com.casa.deportiva.atirodeas.repositories.CRUD.ICategoryCrudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS RYZEN
 */
@Repository
public class CategoryRepository {
    
    @Autowired
    private ICategoryCrudRepository categoryCrudRepository;

    public List<CategoryModel> getAll() {
        return categoryCrudRepository.findAll();
    }
    
     public CategoryModel save(CategoryModel categoriaModel) {
       
        categoriaModel.setId((int)categoryCrudRepository.count()+1);
        return categoryCrudRepository.save(categoriaModel);
    }
    
}
