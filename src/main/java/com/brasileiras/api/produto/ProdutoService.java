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
    log.debug("getting all produtcts");
    return repository.findAll();
  }

  public Produto getById(Long id) {
    log.info("getting product by id: {}", id);
    return repository.findById(id).get();
  }
}
