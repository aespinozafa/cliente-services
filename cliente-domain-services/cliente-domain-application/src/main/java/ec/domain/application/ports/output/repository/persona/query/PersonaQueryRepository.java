package ec.domain.application.ports.output.repository.persona.query;

import ec.domain.core.record.response.PersonaResponseRecord;
import java.util.List;

public interface PersonaQueryRepository {
  List<PersonaResponseRecord> findAllActive();

  PersonaResponseRecord findById(Integer id);
}
