package com.brasileiras.api.notafiscal.dto;

import java.time.LocalDate;
import java.util.List;

import com.brasileiras.api.fornecedor.Fornecedor;
import com.brasileiras.api.notafiscal.NotaFiscal;
import com.brasileiras.api.produto.Produto;

public class NotaFiscalDTO {
  private LocalDate data_de_emissao;
  private double valor_total;
  private List<NotaFiscalProdutoDTO> produtos;
  private Fornecedor fornecedor;

  public NotaFiscalDTO(LocalDate data_de_emissao, double valor_total, List<NotaFiscalProdutoDTO> produtos,
      Fornecedor fornecedor) {
    this.data_de_emissao = data_de_emissao;
    this.valor_total = valor_total;
    this.produtos = produtos;
    this.fornecedor = fornecedor;
  }

  public NotaFiscal gerarNotaFiscal() {
    List<Produto> listaProdutos = this.produtos.stream().map(p -> p.gerarProduto(this.fornecedor)).toList();
    return new NotaFiscal(data_de_emissao, valor_total, fornecedor, listaProdutos);
  }
}
