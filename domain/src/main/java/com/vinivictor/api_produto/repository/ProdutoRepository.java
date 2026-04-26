package com.vinivictor.api_produto.repository;

import com.vinivictor.api_produto.entity.Produto;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    Produto save(Produto produto);
    Optional<Produto> findById(String id);
    List<Produto> listAll();
    void delete(String id);
}