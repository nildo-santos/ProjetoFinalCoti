package br.com.nildoSantos.domain.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

public record ClienteRequest(
        String nome,

        String email,

        String cpf,

        Date dataNascimento) {



}
