package com.vinivictor.api_produto.controller.adapter;

import com.vinivictor.api_produto.controller.dto.request.ProdutoRequest;
import com.vinivictor.api_produto.controller.dto.response.ProdutoResponse;
import com.vinivictor.api_produto.entity.Produto;

public class ProdutoControllerAdapter {
    private ProdutoControllerAdapter() {}

    public static Produto toEntity(ProdutoRequest request) {
        return new Produto(null, request.nome(), request.preco());
    }

    public static ProdutoResponse toResponse(Produto entity) {
        return new ProdutoResponse(entity.id(), entity.nome(), entity.preco());
    }
}
