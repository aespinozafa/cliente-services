package ec.domain.dataaccess.adapter.cliente.query;

import ec.domain.application.ports.output.repository.cliente.query.ClienteQueryRepository;
import ec.domain.core.exception.PersonaException;
import ec.domain.core.record.response.ClienteResponseRecord;
import ec.domain.dataaccess.entities.ClienteEntity;
import ec.domain.dataaccess.mappers.ClienteMapper;
import ec.domain.dataaccess.repository.ClienteJpaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClienteQueryRepositoryImpl implements ClienteQueryRepository {

  private final ClienteJpaRepository jpaRepository;

  @Override
  public List<ClienteResponseRecord> findAllActive() {
    return jpaRepository.findAllActive().stream()
        .map(ClienteMapper.INSTANCE::entityToResponseRecord)
        .toList();
  }

  @Override
  public ClienteResponseRecord findById(Integer id) {
    ClienteEntity entity = getClienteEntityById(id);

    return ClienteMapper.INSTANCE.entityToResponseRecord(entity);
  }

  public ClienteEntity getClienteEntityById(Integer id) {
    return jpaRepository
        .findById(id)
        .orElseThrow(
            () -> new PersonaException(String.format("El cliente con el id %d no existe", id)));
  }
}
