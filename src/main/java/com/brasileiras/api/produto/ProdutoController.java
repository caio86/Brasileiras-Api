package com.brasileiras.api.produto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

  private final ProdutoService service;

  private final Logger log = LoggerFactory.getLogger(ProdutoController.class);

  @Autowired
  public ProdutoController(ProdutoService service) {
    this.service = service;
  }

  @GetMapping
  public List<Produto> getAll() {
    log.info("teste");
    return service.getAll();
  }

}
