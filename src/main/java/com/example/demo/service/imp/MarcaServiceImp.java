/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.imp;

import com.example.demo.dao.MarcaDAO;
import com.example.demo.model.Marca;
import com.example.demo.model.Marca;
import com.example.demo.service.MarcaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Santi & Dani
 */
@Service
public class MarcaServiceImp implements MarcaService {

    @Autowired
    MarcaDAO cDAO;
    
    
    @Override
    @Transactional
    public void guardar(Marca marca) {
        cDAO.save(marca);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        cDAO.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true )
    public Optional<Marca> encontrar(int id) {
        return cDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Marca> listar() {
        return cDAO.findAll();
    }


    
}
