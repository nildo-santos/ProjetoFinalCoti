package br.com.nildoSantos.domain.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

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

    @OneToMany(mappedBy = "cliente")
    List<EnderecoEntity> EnderecoEntity;
}
