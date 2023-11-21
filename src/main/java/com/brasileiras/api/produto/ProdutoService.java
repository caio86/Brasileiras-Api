package com.brasileiras.api.produto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  private final Logger log = LoggerFactory.getLogger(ProdutoService.class);
  private final ProdutoRepository repository;

  @Autowired
  public ProdutoService(ProdutoRepository repository) {
    this.repository = repository;
  }

  public List<Produto> getAll() {
    log.info("Buscando todos os produtos do banco de dados");
    List<Produto> produtos = repository.findAll();
    log.info("Foram encontrados {} produtos no banco de dados", produtos.size());
    return produtos;
  }

  public Produto getById(Long id) {
    log.info("Buscando o produto com id: {}", id);
    return repository.findById(id).get();
  }

  public int getEstoque(Long id) {
    log.info("Buscando estoque do produto com id: {}", id);
    int estoque = repository.findById(id).get().getEstoque();
    log.info("Estoque do produto com id {} é: {}", id, estoque);
    return estoque;
  }

  public Produto updateEstoque(Long id, int estoque) {
    log.info("Atualizando estoque do produto com id: {}", id);
    Produto produto = repository.findById(id).get();
    produto.setEstoque(estoque);
    repository.save(produto);
    return produto;
  }
}
