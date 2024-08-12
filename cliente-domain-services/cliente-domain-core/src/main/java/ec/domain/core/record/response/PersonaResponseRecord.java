package ec.domain.core.record.response;

import java.io.Serializable;
import lombok.Builder;

@Builder
public record PersonaResponseRecord(
    Integer id,
    String nombre,
    String genero,
    Integer edad,
    String identificacion,
    String direccion,
    String telefono,
    Boolean estado)
    implements Serializable {}
