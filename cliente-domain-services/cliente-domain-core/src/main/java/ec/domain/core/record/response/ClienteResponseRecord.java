package ec.domain.core.record.response;

import lombok.Builder;

@Builder
public record ClienteResponseRecord(
    Integer id, PersonaResponseRecord personaId, String contrasena, Boolean estado) {}
