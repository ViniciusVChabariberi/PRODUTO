package com.vinivictor.api_produto.service;

import com.vinivictor.api_produto.entity.Pedido;
import com.vinivictor.api_produto.entity.PedidoItem;
import com.vinivictor.api_produto.gateway.ClienteIntegration;
import com.vinivictor.api_produto.repository.PedidoRepository;
import com.vinivictor.api_produto.repository.ProdutoRepository;
import java.util.List;

public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    private final ClienteIntegration clienteIntegration;

    public PedidoService(PedidoRepository pedidoRepository,
                         ProdutoRepository produtoRepository,
                         ProdutoService produtoService,
                         ClienteIntegration clienteIntegration) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.clienteIntegration = clienteIntegration;
    }

    public List<Pedido> buscarPorCliente(String clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public Pedido buscarPorId(String id) { return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido realizarVenda(String clienteId, List<PedidoItem> itensBrutos) {
        if (!clienteIntegration.existeCliente(clienteId)) {
            throw new RuntimeException("Cliente não encontrado na base de dados externa!");
        }
        List<PedidoItem> itensValidados = itensBrutos.stream().map(item -> {
            var produto = produtoService.findById(item.produtoId());
            return new PedidoItem(
                    produto.id(),
                    produto.nome(),
                    item.quantidade(),
                    produto.preco()
            );
        }).toList();

        Pedido novoPedido = Pedido.criar(clienteId, itensValidados);

        return pedidoRepository.save(novoPedido);
    }
}