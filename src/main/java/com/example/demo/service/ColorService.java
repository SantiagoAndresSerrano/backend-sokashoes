/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Color;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author GenesisDanielaVJ
 */
public interface ColorService {
        
    public void guardar(Color color);
    public void eliminar(String id);
    public Optional<Color> encontrar(String id);
    public List<Color> listar();
}
