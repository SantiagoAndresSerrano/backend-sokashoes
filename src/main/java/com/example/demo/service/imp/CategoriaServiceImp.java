/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.imp;

import com.example.demo.dao.CategoriaDAO;
import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;
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
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    CategoriaDAO cDAO;

    @Override
    @Transactional
    public void guardar(Categoria categoria) {
        cDAO.save(categoria);
    }

    @Override
    @Transactional(readOnly = true )
    public Optional<Categoria> encontrar(int id) { return cDAO.findById(id);}

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listar() {
        return cDAO.findAll();
    }

    @Override
    public void eliminar(int id) {
        cDAO.deleteById(id);
    }
    
}
