package com.vinivictor.api_produto.repository;

import com.vinivictor.api_produto.entity.Produto;
import com.vinivictor.api_produto.repository.adapter.ProdutoRepositoryAdapter;
import com.vinivictor.api_produto.repository.mongo.ProdutoRepositoryWithMongoDB;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoRepositoryWithMongoDB mongoRepo;

    public ProdutoRepositoryImpl(ProdutoRepositoryWithMongoDB mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public Produto save(Produto produto) {
        return ProdutoRepositoryAdapter.cast(
                mongoRepo.save(ProdutoRepositoryAdapter.cast(produto))
        );
    }

    @Override
    public Optional<Produto> findById(String id) {
        return mongoRepo.findById(id)
                .map(ProdutoRepositoryAdapter::cast);
    }

    @Override
    public List<Produto> listAll() {
        return mongoRepo.findAll().stream()
                .map(ProdutoRepositoryAdapter::cast)
                .toList();
    }

    @Override
    public void delete(String id) {
        mongoRepo.deleteById(id);
    }
}