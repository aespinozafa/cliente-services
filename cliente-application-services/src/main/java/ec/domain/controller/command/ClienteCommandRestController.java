package ec.domain.controller.command;

import ec.domain.core.record.request.ClienteRequestRecord;
import ec.domain.core.record.response.ClienteResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/command/clientes")
@Validated
public interface ClienteCommandRestController {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Permite crear o actualizar persona.")
  ClienteResponseRecord createOrUpdatePersona(
      @Valid @RequestBody ClienteRequestRecord requestRecord);

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Elimina un registro por su id.")
  ResponseEntity<String> delete(@Valid @Positive @NotNull @PathVariable("id") Integer id);
}
