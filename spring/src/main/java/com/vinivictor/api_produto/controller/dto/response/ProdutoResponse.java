package com.vinivictor.api_produto.controller.dto.response;

import java.math.BigDecimal;

public record ProdutoResponse(
        String id,
        String nome,
        BigDecimal preco)
{

}
