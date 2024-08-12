package ec.domain.application.services.persona.query;

import ec.domain.application.ports.input.persona.query.PersonaQueryService;
import ec.domain.application.ports.output.repository.persona.query.PersonaQueryRepository;
import ec.domain.core.record.response.PersonaResponseRecord;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonaQueryServiceImpl implements PersonaQueryService {

  private final PersonaQueryRepository queryRepository;

  @Override
  public List<PersonaResponseRecord> findAllActive() {

    return queryRepository.findAllActive();
  }

  @Override
  public PersonaResponseRecord findById(Integer id) {
    return queryRepository.findById(id);
  }
}
