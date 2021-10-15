/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.service;

/**
 *
 * @author santi
 */

import com.example.demo.security.entity.Usuario;
import com.example.demo.security.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByUsername(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByUsername(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    
    
     @Transactional(readOnly = true)
    public boolean getExisteEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public boolean existsByUsername(String email){
        return usuarioRepository.existsByUsername(email);
    }


    @Transactional
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).get();
    }

    @Transactional
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Transactional
    public void eliminar(int id) {
        usuarioRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> encontrar(int id) {
        return usuarioRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
    
}