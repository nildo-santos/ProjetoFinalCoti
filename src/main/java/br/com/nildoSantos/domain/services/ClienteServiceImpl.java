package br.com.nildoSantos.domain.services;

import br.com.nildoSantos.domain.dtos.request.ClienteRequest;
import br.com.nildoSantos.domain.dtos.response.ClienteResponse;
import br.com.nildoSantos.domain.entities.ClienteEntity;
import br.com.nildoSantos.domain.entities.EnderecoEntity;
import br.com.nildoSantos.domain.interfaces.ClienteService;
import br.com.nildoSantos.domain.mapper.ClienteMapper;
import br.com.nildoSantos.infrastructure.messaging.RabbitMQConfig;
import br.com.nildoSantos.infrastructure.repositories.ClienteJpaRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private ClienteJpaRepository clienteJpaRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MailHogService mailHogService;

    @Override
    public ClienteResponse create(@Valid ClienteRequest clienteRequest) {
        ClienteEntity cliente = clienteMapper.toCliente(clienteRequest);
        ClienteEntity clienteSave = clienteJpaRepository.save(cliente);
        ClienteResponse toResponse = clienteMapper.toClienteResponse(clienteSave);

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, toResponse);
        mailHogService.envioDeEmail(cliente.getEmail(), "Ola " + cliente.getNome(), "Bem vindo a Coti Informatica!");
        return toResponse;
    }

    @Override
    public ClienteResponse readById(UUID id) {
        return clienteJpaRepository.findById(id)
                .map(clienteMapper::toClienteResponse)
                .orElse(null); // ou lancar excecao customizada tipo EntityNotFoundException
    }

    @Override
    public List<ClienteResponse> readAll() {
        List<ClienteEntity> entidade = clienteJpaRepository.readAll();
        return clienteMapper.toClienteResponse(entidade);
    }

    @Override
    public void update(UUID id, ClienteRequest clienteRequest) {
        ClienteEntity cliente = clienteJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado com ID " + id));
        cliente.setEmail(clienteRequest.getEmail());
        cliente.setNome(clienteRequest.getNome());
        if (clienteRequest.getEnderecos() != null) {
            List<EnderecoEntity> novosEnderecos = clienteRequest.getEnderecos().stream()
                    .map(clienteMapper::toEndereco)
                    .toList();
            novosEnderecos.forEach(endereco -> endereco.setCliente(cliente));
            cliente.getEnderecos().clear();
            cliente.getEnderecos().addAll(novosEnderecos);
        }
        clienteJpaRepository.save(cliente);
    }

    @Override
    public void delete(UUID id) {
        if (clienteJpaRepository.existsById(id)) {
            clienteJpaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente nao encontrado com Id " + id);
        }
    }
}
