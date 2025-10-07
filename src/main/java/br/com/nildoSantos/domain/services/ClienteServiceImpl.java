package br.com.nildoSantos.domain.services;

import br.com.nildoSantos.domain.dtos.request.ClienteRequest;
import br.com.nildoSantos.domain.dtos.response.ClienteResponse;
import br.com.nildoSantos.domain.entities.ClienteEntity;
import br.com.nildoSantos.domain.entities.EnderecoEntity;
import br.com.nildoSantos.domain.mapper.ClienteMapper;
import br.com.nildoSantos.infrastructure.repositories.ClienteJpaRepository;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        ClienteEntity cliente = clienteJpaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Cliente nao encontrado com ID" + id ));
        cliente.setEmail(clienteRequest.getEmail());
        cliente.setNome(clienteRequest.getNome());
        if (clienteRequest.getEnderecos()!=null){
            List<EnderecoEntity>  novosEnderecos = clienteRequest.getEnderecos().stream().map(clienteMapper::toEndereco)
                    .collect(Collectors.toList());
            novosEnderecos.forEach(e-> e.setCliente(cliente));
            novosEnderecos.forEach(e -> e.setCliente(cliente));
            cliente.getEnderecos().clear();
            cliente.getEnderecos().addAll(novosEnderecos);
        }
        ClienteEntity salvo = clienteJpaRepository.save(cliente);


    }

    @Override
    public void delete(UUID id) {
        if (clienteJpaRepository.existsById(id)){
            clienteJpaRepository.deleteById(id);
        }else {
            throw new RuntimeException("Cliente não encontrado com Id "+ id);
        }


    }
}
