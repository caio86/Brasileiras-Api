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

  @GetMapping("/produtos/{id}")
  public ResponseEntity<Produto> obterPorId(@PathVariable Long id) {
    Produto produto = service.getById(id);
    return new ResponseEntity<>(produto, HttpStatus.OK);
  }

  @GetMapping("/estoque/{id}")
  public ResponseEntity<String> obterEstoque(@PathVariable Long id) {
    int estoque = service.getEstoque(id);
    return new ResponseEntity<>("O estoque do produto de id: " + id + " é: " + estoque + "", HttpStatus.OK);
  }
}
