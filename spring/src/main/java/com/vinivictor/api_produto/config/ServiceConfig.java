package com.vinivictor.api_produto.config;

import com.vinivictor.api_produto.gateway.ClienteIntegration;
import com.vinivictor.api_produto.repository.PedidoRepository;
import com.vinivictor.api_produto.repository.ProdutoRepository;
import com.vinivictor.api_produto.service.PedidoService;
import com.vinivictor.api_produto.service.ProdutoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ProdutoService produtoService(ProdutoRepository produtoRepository) {
        return new ProdutoService(produtoRepository);
    }

    @Bean
    public PedidoService pedidoService(PedidoRepository pedidoRepository,
                                       ProdutoRepository produtoRepository,
                                       ProdutoService produtoService,
                                       ClienteIntegration clienteIntegration) {
        return new PedidoService(pedidoRepository, produtoRepository, produtoService, clienteIntegration);
    }
}