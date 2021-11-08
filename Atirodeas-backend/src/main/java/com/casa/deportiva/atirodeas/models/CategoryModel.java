/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.casa.deportiva.atirodeas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

/**
 *
 * @author ASUS RYZEN
 */
@Document("Category")
public class CategoryModel {
    
    @Id
    private Integer id;
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return  StringUtils.capitalize(nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toLowerCase();
    }
    
}
