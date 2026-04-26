package com.vinivictor.api_produto.client;

import com.vinivictor.api_produto.gateway.ClienteIntegration;
import feign.FeignException;
import org.springframework.stereotype.Component;

@Component
public class ClienteIntegrationImpl implements ClienteIntegration {

    private final ClienteFeignClient clienteFeignClient;

    public ClienteIntegrationImpl(ClienteFeignClient clienteFeignClient) {
        this.clienteFeignClient = clienteFeignClient;
    }

    @Override
    public boolean existeCliente(String clienteId) {
        try {
            clienteFeignClient.findById(clienteId);
            return true;
        } catch (FeignException.NotFound e) {
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao se comunicar com a API de Clientes. Tente novamente mais tarde.", e);
        }
    }
}