package ec.domain.dataaccess.mappers;

import ec.domain.core.record.response.ClienteResponseRecord;
import ec.domain.dataaccess.entities.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {
  ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

  @Mapping(
      source = "persona",
      target = "personaId") // Mapea la entidad Persona al record PersonaResponseRecord
  ClienteResponseRecord entityToResponseRecord(ClienteEntity entity);
}
