/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.DetalleCompra;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Santi & Dani
 */
public interface DetalleCompraService{
    
    public void guardar(DetalleCompra detalleCompra);
    public Optional<DetalleCompra> encontrar(int id);
    public List<DetalleCompra> listar();
    
}
