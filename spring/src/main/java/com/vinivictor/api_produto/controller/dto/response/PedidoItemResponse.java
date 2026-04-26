package com.vinivictor.api_produto.controller.dto.response;

import java.math.BigDecimal;

public record PedidoItemResponse(
        String produtoId,
        String nome,
        Integer quantidade,
        BigDecimal precoUnitario,
        BigDecimal subtotal)
{

}
