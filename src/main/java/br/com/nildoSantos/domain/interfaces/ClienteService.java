package br.com.nildoSantos.domain.interfaces;

import br.com.nildoSantos.domain.dtos.ClienteRequest;
import br.com.nildoSantos.domain.dtos.ClienteResponse;
import br.com.nildoSantos.domain.entities.ClienteEntity;

import java.util.UUID;

public interface ClienteService {
    ClienteResponse create(ClienteRequest clienteRequest);
    ClienteResponse readById(UUID id);
    void update(UUID id, ClienteRequest clienteRequest);
    void delete(UUID id);

}
