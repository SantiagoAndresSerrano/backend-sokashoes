/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.imp;

import com.example.demo.dao.PersonaDAO;
import com.example.demo.dao.ProductoDAO;
import com.example.demo.model.Persona;
import com.example.demo.model.Producto;
import com.example.demo.service.PersonaService;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author GenesisDanielaVJ
 */
@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    ProductoDAO pDAO;

    @Override
    @Transactional
    public void guardar(Producto producto) {
        pDAO.save(producto);
    }

    @Override
    @Transactional(readOnly = true )
    public Optional<Producto> encontrar(int id) { return pDAO.findById(id);}

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listar() {
        return pDAO.findAll();
    }

    @Override
    public void eliminar(int id) {
        pDAO.deleteById(id);
    }
    
}
