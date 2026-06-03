package com.mudanca.backend.dao;

import org.springframework.data.repository.CrudRepository;
import com.mudanca.backend.model.cadastros;
import java.util.Optional;

public interface interface_cadastros extends CrudRepository<cadastros, Long> {
    Optional<cadastros> findByEmailAndSenha(String email, String senha);
}
