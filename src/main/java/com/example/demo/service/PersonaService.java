/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Persona;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Santi & Dani
 */
public interface PersonaService {
        
    public void guardar(Persona persona);
    public void eliminar(int id);
    public Optional<Persona> encontrar(int id);
    public List<Persona> listar();
}
