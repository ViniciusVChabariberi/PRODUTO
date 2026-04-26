package com.vinivictor.api_produto.entity;

import java.math.BigDecimal;

public record Produto(String id, String nome, BigDecimal preco) {

    public Produto {
        if (preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
    }

}