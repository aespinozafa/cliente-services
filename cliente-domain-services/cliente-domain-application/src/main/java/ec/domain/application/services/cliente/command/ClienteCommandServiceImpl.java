package ec.domain.application.services.cliente.command;

import ec.domain.application.ports.input.cliente.command.ClienteCommandService;
import ec.domain.application.ports.output.repository.cliente.command.ClienteCommandRepository;
import ec.domain.core.record.request.ClienteRequestRecord;
import ec.domain.core.record.response.ClienteResponseRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClienteCommandServiceImpl implements ClienteCommandService {

  private final ClienteCommandRepository commandRepository;

  @Override
  @Transactional
  public ClienteResponseRecord createOrUpdate(ClienteRequestRecord requestRecord) {
    return commandRepository.createOrUpdate(requestRecord);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    commandRepository.delete(id);
  }
}
