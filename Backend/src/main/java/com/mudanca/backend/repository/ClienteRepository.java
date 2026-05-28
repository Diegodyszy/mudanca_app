package com.mudanca.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mudanca.backend.model.User;

public interface ClienteRepository extends JpaRepository <User, Long> {
}

