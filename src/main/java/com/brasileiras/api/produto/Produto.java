package com.brasileiras.api.produto;

import java.io.Serializable;

import com.brasileiras.api.fornecedor.Fornecedor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String descricao;
  @Column(unique = true, nullable = false, name = "codigo_barras")
  private long codigo_barras;
  private double valor_compra;
  private double valor_venda;
  private int estoque;
  @ManyToOne
  private Fornecedor fornecedor;

  public Produto(String descricao, long codigo_barras, double valor_compra, double valor_venda,
      int estoque,
      Fornecedor fornecedor) {
    this.descricao = descricao;
    this.codigo_barras = codigo_barras;
    this.valor_compra = valor_compra;
    this.valor_venda = valor_venda;
    this.estoque = estoque;
    this.fornecedor = fornecedor;
  }

  public Produto() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public long getCodigo_barras() {
    return codigo_barras;
  }

  public void setCodigo_barras(long codigo_barras) {
    this.codigo_barras = codigo_barras;
  }

  public double getValor_compra() {
    return valor_compra;
  }

  public void setValor_compra(double valor_compra) {
    this.valor_compra = valor_compra;
  }

  public double getValor_venda() {
    return valor_venda;
  }

  public void setValor_venda(double valor_venda) {
    this.valor_venda = valor_venda;
  }

  public int getEstoque() {
    return estoque;
  }

  public void setEstoque(int estoque) {
    this.estoque = estoque;
  }

  public Fornecedor getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }

  @Override
  public String toString() {
    return "Produto [id=" + id + ", descricao=" + descricao + ", codigo_barras=" + codigo_barras + ", valor_compra="
        + valor_compra + ", valor_venda=" + valor_venda + ", estoque=" + estoque + ", fornecedor=" + fornecedor + "]";
  }

}
