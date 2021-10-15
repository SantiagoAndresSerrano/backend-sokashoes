/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Producto;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author GénesisDanielaVJ
 */
public interface ProductoService {
        
    public void guardar(Producto persona);
    public void eliminar(int id);
    public Optional<Producto> encontrar(int id);
    public List<Producto> listar();
}
