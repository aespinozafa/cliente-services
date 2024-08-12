package ec.domain.controller.query.impl;

import ec.domain.application.ports.input.persona.query.PersonaQueryService;
import ec.domain.controller.query.PersonaQueryRestController;
import ec.domain.core.record.response.PersonaResponseRecord;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonaQueryRestControllerImpl implements PersonaQueryRestController {

  private final PersonaQueryService queryService;

  @Override
  public List<PersonaResponseRecord> findAllActive() {
    return queryService.findAllActive();
  }

  @Override
  public ResponseEntity<PersonaResponseRecord> findById(Integer id) {
    return ResponseEntity.ok(queryService.findById(id));
  }
}
