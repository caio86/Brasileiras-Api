package com.brasileiras.api.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  Produto findByCodigoBarras(long codigoBarras);

  Boolean existsByCodigoBarras(long codigoBarras);
}
