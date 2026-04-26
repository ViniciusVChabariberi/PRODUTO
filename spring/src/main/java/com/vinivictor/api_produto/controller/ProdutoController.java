package com.vinivictor.api_produto.controller;

import com.vinivictor.api_produto.controller.adapter.ProdutoControllerAdapter;
import com.vinivictor.api_produto.controller.dto.request.ProdutoRequest;
import com.vinivictor.api_produto.controller.dto.response.ProdutoResponse;
import com.vinivictor.api_produto.entity.Produto;
import com.vinivictor.api_produto.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoRequest request) {
        var produto = ProdutoControllerAdapter.toEntity(request);
        var salvo = produtoService.save(produto);
        return ResponseEntity.ok(ProdutoControllerAdapter.toResponse(salvo));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        var produtos = produtoService.listAll();
        return ResponseEntity.ok(produtos.stream()
                .map(ProdutoControllerAdapter::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable String id) {
        var produto = produtoService.findById(id);
        return ResponseEntity.ok(ProdutoControllerAdapter.toResponse(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable String id, @RequestBody ProdutoRequest request) {
        var produtoParaAtualizar = new Produto(id, request.nome(), request.preco());
        var atualizado = produtoService.save(produtoParaAtualizar);
        return ResponseEntity.ok(ProdutoControllerAdapter.toResponse(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
