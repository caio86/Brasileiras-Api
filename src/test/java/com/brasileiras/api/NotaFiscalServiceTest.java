package com.brasileiras.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.brasileiras.api.contasapagar.ContasAPagarRepository;
import com.brasileiras.api.fornecedor.Fornecedor;
import com.brasileiras.api.fornecedor.FornecedorRepository;
import com.brasileiras.api.notafiscal.NotaFiscal;
import com.brasileiras.api.notafiscal.NotaFiscalRepository;
import com.brasileiras.api.notafiscal.NotaFiscalService;
import com.brasileiras.api.produto.Produto;
import com.brasileiras.api.produto.ProdutoRepository;

@ExtendWith(MockitoExtension.class)
public class NotaFiscalServiceTest {

  @InjectMocks
  private NotaFiscalService notaFiscalService;

  @Mock
  private NotaFiscalRepository notaFiscalRepository;

  @Mock
  private ProdutoRepository produtoRepository;

  @Mock
  private FornecedorRepository fornecedorRepository;

  @Mock
  private ContasAPagarRepository contasAPagarRepository;

  @Test
  public void testCriarNotaFiscal() {
    // Arrange
    NotaFiscal notaFiscal = new NotaFiscal();
    Fornecedor fornecedor = new Fornecedor("Teste", "123456789");
    notaFiscal.setId(1L);
    notaFiscal.setFornecedor(fornecedor);
    notaFiscal.setProdutos(List.of(new Produto(), new Produto()));
    notaFiscal.setData_de_emissao(LocalDate.of(2022, 1, 1));

    when(notaFiscalRepository.save(notaFiscal)).thenReturn(notaFiscal);
    when(fornecedorRepository.existsByCnpj("123456789")).thenReturn(true);
    when(fornecedorRepository.findByCnpj("123456789")).thenReturn(Optional.of(fornecedor));

    // Act
    NotaFiscal notaFiscalCriada = notaFiscalService.create(notaFiscal);

    // Assert
    verify(notaFiscalRepository).save(notaFiscal);
    verify(produtoRepository, times(2)).existsByCodigoBarras(0L);
    verify(fornecedorRepository).findByCnpj("123456789");
    assertEquals(notaFiscal.getId(), notaFiscalCriada.getId());
  }
}
