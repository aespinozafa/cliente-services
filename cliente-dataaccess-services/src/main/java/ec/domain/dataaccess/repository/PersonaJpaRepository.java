package ec.domain.dataaccess.repository;

import ec.domain.dataaccess.entities.PersonaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaJpaRepository
    extends JpaRepository<PersonaEntity, Integer>, JpaSpecificationExecutor<PersonaEntity> {

  @Query("SELECT c FROM PersonaEntity c")
  List<PersonaEntity> findAllActive();

  PersonaEntity findByIdentificacion(String codigoIdentificacion);
}
