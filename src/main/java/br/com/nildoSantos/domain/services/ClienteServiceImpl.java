package br.com.nildoSantos.domain.services;

import br.com.nildoSantos.domain.dtos.ClienteRequest;
import br.com.nildoSantos.domain.dtos.ClienteResponse;
import br.com.nildoSantos.domain.entities.ClienteEntity;
import br.com.nildoSantos.domain.mapper.ClienteMapper;
import br.com.nildoSantos.infrastructure.repositories.ClienteJpaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements br.com.nildoSantos.domain.interfaces.ClienteService {
    @Autowired
    private  ClienteMapper clienteMapper;
    @Autowired
    private  ClienteJpaRepository clienteJpaRepository;

    @Override
    public ClienteResponse create(@Valid ClienteRequest clienteRequest) {
        ClienteEntity cliente = clienteMapper.toCliente(clienteRequest);

        ClienteEntity clienteSave = clienteJpaRepository.save(cliente);
        ClienteResponse toResponse = clienteMapper.toClienteResponse(clienteSave);
        return toResponse;
    }

    @Override
    public ClienteResponse readById(UUID id) {
        return clienteJpaRepository.findById(id)
                .map(clienteMapper::toClienteResponse)
                .orElse(null); // ou lançar exceção customizada tipo EntityNotFoundException
    }

    @Override
    public void update(UUID id, ClienteRequest clienteRequest) {

    }

    @Override
    public void delete(UUID id) {

    }
}
