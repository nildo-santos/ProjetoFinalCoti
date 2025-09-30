package br.com.nildoSantos.entities;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EnderecoEntity {

	@Id
	private UUID id;
	
	private String lagradouro;
	
	private String complemento;
	
	private String numero;
	
	private String bairro;
	
	private String uf;
	
	private String cidade;
	
	private String cep;
}
