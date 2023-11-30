package com.brasileiras.api;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brasileiras.api.fornecedor.Fornecedor;
import com.brasileiras.api.fornecedor.FornecedorRepository;
import com.brasileiras.api.notafiscal.NotaFiscal;
import com.brasileiras.api.notafiscal.NotaFiscalRepository;
import com.brasileiras.api.notafiscal.dto.NotaFiscalDTO;
import com.brasileiras.api.notafiscal.dto.NotaFiscalProdutoDTO;
import com.brasileiras.api.produto.ProdutoRepository;

@Configuration
public class AppConfig {

  @Bean
  CommandLineRunner commandLineRunner(ProdutoRepository produtoRepository, FornecedorRepository fornecedorRepository,
      NotaFiscalRepository notaFiscalRepository) {
    return args -> {
      Fornecedor f1 = new Fornecedor("Coca-cola", "123456789");
      NotaFiscalProdutoDTO nfp1 = new NotaFiscalProdutoDTO(10, 10.0, "Refri Cola 1l", 135798642L);
      NotaFiscalProdutoDTO nfp2 = new NotaFiscalProdutoDTO(10, 5.0, "Refri Cola 250ml", 246897531L);
      NotaFiscalDTO nfdto1 = new NotaFiscalDTO(LocalDate.of(2023, Month.NOVEMBER, 19), 150.0, List.of(nfp1, nfp2), f1);
      NotaFiscal nf1 = nfdto1.gerarNotaFiscal();

      fornecedorRepository.save(f1);
      produtoRepository.saveAll(nf1.getProdutos());
      notaFiscalRepository.save(nf1);
    };
  }
}
