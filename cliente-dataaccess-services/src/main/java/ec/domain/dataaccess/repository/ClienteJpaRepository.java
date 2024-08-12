package ec.domain.dataaccess.repository;

import ec.domain.dataaccess.entities.ClienteEntity;
import ec.domain.dataaccess.entities.PersonaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJpaRepository
    extends JpaRepository<ClienteEntity, Integer>, JpaSpecificationExecutor<ClienteEntity> {

  @Query("SELECT c FROM ClienteEntity c")
  List<ClienteEntity> findAllActive();

  ClienteEntity findByPersona(PersonaEntity personaEntity);
}
