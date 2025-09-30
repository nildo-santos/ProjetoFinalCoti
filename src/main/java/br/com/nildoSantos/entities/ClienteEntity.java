package br.com.nildoSantos.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ClienteEntity {
	
	@Id
	private UUID id;
	
	private String nome;
	
	private String email;
	
	private String cpf;
	
	private Date dataNascimento;
}
