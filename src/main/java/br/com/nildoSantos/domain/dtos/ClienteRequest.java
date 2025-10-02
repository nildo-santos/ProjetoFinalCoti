package br.com.nildoSantos.domain.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

public record ClienteRequest(
        @NotBlank String nome,
        @Email @NotBlank String email,
        @NotBlank @CPF String cpf,
        @NotNull @Past LocalDate dataNascimento,
        @NotNull @Valid List<EnderecoRequest> enderecos
) {



}
