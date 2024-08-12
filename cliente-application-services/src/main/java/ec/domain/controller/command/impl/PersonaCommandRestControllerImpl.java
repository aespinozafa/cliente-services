package ec.domain.controller.command.impl;

import ec.domain.application.ports.input.persona.command.PersonaCommandService;
import ec.domain.controller.command.PersonaCommandRestController;
import ec.domain.core.record.request.PersonaRequestRecord;
import ec.domain.core.record.response.PersonaResponseRecord;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonaCommandRestControllerImpl implements PersonaCommandRestController {

  private final PersonaCommandService commandService;

  @Override
  public PersonaResponseRecord createOrUpdatePersona(
      @Valid PersonaRequestRecord personaResponseRecord) {
    return commandService.createOrUpdate(personaResponseRecord);
  }

  @Override
  public ResponseEntity<String> delete(Integer id) {
    commandService.delete(id);
    return ResponseEntity.ok("Registro borrado exitosamente");
  }
}
