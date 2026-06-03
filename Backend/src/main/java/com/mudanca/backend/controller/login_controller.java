package com.mudanca.backend.controller;

import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mudanca.backend.dao.interface_cadastros;
import com.mudanca.backend.model.cadastros;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class login_controller {

    @Autowired
    private interface_cadastros dao;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String senha = body.get("senha");

        Optional<cadastros> usuario = dao.findByEmailAndSenha(email, senha);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(404).body("Usuário não existe");
        }
    }
}
