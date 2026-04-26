package com.vinivictor.api_produto.entity;

import java.math.BigDecimal;

public record PedidoItem(String produtoId, String nome, Integer quantidade, BigDecimal precoUnitario) {

    public BigDecimal getSubtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

}