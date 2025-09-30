package br.com.nildoSantos.infrastructure;

import br.com.nildoSantos.domain.entities.ClienteEntity;
import br.com.nildoSantos.domain.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {


}
