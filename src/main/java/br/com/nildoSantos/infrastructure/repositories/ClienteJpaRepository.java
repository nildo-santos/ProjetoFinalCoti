package br.com.nildoSantos.infrastructure.repositories;

import br.com.nildoSantos.domain.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, UUID> {
}
