package com.mudanca.backend.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mudanca.backend.dao.interface_cadastros;
import com.mudanca.backend.model.Role;
import com.mudanca.backend.model.cadastros;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/cadastro")
public class cadastros_controller {

    
    @Autowired
    private interface_cadastros dao;



    @GetMapping
    public List<cadastros> listaUsuarios(){
      return (List<cadastros>) dao.findAll();
    }

    @PostMapping
    @Transactional
    public cadastros criarUsuario (@RequestBody cadastros user){
        cadastros newUser = dao.save(user);
        return newUser;
    } 

    @PutMapping("/{id}")
    @Transactional
    public cadastros editarUsuario(@PathVariable Long id, @RequestBody cadastros user){
      user.setId(id);
      return dao.save(user);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<cadastros> deletarUsuario(@PathVariable Long id){
      Optional<cadastros> user = dao.findById(id);

      if (user.isEmpty()){
        return ResponseEntity.notFound().build();

      }

      dao.deleteById(id);
      return ResponseEntity.ok(user.get());
    }

     @PutMapping("/role/{id}")
    @Transactional
    public ResponseEntity<?> atualizarRole(@PathVariable Long id, @RequestParam Role role){
        Optional<cadastros> user = dao.findById(id);

        if (user.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        user.get().setRole(role);
        dao.save(user.get());
        return ResponseEntity.ok("Role atualizado com sucesso");
    }
}

      
    

 