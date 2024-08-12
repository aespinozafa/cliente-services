package ec.domain.controller.query;

import ec.domain.core.record.response.ClienteResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/query/clientes")
@Validated
public interface ClienteQueryRestController {

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  @Operation(summary = "Obtiene los clientes activos.")
  List<ClienteResponseRecord> findAllActive();

  @GetMapping("/{id}")
  @Operation(summary = "Obtiene el cliente por el id")
  ResponseEntity<ClienteResponseRecord> findById(@PathVariable("id") Integer id);
}
