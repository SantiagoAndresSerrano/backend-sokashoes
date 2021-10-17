/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Marca;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author santi
 */
public interface MarcaService {
    public void guardar(Marca marca);
    public Optional<Marca> encontrar(int id);
    public void eliminar(int id);
    public List<Marca> listar();
}
