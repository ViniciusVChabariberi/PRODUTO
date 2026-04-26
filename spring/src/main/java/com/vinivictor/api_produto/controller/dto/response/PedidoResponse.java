package com.vinivictor.api_produto.controller.dto.response;

import java.math.BigDecimal;
import java.util.List;

public record PedidoResponse(
        String id,
        String clienteId,
        List<PedidoItemResponse> itens,
        BigDecimal total)
{

}
