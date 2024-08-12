package ec.domain.core.record.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ClienteRequestRecord(
    Integer id,
    Integer personaId,
    PersonaRequestRecord persona,
    @NotBlank(message = "{cliente.contrasena.notBlank}") String contrasena,
    @NotNull(message = "{cliente.estado.notNull}") Boolean estado) {}
