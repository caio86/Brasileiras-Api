package com.brasileiras.api.contasapagar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/contas")
public class ContasAPagarController {

  private ContasAPagarService contasAPagarService;

  @Autowired
  public ContasAPagarController(ContasAPagarService contasAPagarService) {
    this.contasAPagarService = contasAPagarService;
  }

  @GetMapping("/pagar")
  public ResponseEntity<List<ContasAPagar>> obterContas() {
    List<ContasAPagar> contas = contasAPagarService.getAll();
    return new ResponseEntity<>(contas, HttpStatus.OK);
  }

  @GetMapping("/pagar/{id}")
  public ResponseEntity<ContasAPagar> obterContas(@PathVariable Long id) {
    ContasAPagar conta = contasAPagarService.getById(id);
    return new ResponseEntity<>(conta, HttpStatus.OK);
  }

  @GetMapping("/pagar/total")
  public ResponseEntity<String> obterTotal() {
    double total = contasAPagarService.getTotalValue();
    return new ResponseEntity<String>("Total a pagar: " + String.valueOf(total), HttpStatus.OK);
  }

}
