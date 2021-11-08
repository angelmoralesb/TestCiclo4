/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.casa.deportiva.atirodeas.models;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

/**
 *
 * @author ASUS RYZEN
 */
@Document("Product")
public class ProductModel {

    @Id
    private Integer id;
    private String categoria;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private boolean disponibilidad;
    private Integer cantidad;
    private String fotografia;
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return StringUtils.capitalize(categoria);
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria.toLowerCase();
    }

    public String getNombre() {
        return StringUtils.capitalize(nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toLowerCase();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografía) {
        this.fotografia = fotografía;
    }
    
    
}
