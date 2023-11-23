package com.brasileiras.api.contasapagar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagar, Long> {
}
