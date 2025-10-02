package br.com.nildoSantos.domain.dtos;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoRequest(

        @NotBlank String logradouro,
        String complemento,
        @NotBlank String numero,
        @NotBlank String bairro,
        @NotBlank String cidade,
        // "RJ", "SP", etc. Se quiser ENUM depois, a gente troca.
        @Pattern(regexp = "^[A-Z]{2}$", message = "UF deve ter 2 letras maiúsculas")
        String uf,
        @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "CEP inválido")
        String cep) {

}
