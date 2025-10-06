package br.com.nildoSantos.domain.services;

import br.com.nildoSantos.domain.dtos.request.ClienteRequest;
import br.com.nildoSantos.domain.dtos.response.ClienteResponse;
import br.com.nildoSantos.domain.entities.ClienteEntity;
import br.com.nildoSantos.domain.mapper.ClienteMapper;
import br.com.nildoSantos.infrastructure.repositories.ClienteJpaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<ClienteResponse> readAll(){
       List<ClienteEntity> entidade = clienteJpaRepository.readAll();
                return clienteMapper.toClienteResponse(entidade);


    }

    @Override
    public void update(UUID id, ClienteRequest clienteRequest) {

    }

    @Override
    public void delete(UUID id) {

    }
}
