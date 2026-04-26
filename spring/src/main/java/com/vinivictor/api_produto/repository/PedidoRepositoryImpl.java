package com.vinivictor.api_produto.repository;

import com.vinivictor.api_produto.entity.Pedido;
import com.vinivictor.api_produto.repository.adapter.PedidoRepositoryAdapter;
import com.vinivictor.api_produto.repository.mongo.PedidoRepositoryWithMongoDB;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PedidoRepositoryImpl implements PedidoRepository {

    private final PedidoRepositoryWithMongoDB mongoRepo;

    public PedidoRepositoryImpl(PedidoRepositoryWithMongoDB mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public Pedido save(Pedido pedido) {
        return PedidoRepositoryAdapter.cast(
                mongoRepo.save(PedidoRepositoryAdapter.cast(pedido))
        );
    }

    @Override
    public List<Pedido> findByClienteId(String clienteId) {
        return mongoRepo.findByClienteId(clienteId).stream()
                .map(PedidoRepositoryAdapter::cast)
                .toList();
    }

    @Override
    public Optional<Pedido> findById(String id) {
        return mongoRepo.findById(id)
                .map(PedidoRepositoryAdapter::cast);
    }

}