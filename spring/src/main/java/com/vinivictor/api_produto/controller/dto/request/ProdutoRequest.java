package com.vinivictor.api_produto.controller.dto.request;

import java.math.BigDecimal;

public record ProdutoRequest(String nome, BigDecimal preco) {}