package ec.domain.core.record.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Builder;

@Builder
public record PersonaRequestRecord(
    Integer id,
    @NotBlank(message = "El nombre no puede estar vacío.")
        @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres.")
        String nombre,
    @Size(max = 10, message = "El género no puede exceder los 10 caracteres.") String genero,
    Integer edad,
    @NotBlank(message = "La identificación no puede estar vacía.")
        @Size(max = 25, message = "La identificación no puede exceder los 25 caracteres.")
        String identificacion,
    @NotBlank(message = "La dirección no puede estar vacía.")
        @Size(max = 255, message = "La dirección no puede exceder los 255 caracteres.")
        String direccion,
    @NotBlank(message = "El teléfono no puede estar vacío.")
        @Size(max = 15, message = "El teléfono no puede exceder los 15 caracteres.")
        String telefono,
    Boolean estado)
    implements Serializable {}
