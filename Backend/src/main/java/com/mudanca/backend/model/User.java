package com.mudanca.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Column(name = "De", length = 255, nullable = false)
    private String de_endereco;

    @Column(name = "Para", length = 255, nullable = false)
    private String para_endereco;

    public Long getId() {
      return id;
    }

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
    public String getTelefone() {
      return telefone;
    }
    public void setTelefone(String telefone) {
      this.telefone = telefone;
    }
    public String getde_endereco() {
      return de_endereco;
    }
    public void setde_endereco(String endereco) {
      this.de_endereco = endereco;
    }

    public String getpara_endereco() {
      return para_endereco;
    }

    public void setpara_endereco(String endereco) {
      this.para_endereco = endereco;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }
}
