package com.vinivictor.api_produto.repository.adapter;

import com.vinivictor.api_produto.entity.Produto;
import com.vinivictor.api_produto.repository.orm.ProdutoOrmMongo;

public class ProdutoRepositoryAdapter {

    private ProdutoRepositoryAdapter() {
    }

    public static Produto cast(ProdutoOrmMongo orm) {
        return new Produto(
                orm.getId(),
                orm.getNome(),
                orm.getPreco()
        );
    }

    public static ProdutoOrmMongo cast(Produto entity) {
        ProdutoOrmMongo orm = new ProdutoOrmMongo();
        orm.setId(entity.id());
        orm.setNome(entity.nome());
        orm.setPreco(entity.preco());
        return orm;
    }
}