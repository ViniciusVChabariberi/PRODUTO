package com.vinivictor.api_produto.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.util.List;

@Document(collection = "pedidos")
public class PedidoOrmMongo {
    @Id
    private String id;
    private String clienteId;
    private List<PedidoItemOrmMongo> itens;
    private BigDecimal total;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getClienteId() { return clienteId; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }
    public List<PedidoItemOrmMongo> getItens() { return itens; }
    public void setItens(List<PedidoItemOrmMongo> itens) { this.itens = itens; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}