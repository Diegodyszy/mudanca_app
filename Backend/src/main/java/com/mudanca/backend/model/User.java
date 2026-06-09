package com.mudanca.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty("de_endereco")
    @Column(name = "De", length = 255, nullable = false)
    private String de_endereco;

      @JsonProperty("para_endereco")
    @Column(name = "Para", length = 255, nullable = false)
    private String para_endereco;

    public Long getId() {
      return id;
    }

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
    public String getDeEndereco() {
      return de_endereco;
    }
    public void setDeEndereco(String endereco) {
      this.de_endereco = endereco;
    }

    public String getParaEndereco() {
      return para_endereco;
    }   
    public void setParaEndereco(String endereco) {
      this.para_endereco = endereco;
    }

 }