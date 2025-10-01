package br.com.nildoSantos.domain.interfaces;

import br.com.nildoSantos.domain.dtos.ClienteRequest;

import java.util.UUID;

public interface ClienteService {
    void create(ClienteRequest clienteRequest);
    void readById(UUID id);
    void update(UUID id, ClienteRequest clienteRequest);
    void delete(UUID id);

}
