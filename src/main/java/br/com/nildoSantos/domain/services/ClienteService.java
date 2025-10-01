package br.com.nildoSantos.domain.services;

import br.com.nildoSantos.domain.dtos.ClienteRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
@Service
public class ClienteService implements br.com.nildoSantos.domain.interfaces.ClienteService {


    @Override
    public void create(@PathVariable @Valid ClienteRequest clienteRequest) {
    }

    @Override
    public void readById(UUID id) {

    }

    @Override
    public void update(UUID id, ClienteRequest clienteRequest) {

    }

    @Override
    public void delete(UUID id) {

    }
}
