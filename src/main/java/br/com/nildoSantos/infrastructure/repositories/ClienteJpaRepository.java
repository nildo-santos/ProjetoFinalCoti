package br.com.nildoSantos.infrastructure.repositories;

import br.com.nildoSantos.domain.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, UUID> {
}
