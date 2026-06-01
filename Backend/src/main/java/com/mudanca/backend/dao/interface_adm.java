package com.mudanca.backend.dao;

import org.springframework.data.repository.CrudRepository;
import com.mudanca.backend.model.AdmUser;

public interface interface_adm extends CrudRepository<AdmUser, Long> {
    
}