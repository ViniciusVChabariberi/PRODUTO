package com.vinivictor.api_produto.repository.mongo;

import com.vinivictor.api_produto.repository.orm.ProdutoOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositoryWithMongoDB extends MongoRepository<ProdutoOrmMongo, String> {
}