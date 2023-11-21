package com.brasileiras.api.notafiscal;

import java.time.LocalDate;
import java.util.List;

import com.brasileiras.api.fornecedor.Fornecedor;
import com.brasileiras.api.produto.Produto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate data_de_emissao;
  private double valor_total;
  @Column(length = 3000)
  @ManyToMany
  @JoinTable(name = "nota_fiscal-produto", joinColumns = @JoinColumn(name = "nota_fiscal_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
  private List<Produto> produtos;
  @ManyToOne
  @JoinColumn(name = "fornecedor_id")
  private Fornecedor fornecedor;

  public NotaFiscal(LocalDate data_de_emissao, double valor_total, Fornecedor fornecedor,
      List<Produto> produtos) {
    this.data_de_emissao = data_de_emissao;
    this.valor_total = valor_total;
    this.fornecedor = fornecedor;
    this.produtos = produtos;
  }

  public NotaFiscal() {
  }

  public LocalDate getData_de_emissao() {
    return data_de_emissao;
  }

  public void setData_de_emissao(LocalDate data_de_emissao) {
    this.data_de_emissao = data_de_emissao;
  }

  public double getValor_total() {
    return valor_total;
  }

  public void setValor_total(double valor_total) {
    this.valor_total = valor_total;
  }

  public Fornecedor getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }

  @Override
  public String toString() {
    return "NotaFiscal [id=" + id + ", data_de_emissao=" + data_de_emissao + ", valor_total=" + valor_total
        + ", produtos=" + produtos + ", fornecedor=" + fornecedor + "]";
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
