/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springboot/CmdLineRunner.java to edit this template
 */
package com.casa.deportiva.atirodeas;

import com.casa.deportiva.atirodeas.models.ProductModel;
import com.casa.deportiva.atirodeas.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author ASUS RYZEN
 */
@Component
public class InitData implements CommandLineRunner {

    @Autowired
    ProductService productService;

    @Override
    public void run(String... strings) throws Exception {

            productService.deleteAll();
            System.out.println("Eliminando datos...");
            InputStream inJson = ProductModel.class.arrayType().getResourceAsStream("/data.json");
            System.out.println("Leyendo archivo de datos...");
            ProductModel[] products =( ProductModel[]) new ObjectMapper().readValue(inJson, ProductModel.class.arrayType());
             System.out.println("Cargando datos a mongo...");
            productService.saveAll(Arrays.asList(products));
            System.out.println("Datos cargados...");
    }

}
