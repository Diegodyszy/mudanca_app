package com.mudanca.backend.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mudanca.backend.dao.interface_adm;
import com.mudanca.backend.model.AdmUser;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin("*")
@RequestMapping("/adm_user")
public class AdmUserController {

    @Autowired
    private interface_adm dao;

    @GetMapping
    public List<AdmUser> listaUsuarios() {
        return (List<AdmUser>) dao.findAll();
    }

    @PostMapping
    @Transactional
    public AdmUser criarUsuario(@RequestBody AdmUser user) {
        return dao.save(user);
    }

    @PutMapping("/{id}")
    @Transactional
    public AdmUser editarUsuario(@PathVariable Long id, @RequestBody AdmUser user) {
        user.setId(id);
        return dao.save(user);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<AdmUser> deletarUsuario(@PathVariable Long id) {
        Optional<AdmUser> user = dao.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        dao.deleteById(id);
        return ResponseEntity.ok(user.get());
    }
}