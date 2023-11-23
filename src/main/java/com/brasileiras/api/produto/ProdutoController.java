package com.brasileiras.api.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProdutoController {

  private final ProdutoService service;

  @Autowired
  public ProdutoController(ProdutoService service) {
    this.service = service;
  }

  @GetMapping("/produtos")
  public ResponseEntity<List<Produto>> obterProdutos() {
    List<Produto> produtos = service.getAll();
    return new ResponseEntity<>(produtos, HttpStatus.OK);
  }

  @GetMapping("/estoque/{id}")
  public ResponseEntity<Integer> obterEstoque(@PathVariable Long id) {
    int estoque = service.getEstoque(id);
    return new ResponseEntity<>(estoque, HttpStatus.OK);
  }
}
