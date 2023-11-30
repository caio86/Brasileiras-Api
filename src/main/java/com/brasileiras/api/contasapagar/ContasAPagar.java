package com.brasileiras.api.contasapagar;

import java.time.LocalDate;

import com.brasileiras.api.notafiscal.NotaFiscal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contas_a_pagar")
public class ContasAPagar {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  private NotaFiscal nota_fiscal;
  private double valor_total;
  private LocalDate data_de_emissao;
  private LocalDate data_de_vencimento;

  public ContasAPagar() {
  }

  public ContasAPagar(NotaFiscal notaFiscal, double valor_total, LocalDate data_de_emissao,
      LocalDate data_de_vencimento) {
    this.nota_fiscal = notaFiscal;
    this.data_de_emissao = data_de_emissao;
    this.data_de_vencimento = data_de_vencimento;
    this.valor_total = valor_total;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public NotaFiscal getNota_fiscal() {
    return nota_fiscal;
  }

  public void setNota_fiscal(NotaFiscal nota_fiscal) {
    this.nota_fiscal = nota_fiscal;
  }

  public double getValor_total() {
    return valor_total;
  }

  public void setValor_total(double valor_total) {
    this.valor_total = valor_total;
  }

  public LocalDate getData_de_emissao() {
    return data_de_emissao;
  }

  public void setData_de_emissao(LocalDate data_de_emissao) {
    this.data_de_emissao = data_de_emissao;
  }

  public LocalDate getData_de_vencimento() {
    return data_de_vencimento;
  }

  public void setData_de_vencimento(LocalDate data_de_vencimento) {
    this.data_de_vencimento = data_de_vencimento;
  }

  @Override
  public String toString() {
    return "ContasAPagar [id=" + id + ", nota_fiscal=" + nota_fiscal + ", valor_total=" + valor_total
        + ", data_de_emissao=" + data_de_emissao + ", data_de_vencimento=" + data_de_vencimento + "]";
  }
}
