package br.com.nildoSantos.domain.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Cliente")
public class ClienteEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(name ="email", nullable = false)
	private String email;
	@Column(name = "cpf", unique = true, nullable = false, length = 11)
	private String cpf;
	@Column(name = "dataNascimento")
	private LocalDate dataNascimento;

    @OneToMany(mappedBy = "cliente_id")
    List<EnderecoEntity> EnderecoEntity;
}
