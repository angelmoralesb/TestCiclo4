/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.casa.deportiva.atirodeas.repositories.CRUD;


import com.casa.deportiva.atirodeas.models.CategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ASUS RYZEN
 */
public interface ICategoryCrudRepository extends MongoRepository<CategoryModel, Integer>{
    
}
