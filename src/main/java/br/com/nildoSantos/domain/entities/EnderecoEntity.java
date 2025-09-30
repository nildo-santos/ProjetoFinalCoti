package br.com.nildoSantos.domain.entities;


import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Endereco")
public class EnderecoEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(name = "logradouro")
	private String logradouro;
	@Column(name = "complemento")
	private String complemento;
    @Column(name = "numero")
	private String numero;
    @Column(name = "bairro")
	private String bairro;
    @Column(name = "uf")
	private String uf;
    @Column(name = "cidade")
	private String cidade;
    @Column(name = "cep")
	private String cep;

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private ClienteEntity cliente;
}
