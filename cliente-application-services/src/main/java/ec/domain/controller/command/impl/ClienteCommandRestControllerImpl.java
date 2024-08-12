package ec.domain.controller.command.impl;

import ec.domain.application.ports.input.cliente.command.ClienteCommandService;
import ec.domain.controller.command.ClienteCommandRestController;
import ec.domain.core.record.request.ClienteRequestRecord;
import ec.domain.core.record.response.ClienteResponseRecord;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClienteCommandRestControllerImpl implements ClienteCommandRestController {

  private final ClienteCommandService commandService;

  @Override
  public ClienteResponseRecord createOrUpdatePersona(@Valid ClienteRequestRecord requestRecord) {
    return commandService.createOrUpdate(requestRecord);
  }

  @Override
  public ResponseEntity<String> delete(Integer id) {
    commandService.delete(id);
    return ResponseEntity.ok("Registro borrado exitosamente");
  }
}
