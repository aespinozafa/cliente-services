package ec.domain.controller.query;

import ec.domain.core.record.response.PersonaResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/query/persona")
@Validated
public interface PersonaQueryRestController {

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  @Operation(summary = "Obtiene los personas activos.")
  List<PersonaResponseRecord> findAllActive();

  @GetMapping("/{id}")
  @Operation(summary = "Obtiene la persona por el id")
  ResponseEntity<PersonaResponseRecord> findById(@PathVariable("id") Integer id);
}
