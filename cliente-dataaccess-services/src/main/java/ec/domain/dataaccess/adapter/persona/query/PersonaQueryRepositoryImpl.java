package ec.domain.dataaccess.adapter.persona.query;

import ec.domain.application.ports.output.repository.persona.query.PersonaQueryRepository;
import ec.domain.core.exception.PersonaException;
import ec.domain.core.record.response.PersonaResponseRecord;
import ec.domain.dataaccess.entities.PersonaEntity;
import ec.domain.dataaccess.mappers.PersonaMapper;
import ec.domain.dataaccess.repository.PersonaJpaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonaQueryRepositoryImpl implements PersonaQueryRepository {

  private final PersonaJpaRepository jpaRepository;

  @Override
  public List<PersonaResponseRecord> findAllActive() {
    return jpaRepository.findAllActive().stream()
        .map(PersonaMapper.INSTANCE::entityToResponseRecord)
        .toList();
  }

  @Override
  public PersonaResponseRecord findById(Integer id) {
    PersonaEntity personaEntity = getEntityById(id);

    return PersonaMapper.INSTANCE.entityToResponseRecord(personaEntity);
  }

  protected PersonaEntity getEntityById(Integer id) {
    return jpaRepository
        .findById(id)
        .orElseThrow(
            () -> new PersonaException(String.format("La persona con el id %d no existe", id)));
  }
}
