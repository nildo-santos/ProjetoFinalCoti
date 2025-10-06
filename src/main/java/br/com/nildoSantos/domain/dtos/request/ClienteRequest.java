package br.com.nildoSantos.domain.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;
@Data
public class ClienteRequest {

        @NotBlank String nome;
        @Email @NotBlank String email;
        @NotBlank @CPF String cpf;
        @NotNull @Past LocalDate dataNascimento;
        @NotNull @Valid List<EnderecoRequest> enderecos;

}
