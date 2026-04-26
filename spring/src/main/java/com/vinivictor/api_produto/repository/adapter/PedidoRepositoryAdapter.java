package com.vinivictor.api_produto.repository.adapter;

import com.vinivictor.api_produto.entity.Pedido;
import com.vinivictor.api_produto.entity.PedidoItem;
import com.vinivictor.api_produto.repository.orm.PedidoItemOrmMongo;
import com.vinivictor.api_produto.repository.orm.PedidoOrmMongo;

import java.util.List;

public class PedidoRepositoryAdapter {

    private PedidoRepositoryAdapter() {
    }

    public static Pedido cast(PedidoOrmMongo orm) {
        List<PedidoItem> itens = orm.getItens().stream()
                .map(itemOrm -> new PedidoItem(
                        itemOrm.getProdutoId(),
                        itemOrm.getNome(),
                        itemOrm.getQuantidade(),
                        itemOrm.getPrecoUnitario()))
                .toList();

        return new Pedido(
                orm.getId(),
                orm.getClienteId(),
                itens,
                orm.getTotal()
        );
    }

    public static PedidoOrmMongo cast(Pedido entity) {
        PedidoOrmMongo orm = new PedidoOrmMongo();
        orm.setId(entity.id());
        orm.setClienteId(entity.clienteId());
        orm.setTotal(entity.total());

        List<PedidoItemOrmMongo> itensOrm = entity.itens().stream()
                .map(itemEntity -> {
                    PedidoItemOrmMongo io = new PedidoItemOrmMongo();
                    io.setProdutoId(itemEntity.produtoId());
                    io.setNome(itemEntity.nome());
                    io.setQuantidade(itemEntity.quantidade());
                    io.setPrecoUnitario(itemEntity.precoUnitario());
                    return io;
                }).toList();

        orm.setItens(itensOrm);
        return orm;
    }
}