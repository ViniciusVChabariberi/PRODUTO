package com.vinivictor.api_produto.entity;

import java.math.BigDecimal;
import java.util.List;

public record Pedido(String id, String clienteId, List<PedidoItem> itens, BigDecimal total) {

    public static Pedido criar(String clienteId, List<PedidoItem> itens) {
        BigDecimal totalCalculado = itens.stream()
                .map(PedidoItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new Pedido(null, clienteId, itens, totalCalculado);
    }
}