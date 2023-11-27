package com.brasileiras.api.contasapagar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContasAPagarService {

  private ContasAPagarRepository repository;

  @Autowired
  public ContasAPagarService(ContasAPagarRepository contasAPagarRepository) {
    this.repository = contasAPagarRepository;
  }

  public List<ContasAPagar> getAll() {
    return repository.findAll();
  }

  public ContasAPagar getById(Long id) {
    return repository.findById(id).get();
  }

  public Double getTotalValue() {
    List<ContasAPagar> contasAPagar = repository.findAll();
    double total = 0;

    for (ContasAPagar conta : contasAPagar) {
      total += conta.getValor_total();
    }

    return total;
  }
}
