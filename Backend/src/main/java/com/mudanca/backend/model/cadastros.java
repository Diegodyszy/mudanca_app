package com.mudanca.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "cadastro")
public class cadastros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    public void setId(Long id) {
      this.id = id;
    }
    public String getNome() {
      return nome;
    }
    public void setNome(String nome) {
      this.nome = nome;
    }
    public String getSenha() {
      return senha;
    }
    public void setSenha(String senha) {
      this.senha = senha;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }
}
