package com.brasileiras.api.fornecedor;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedores")
public class Fornecedor implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String razao_social;
  @Column(unique = true, nullable = false, name = "cnpj")
  private String cnpj;

  public Fornecedor(String razao_social, String cnpj) {
    this.razao_social = razao_social;
    this.cnpj = cnpj;
  }

  public Fornecedor() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRazao_social() {
    return razao_social;
  }

  public void setRazao_social(String razao_social) {
    this.razao_social = razao_social;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  @Override
  public String toString() {
    return "Fornecedor [id=" + id + ", razao_social=" + razao_social + ", cnpj=" + cnpj + "]";
  }
}
