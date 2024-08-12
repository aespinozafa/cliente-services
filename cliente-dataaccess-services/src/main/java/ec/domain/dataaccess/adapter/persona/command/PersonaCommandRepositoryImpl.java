package ec.domain.dataaccess.adapter.persona.command;

import ec.domain.application.ports.output.repository.persona.command.PersonaCommandRepository;
import ec.domain.core.exception.PersonaException;
import ec.domain.core.record.request.PersonaRequestRecord;
import ec.domain.core.record.response.PersonaResponseRecord;
import ec.domain.dataaccess.entities.PersonaEntity;
import ec.domain.dataaccess.mappers.PersonaMapper;
import ec.domain.dataaccess.repository.PersonaJpaRepository;
import java.util.concurrent.locks.StampedLock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonaCommandRepositoryImpl implements PersonaCommandRepository {

  private final PersonaJpaRepository jpaRepository;

  @Override
  @Transactional
  public PersonaResponseRecord createOrUpdate(PersonaRequestRecord personaRequestRecord) {
    PersonaEntity personaEntity = createOrUpdatePersona(personaRequestRecord);
    return PersonaMapper.INSTANCE.entityToResponseRecord(jpaRepository.save(personaEntity));
  }

  @Override
  @Transactional
  public void delete(Integer id) {

    var entity =
        jpaRepository
            .findById(id)
            .orElseThrow(() -> new PersonaException("El codigo de la persona no existe %d." + id));

    final StampedLock lock = entity.getLock();
    long stamp = lock.writeLock();
    try {
      entity.setEstado(false);
      jpaRepository.save(entity);
    } finally {
      lock.unlockWrite(stamp);
    }
  }

  private PersonaEntity createOrUpdatePersona(PersonaRequestRecord personaRequestRecord) {
    PersonaEntity personaEntity =
        jpaRepository.findByIdentificacion(personaRequestRecord.identificacion());

    if (personaEntity == null) {
      personaEntity = PersonaMapper.INSTANCE.requestRecordToEntity(personaRequestRecord);
    } else {
      Integer id = personaEntity.getId();
      final StampedLock lock = personaEntity.getLock();
      long stamp = lock.writeLock();
      try {
        PersonaMapper.INSTANCE.updateEntityFromRequest(personaRequestRecord, personaEntity);
      } finally {
        lock.unlockWrite(stamp);
      }
      personaEntity.setId(id);
      personaEntity.setEstado(true);
    }
    return personaEntity;
  }
}
