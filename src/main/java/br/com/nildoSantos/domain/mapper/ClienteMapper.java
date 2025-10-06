package br.com.nildoSantos.domain.mapper;

import br.com.nildoSantos.domain.dtos.request.ClienteRequest;
import br.com.nildoSantos.domain.dtos.response.ClienteResponse;
import br.com.nildoSantos.domain.dtos.request.EnderecoRequest;
import br.com.nildoSantos.domain.dtos.response.EnderecoResponse;
import br.com.nildoSantos.domain.entities.ClienteEntity;
import br.com.nildoSantos.domain.entities.EnderecoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteMapper {

    private final ModelMapper mapper;

    public ClienteEntity toCliente(ClienteRequest clienteRequest) {
        ClienteEntity entity = new ClienteEntity();
        
        // Mapeamento manual para garantir que os campos sejam preenchidos corretamente
        entity.setNome(clienteRequest.getNome());
        entity.setEmail(clienteRequest.getEmail());
        entity.setCpf(clienteRequest.getCpf());
        entity.setDataNascimento(clienteRequest.getDataNascimento());
        
        // Mapear endereços se existirem
        if (clienteRequest.getEnderecos() != null && !clienteRequest.getEnderecos().isEmpty()) {
            List<EnderecoEntity> enderecos = clienteRequest.getEnderecos().stream()
                    .map(this::toEndereco)
                    .collect(Collectors.toList());
            enderecos.forEach(e -> e.setCliente(entity));
            entity.setEnderecos(enderecos);
        }
        
        return entity;
    }

    public ClienteResponse toClienteResponse(ClienteEntity clienteEntity){
        return mapper.map(clienteEntity, ClienteResponse.class);
    }

    public EnderecoEntity toEndereco(EnderecoRequest enderecoResquest) {
        return mapper.map(enderecoResquest, EnderecoEntity.class);
    }

    public EnderecoResponse toEnderecoResponse(EnderecoEntity enderecoEntity){
        return mapper.map(enderecoEntity, EnderecoResponse.class);
    }

    public List<ClienteResponse> toClienteResponse(List<ClienteEntity> clienteEntity){
        return clienteEntity.stream().map(this::toClienteResponse).collect(Collectors.toList());
    }





}
