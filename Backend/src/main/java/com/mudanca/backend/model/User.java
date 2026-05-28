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

    @Column(name = "endereco", length = 255, nullable = false)
    private String endereco;
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
    public String getEndereco() {
      return endereco;
    }
    public void setEndereco(String endereco) {
      this.endereco = endereco;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }
    

}
