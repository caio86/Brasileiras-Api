package com.brasileiras.api.notafiscal;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brasileiras.api.fornecedor.Fornecedor;
import com.brasileiras.api.fornecedor.FornecedorRepository;
import com.brasileiras.api.produto.Produto;
import com.brasileiras.api.produto.ProdutoRepository;

@Service
public class NotaFiscalService {

  private final Logger log = LoggerFactory.getLogger(NotaFiscalService.class);
  private final NotaFiscalRepository repository;
  private final FornecedorRepository fornecedorRepository;
  private final ProdutoRepository produtoRepository;

  @Autowired
  public NotaFiscalService(NotaFiscalRepository repository, FornecedorRepository fornecedorRepository,
      ProdutoRepository produtoRepository) {
    this.repository = repository;
    this.fornecedorRepository = fornecedorRepository;
    this.produtoRepository = produtoRepository;
  }

  private List<Produto> checkProdutos(NotaFiscal notaFiscal) {
    List<Produto> produtos = notaFiscal.getProdutos().stream().map(produto -> {
      Boolean produtoExiste = produtoRepository.existsByCodigoBarras(produto.getCodigoBarras());
      if (!produtoExiste) {
        log.info("Produto não existe");
        log.info("Criando o produto: {}", produto);
        produto.setFornecedor(notaFiscal.getFornecedor());
        return produtoRepository.save(produto);
      } else {
        log.info("Produto {} existe", produto);
        Produto produtoDb = produtoRepository.findByCodigoBarras(produto.getCodigoBarras()).get();
        produtoDb.setEstoque(produtoDb.getEstoque() + produto.getEstoque());
        return produtoRepository.save(produtoDb);
      }
    }).toList();

    return produtos;
  };

  public NotaFiscal create(NotaFiscal notaFiscal) {
    log.info("Checando se o fornecedor existe");
    Fornecedor fornecedor = notaFiscal.getFornecedor();
    Boolean fornecedorExiste = fornecedorRepository.existsByCnpj(fornecedor.getCnpj());
    if (!fornecedorExiste) {
      log.info("Fornecedor não existe");
      log.info("Criando o fornecedor: {}", fornecedor);
      fornecedorRepository.save(fornecedor);
    } else {
      Fornecedor fornecedorDb = fornecedorRepository.findByCnpj(fornecedor.getCnpj()).get();
      notaFiscal.setFornecedor(fornecedorDb);
      log.info("Fornecedor {} existe", notaFiscal.getFornecedor());
    }

    log.info("Checando se Produtos existem");
    notaFiscal.setProdutos(checkProdutos(notaFiscal));

    log.info("Criando notafiscal: {}", notaFiscal);
    NotaFiscal nf = repository.save(notaFiscal);
    log.info("Nota Fiscal criada com sucesso");
    return nf;
  }
}
