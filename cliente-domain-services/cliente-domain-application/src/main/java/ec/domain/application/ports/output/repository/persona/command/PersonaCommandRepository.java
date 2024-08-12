package ec.domain.application.ports.output.repository.persona.command;

import ec.domain.core.record.request.PersonaRequestRecord;
import ec.domain.core.record.response.PersonaResponseRecord;

public interface PersonaCommandRepository {

  PersonaResponseRecord createOrUpdate(PersonaRequestRecord personaRequestRecord);

  void delete(Integer id);
}
