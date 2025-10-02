package br.com.nildoSantos.domain.dtos;

import br.com.nildoSantos.domain.entities.EnderecoEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record ClienteResponse(
        UUID id,
        String nome,
        String email,
        String cpf,
        LocalDate dataNascimento,
        List<EnderecoResponse> EnderecoEntity
) {



}
