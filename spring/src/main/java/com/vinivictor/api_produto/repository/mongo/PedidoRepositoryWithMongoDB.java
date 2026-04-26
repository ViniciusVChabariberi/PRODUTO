package com.vinivictor.api_produto.repository.mongo;

import com.vinivictor.api_produto.repository.orm.PedidoOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepositoryWithMongoDB extends MongoRepository<PedidoOrmMongo, String> {
    List<PedidoOrmMongo> findByClienteId(String clienteId);
}
