package com.vinivictor.api_produto.service;

import com.vinivictor.api_produto.entity.Produto;
import com.vinivictor.api_produto.repository.ProdutoRepository;
import java.util.List;

public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listAll() {
        return produtoRepository.listAll();
    }

    public Produto findById(String id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void delete(String id) {
        produtoRepository.delete(id);
    }
}