package com.brasileiras.api.fornecedor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
  Optional<Fornecedor> findByCnpj(String cnpj);

  Boolean existsByCnpj(String cnpj);
}
