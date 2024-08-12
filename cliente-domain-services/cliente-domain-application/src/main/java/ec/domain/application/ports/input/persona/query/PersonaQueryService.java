package ec.domain.application.ports.input.persona.query;

import ec.domain.core.record.response.PersonaResponseRecord;
import java.util.List;

public interface PersonaQueryService {

  List<PersonaResponseRecord> findAllActive();

  PersonaResponseRecord findById(Integer id);
}
