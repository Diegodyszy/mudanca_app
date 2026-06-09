package com.mudanca.backend.model;



import java.time.LocalDate;

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

    @Column(name = "Relacao", length = 5000, nullable = false)
    private String relacao;

    @Column(name = "Data", nullable = false)
    private LocalDate data;

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

    public String getRelacao() {
      return relacao;
    }
    public void setRelacao(String relacao) {
      this.relacao = relacao;
    }

    public LocalDate getData() {
      return data;
    }
    public void setData(LocalDate data) {
      this.data = data;
    }


 }