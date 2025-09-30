package br.com.nildoSantos.domain.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.util.UUID;

public record ClienteResponse(
        String nome,

        String email,

        String cpf,

        LocalDate dataNascimento) {



}
