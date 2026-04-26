package com.vinivictor.api_produto.controller;

import com.vinivictor.api_produto.controller.adapter.PedidoControllerAdapter;
import com.vinivictor.api_produto.controller.dto.request.PedidoRequest;
import com.vinivictor.api_produto.controller.dto.response.PedidoResponse;
import com.vinivictor.api_produto.entity.PedidoItem;
import com.vinivictor.api_produto.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/venda")
    public ResponseEntity<PedidoResponse> realizarVenda(@RequestBody PedidoRequest request) {
        var itensDomain = request.itens().stream()
                .map(i -> new PedidoItem(i.produtoId(), null, i.quantidade(), null))
                .toList();

        var pedidoRealizado = pedidoService.realizarVenda(request.clienteId(), itensDomain);
        return ResponseEntity.ok(PedidoControllerAdapter.toResponse(pedidoRealizado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPorId(@PathVariable String id) {
        var pedido = pedidoService.buscarPorId(id);
        return ResponseEntity.ok(PedidoControllerAdapter.toResponse(pedido));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PedidoResponse>> listarPorCliente(@PathVariable String clienteId) {
        var pedidos = pedidoService.buscarPorCliente(clienteId);
        return ResponseEntity.ok(pedidos.stream()
                .map(PedidoControllerAdapter::toResponse).toList());
    }
}
