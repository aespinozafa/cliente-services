package ec.domain.application.services.persona.command;

import ec.domain.application.ports.input.persona.command.PersonaCommandService;
import ec.domain.application.ports.output.repository.persona.command.PersonaCommandRepository;
import ec.domain.core.record.request.PersonaRequestRecord;
import ec.domain.core.record.response.PersonaResponseRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonaCommandServiceImpl implements PersonaCommandService {

  private final PersonaCommandRepository commandRepository;

  @Override
  @Transactional
  public PersonaResponseRecord createOrUpdate(PersonaRequestRecord personaRequestRecord) {
    return commandRepository.createOrUpdate(personaRequestRecord);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    commandRepository.delete(id);
  }
}
