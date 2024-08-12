package ec.domain.controller.query.impl;

import ec.domain.application.ports.input.cliente.query.ClienteQueryService;
import ec.domain.controller.query.ClienteQueryRestController;
import ec.domain.core.record.response.ClienteResponseRecord;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClienteQueryRestControllerImpl implements ClienteQueryRestController {

  private final ClienteQueryService queryService;

  @Override
  public List<ClienteResponseRecord> findAllActive() {
    return queryService.findAllActive();
  }

  @Override
  public ResponseEntity<ClienteResponseRecord> findById(Integer id) {
    return ResponseEntity.ok(queryService.findById(id));
  }
}
