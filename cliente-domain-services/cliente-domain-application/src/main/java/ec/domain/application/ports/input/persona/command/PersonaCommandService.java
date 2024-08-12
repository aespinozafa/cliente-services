package ec.domain.application.ports.input.persona.command;

import ec.domain.core.record.request.PersonaRequestRecord;
import ec.domain.core.record.response.PersonaResponseRecord;

public interface PersonaCommandService {

  PersonaResponseRecord createOrUpdate(PersonaRequestRecord personaRequestRecord);

  void delete(Integer id);
}
