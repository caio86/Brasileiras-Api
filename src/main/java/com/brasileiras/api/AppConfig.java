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
      // Produto p1 = new Produto("Camiseta", 123456789L, 10.0, 15.0, 100, f1);
      // Produto p2 = new Produto("Calça", 987654321L, 20.0, 90.0, 50, f1);
      NotaFiscalProdutoDTO nfp1 = new NotaFiscalProdutoDTO(10, 10.0, "Refri Cola 1l", 135798642L);
      NotaFiscalProdutoDTO nfp2 = new NotaFiscalProdutoDTO(10, 5.0, "Refri Cola 250ml", 246897531L);
      // NotaFiscal nf1 = new NotaFiscal(LocalDate.of(2023, Month.NOVEMBER, 19),
      // 150.00, f1, List.of(p1, p2));
      NotaFiscalDTO nfdto1 = new NotaFiscalDTO(LocalDate.of(2023, Month.NOVEMBER, 19), 150.0, List.of(nfp1, nfp2), f1);
      NotaFiscal nf1 = nfdto1.gerarNotaFiscal();

      fornecedorRepository.save(f1);
      produtoRepository.saveAll(nf1.getProdutos());
      notaFiscalRepository.save(nf1);

      // System.out.println("Teste");
      // System.out.println(nf1);

      // produtoRepository.saveAll(
      // List.of(p1, p2));
    };
  }
}
