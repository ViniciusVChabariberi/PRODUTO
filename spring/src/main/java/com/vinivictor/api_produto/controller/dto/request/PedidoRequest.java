package com.vinivictor.api_produto.controller.dto.request;

import java.util.List;

public record PedidoRequest(String clienteId, List<PedidoItemRequest> itens) {}
