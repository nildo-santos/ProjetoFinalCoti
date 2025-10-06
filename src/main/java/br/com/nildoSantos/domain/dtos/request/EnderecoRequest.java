package br.com.nildoSantos.domain.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class EnderecoRequest {
        @NotBlank String logradouro;
        String complemento;
        @NotBlank String numero;
        @NotBlank String bairro;
        @NotBlank String cidade;

        @Pattern(regexp = "^[A-Z]{2}$", message = "UF deve ter 2 letras maiúsculas")
        String uf;
        @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "CEP inválido")
        String cep;
}
