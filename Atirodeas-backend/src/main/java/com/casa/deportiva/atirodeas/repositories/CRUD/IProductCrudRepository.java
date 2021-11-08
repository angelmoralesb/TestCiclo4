/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.casa.deportiva.atirodeas.repositories.CRUD;

import com.casa.deportiva.atirodeas.models.ProductModel;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ASUS RYZEN
 */
public interface IProductCrudRepository extends MongoRepository<ProductModel, Integer>{
    
  public List<ProductModel> findByNombreContaining(String nombre);
  public List<ProductModel> findByCategoria(String categoria);
  //@Query("{'precio' : {'$lte' : ?0}}")
  public List<ProductModel> findByPrecioLessThanEqual(BigDecimal precio);
}
