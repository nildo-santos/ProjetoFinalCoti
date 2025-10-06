package br.com.nildoSantos.domain.dtos.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.Data;
@Data
public class ClienteResponse {
       private UUID id;
       private String nome;
       private String email;
       private String cpf;
       private LocalDate dataNascimento;
       private List<EnderecoResponse> enderecos;


}
