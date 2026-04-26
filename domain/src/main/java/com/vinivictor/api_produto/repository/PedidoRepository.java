package com.vinivictor.api_produto.repository;

import com.vinivictor.api_produto.entity.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoRepository {
    Pedido save(Pedido pedido);
    List<Pedido> findByClienteId(String clienteId);
    Optional<Pedido> findById(String id);
}