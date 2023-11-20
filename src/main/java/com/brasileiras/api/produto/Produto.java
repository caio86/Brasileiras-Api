package com.brasileiras.api.produto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String descricao;
  private int estoque;
  @Column(unique = true, nullable = false, name = "codigo_barras")
  private long codigo_barras;
  private double preco;

  public Produto() {
  }

  public Produto(String descricao, int estoque, long codigoBarras, double preco) {
    this.descricao = descricao;
    this.estoque = estoque;
    this.codigo_barras = codigoBarras;
    this.preco = preco;
  }

  public Produto(Long id, String descrição, int estoque, long codigoBarras, double preco) {
    this.id = id;
    this.descricao = descrição;
    this.estoque = estoque;
    this.codigo_barras = codigoBarras;
    this.preco = preco;
  }

  @Override
  public String toString() {
    return "produto [id=" + id + ", descrição=" + descricao + ", codigoBarras=" + codigo_barras + ", preco=" + preco
        + "]";
  }

  public Long getId() {
    return id;
  }

  public String getDescricao() {
    return descricao;
  }

  public long getCodigo_barras() {
    return codigo_barras;
  }

  public double getPreco() {
    return preco;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public int getEstoque() {
    return estoque;
  }

  public void setEstoque(int estoque) {
    this.estoque = estoque;
  }

  public void setCodigo_barras(long codigoBarras) {
    this.codigo_barras = codigoBarras;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }
}
