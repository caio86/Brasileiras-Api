package com.brasileiras.api.produto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  Optional<Produto> findByCodigoBarras(long codigoBarras);

  Boolean existsByCodigoBarras(long codigoBarras);
}
