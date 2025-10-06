package br.com.nildoSantos.domain.interfaces;

import br.com.nildoSantos.domain.dtos.request.ClienteRequest;
import br.com.nildoSantos.domain.dtos.response.ClienteResponse;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse create(ClienteRequest clienteRequest);
    ClienteResponse readById(UUID id);
    List<ClienteResponse> readAll();
    void update(UUID id, ClienteRequest clienteRequest);
    void delete(UUID id);

}
