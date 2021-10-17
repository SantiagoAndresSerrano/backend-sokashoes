/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.rest;

import com.example.demo.model.Compra;
import com.example.demo.negocio.NorteXploradores;
import com.example.demo.security.model.Usuario;
import com.example.demo.security.servicio.UsuarioService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Santi & Dani
 */
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
@Slf4j
public class UsuarioRest {

    @Autowired
    UsuarioService user;

    NorteXploradores nexp = new NorteXploradores();

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario() {
        return ResponseEntity.ok(user.listar());
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody @Valid Usuario u, BindingResult br) {

        if (br.hasErrors()) {
            return new ResponseEntity<List<ObjectError>>(br.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        user.guardar(u);
        return ResponseEntity.ok(u);
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody @Valid Usuario u, BindingResult br){
        if (br.hasErrors()) {
            return new ResponseEntity<List<ObjectError>>(br.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = user.encontrar(u.getId_Usuario()).orElse(null);
        if(usuario ==null){
            return new ResponseEntity("Usuario no existe",HttpStatus.NOT_FOUND);
        }
        user.guardar(u);

        return ResponseEntity.ok(user.encontrar(u.getId_Usuario()));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable int id) {

        Usuario u = user.encontrar(id).orElse(null);
        if(u == null){
            return new ResponseEntity("El complemento no fue encontrado", HttpStatus.NOT_FOUND);
        }
        user.eliminar(id);

        return ResponseEntity.ok(u);
    }
  
//    @GetMapping(path = "/{id}/paquetes")
//    public ResponseEntity<List<Compra>> paquetesPorUsuario(@PathVariable int id){
//        return ResponseEntity.ok((List)user.encontrar(id).get().compraCollection());
//    }

//    @GetMapping(path = "/{id}/paquetesComprados")
//    public ResponseEntity<List<Compra>> paquetesCompradosPorUsuario(@PathVariable int id){
//
//        List<Compra> soloComprados = nexp.paquetesComprados((List)user.encontrar(id).get().compraCollection());
//
//        return ResponseEntity.ok(soloComprados);
//    }

    
    
}
