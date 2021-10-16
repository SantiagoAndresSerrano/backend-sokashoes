/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Talla;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author GenesisDanielaVJ
 */
public interface TallaService {
        
    public void guardar(Talla talla);
    public void eliminar(int id);
    public Optional<Talla> encontrar(int id);
    public List<Talla> listar();
}
