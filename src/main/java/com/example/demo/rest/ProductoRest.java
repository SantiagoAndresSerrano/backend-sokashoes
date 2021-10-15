/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.rest;

import com.example.demo.model.Categoria;
import com.example.demo.model.Producto;
import com.example.demo.negocio.NorteXploradores;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author Santi & Dani
 */
@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200/")
@Slf4j
public class ProductoRest {

    @Autowired
    ProductoService pser;

    @Autowired
    CategoriaService cser;

    NorteXploradores nexp = new NorteXploradores();

    @GetMapping
    public ResponseEntity<List<Producto>> getProducto() {
        return ResponseEntity.ok(pser.listar());
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody @Valid Producto p, BindingResult br) {

        if (br.hasErrors()) {
            return new ResponseEntity<List<ObjectError>>(br.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Categoria categoria = cser.encontrar(p.getCategoria().getIdCategoria()).orElse(null);
        if (categoria == null) {
            return new ResponseEntity<ObjectError>(new ObjectError("id", "La categoria no existe"), HttpStatus.NOT_FOUND);
        }
        p.setCategoria(categoria);
        pser.guardar(p);
        return ResponseEntity.ok(p);
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody @Valid Producto p, BindingResult br){
        if (br.hasErrors()) {
            return new ResponseEntity<List<ObjectError>>(br.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Producto producto = pser.encontrar(p.getIdProducto()).orElse(null);
        if(producto ==null){
            return new ResponseEntity("Producto no existe",HttpStatus.NOT_FOUND);
        }
        pser.guardar(p);
        return ResponseEntity.ok(pser.encontrar(p.getIdProducto()));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable int id) {

        Producto p = pser.encontrar(id).orElse(null);
        if(p == null){
            return new ResponseEntity("El producto no fue encontrado", HttpStatus.NOT_FOUND);
        }
        pser.eliminar(id);

        return ResponseEntity.ok(p);
    }

    
}
