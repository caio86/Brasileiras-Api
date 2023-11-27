package com.brasileiras.api.notafiscal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brasileiras.api.notafiscal.dto.NotaFiscalDTO;

@Controller
@RequestMapping("/api/notafiscal")
public class NotaFiscalController {
  private final NotaFiscalService service;

  @Autowired
  public NotaFiscalController(NotaFiscalService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<NotaFiscal> criar(@RequestBody NotaFiscalDTO dto) {
    NotaFiscal notaFiscal = service.create(dto.gerarNotaFiscal());
    return new ResponseEntity<NotaFiscal>(notaFiscal, HttpStatus.CREATED);
  }

}
