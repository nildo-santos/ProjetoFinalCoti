package br.com.nildoSantos.infrastructure.repositories;


import br.com.nildoSantos.domain.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, UUID> {

    @Query("""
			select distinct c
			from ClienteEntity c
			left join fetch c.enderecos
			order by c.nome
			""")
    List<ClienteEntity> readAll();


}
