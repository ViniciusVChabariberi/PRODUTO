package com.vinivictor.api_produto.client;

import com.vinivictor.api_produto.client.dto.ClienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente-service")
public interface ClienteFeignClient {

    @GetMapping("/api/cliente/{id}")
    ClienteResponse findById(@PathVariable("id") String id);
}