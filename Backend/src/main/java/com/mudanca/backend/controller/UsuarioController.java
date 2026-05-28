package com.mudanca.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mudanca.backend.dao.interface_usuario;
import com.mudanca.backend.model.User;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UsuarioController {

    
    @Autowired
    private interface_usuario dao;



    @GetMapping
    public List<User> listaUsuarios(){
      return (List<User>) dao.findAll();
    }

    @PostMapping
    @Transactional
    public User criarUsuario (@RequestBody User user){
        User newUser = dao.save(user);
        return newUser;
    } 

    @PutMapping("/{id}")
    @Transactional
    public User editarUsuario(@PathVariable Long id, @RequestBody User user){
      user.setId(id);
      return dao.save(user);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<User> deletarUsuario(@PathVariable Long id){
      Optional<User> user = dao.findById(id);

      if (user.isEmpty()){
        return ResponseEntity.notFound().build();

      }

      dao.deleteById(id);
      return ResponseEntity.ok(user.get());
    }
 }


  


  
