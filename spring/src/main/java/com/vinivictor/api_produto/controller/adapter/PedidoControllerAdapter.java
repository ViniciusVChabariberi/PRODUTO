package com.vinivictor.api_produto.controller.adapter;

import com.vinivictor.api_produto.controller.dto.response.PedidoItemResponse;
import com.vinivictor.api_produto.controller.dto.response.PedidoResponse;
import com.vinivictor.api_produto.entity.Pedido;

public class PedidoControllerAdapter {
    private PedidoControllerAdapter() {}

    public static PedidoResponse toResponse(Pedido entity) {
        var itensResponse = entity.itens().stream()
                .map(i -> new PedidoItemResponse(
                        i.produtoId(),
                        i.nome(),
                        i.quantidade(),
                        i.precoUnitario(),
                        i.getSubtotal()))
                .toList();

        return new PedidoResponse(
                entity.id(),
                entity.clienteId(),
                itensResponse,
                entity.total()
        );
    }
}
