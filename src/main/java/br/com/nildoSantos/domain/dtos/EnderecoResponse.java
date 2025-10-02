package br.com.nildoSantos.domain.dtos;

import java.util.UUID;

public record EnderecoResponse(
        UUID id,
        String logradouro,
        String complemento,
        String numero,
        String bairro,
        String cidade,
        String uf,
        String cep) {


}
