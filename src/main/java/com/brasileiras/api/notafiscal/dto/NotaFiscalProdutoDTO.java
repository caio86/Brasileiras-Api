package com.brasileiras.api.notafiscal.dto;

import com.brasileiras.api.fornecedor.Fornecedor;
import com.brasileiras.api.produto.Produto;

public class NotaFiscalProdutoDTO {
  private int quantidade;
  private double valor_compra;
  private String descricao;
  private Long codigo_barras;

  public NotaFiscalProdutoDTO(int quantidade, double valor_compra, String descricao, Long codigo_barras) {
    this.quantidade = quantidade;
    this.valor_compra = valor_compra;
    this.descricao = descricao;
    this.codigo_barras = codigo_barras;
  }

  public Produto gerarProduto(Fornecedor fornecedor) {
    return new Produto(descricao, codigo_barras, valor_compra, valor_compra * 1.3, quantidade, fornecedor);
  }
}
