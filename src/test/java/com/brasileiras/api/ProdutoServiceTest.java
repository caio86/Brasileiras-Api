package com.brasileiras.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.brasileiras.api.produto.Produto;
import com.brasileiras.api.produto.ProdutoRepository;
import com.brasileiras.api.produto.ProdutoService;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

  @InjectMocks
  private ProdutoService produtoService;

  @Mock
  private ProdutoRepository produtoRepository;

  @Test
  public void test() {
    Long produtoId = 1L;
    int novoEstoque = 50;

    Produto produtoExistente = new Produto();
    produtoExistente.setId(produtoId);
    produtoExistente.setEstoque(novoEstoque);

    when(produtoRepository.findById(produtoId)).thenReturn(Optional.of(produtoExistente));

    Produto produtoAtualizado = produtoService.updateEstoque(produtoId, novoEstoque);

    verify(produtoRepository).findById(produtoId);
    verify(produtoRepository).save(produtoExistente);
    assertEquals(novoEstoque, produtoAtualizado.getEstoque());
  }
}
