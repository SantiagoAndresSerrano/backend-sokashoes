/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Categoria;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author GénesisDanielaVJ
 */
public interface CategoriaService {
        
    public void guardar(Categoria categoria);
    public void eliminar(int id);
    public Optional<Categoria> encontrar(int id);
    public List<Categoria> listar();
}
