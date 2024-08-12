package ec.domain.dataaccess.adapter.cliente.command;

import ec.domain.application.ports.output.repository.cliente.command.ClienteCommandRepository;
import ec.domain.application.ports.output.repository.persona.command.PersonaCommandRepository;
import ec.domain.core.exception.PersonaException;
import ec.domain.core.record.request.ClienteRequestRecord;
import ec.domain.core.record.request.PersonaRequestRecord;
import ec.domain.core.record.response.ClienteResponseRecord;
import ec.domain.core.record.response.PersonaResponseRecord;
import ec.domain.dataaccess.entities.ClienteEntity;
import ec.domain.dataaccess.entities.PersonaEntity;
import ec.domain.dataaccess.mappers.ClienteMapper;
import ec.domain.dataaccess.repository.ClienteJpaRepository;
import ec.domain.dataaccess.repository.PersonaJpaRepository;
import java.util.concurrent.locks.StampedLock;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClienteCommandRepositoryImpl implements ClienteCommandRepository {

  private final ClienteJpaRepository jpaRepository;
  private final PersonaCommandRepository personaCommandRepository;
  private final PersonaJpaRepository personaJpaRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public ClienteResponseRecord createOrUpdate(ClienteRequestRecord requestRecord) {
    ClienteEntity entity = createOrUpdateData(requestRecord);
    ClienteEntity savedEntity = jpaRepository.save(entity);

    return ClienteMapper.INSTANCE.entityToResponseRecord(savedEntity);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    var entity =
        jpaRepository
            .findById(id)
            .orElseThrow(() -> new PersonaException("El código del cliente no existe: " + id));

    final StampedLock lock = entity.getLock();
    long stamp = lock.writeLock();
    try {
      entity.setEstado(false);
      jpaRepository.save(entity);
    } finally {
      lock.unlockWrite(stamp);
    }
  }

  protected PersonaEntity getSearchPersonaEntity(Integer id, PersonaRequestRecord personaRequest) {
    PersonaEntity personaEntity = null;
    if (id != null) {
      personaEntity = getFuncionarioEntityById(id);
    } else if (personaRequest != null) {
      try {
        PersonaResponseRecord personaResponse =
            personaCommandRepository.createOrUpdate(personaRequest);
        personaEntity =
            personaJpaRepository
                .findById(personaResponse.id())
                .orElseThrow(
                    () ->
                        new PersonaException(
                            "Error al recuperar la entidad Persona después de guardarla"));
      } catch (Exception e) {
        throw new PersonaException(
            "Error al crear o actualizar la entidad Persona: " + e.getMessage(), e);
      }
    } else {
      throw new PersonaException("Debe proporcionar un personaId o los detalles de la persona.");
    }
    return personaEntity;
  }

  private ClienteEntity createOrUpdateData(ClienteRequestRecord requestRecord) {
    PersonaEntity personaEntity =
        getSearchPersonaEntity(requestRecord.personaId(), requestRecord.persona());
    ClienteEntity entity = jpaRepository.findByPersona(personaEntity);
    if (entity != null) {
      updateClienteEntity(entity, requestRecord);
      return entity;
    }

    if (requestRecord.id() != null) {
      entity =
          jpaRepository
              .findById(requestRecord.id())
              .orElseThrow(
                  () ->
                      new PersonaException(
                          "El código del cliente no existe: " + requestRecord.id()));
    } else {
      entity = new ClienteEntity();
    }

    entity.setPersona(personaEntity);
    String encryptedPassword = passwordEncoder.encode(requestRecord.contrasena());
    entity.setContrasena(encryptedPassword);
    entity.setEstado(requestRecord.estado());

    return entity;
  }

  private void updateClienteEntity(ClienteEntity entity, ClienteRequestRecord requestRecord) {
    // Aquí actualizas las propiedades del cliente existente con la nueva información del request
    entity.setContrasena(passwordEncoder.encode(requestRecord.contrasena()));
    entity.setEstado(requestRecord.estado());
  }

  protected PersonaEntity getFuncionarioEntityById(Integer id) {
    return personaJpaRepository
        .findById(id)
        .orElseThrow(
            () -> new PersonaException(String.format("La persona con el id %d no existe", id)));
  }
}
