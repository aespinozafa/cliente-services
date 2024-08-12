package ec.domain.dataaccess.mappers;

import ec.domain.dataaccess.entities.PersonaEntity;
import ec.domain.core.record.request.PersonaRequestRecord;
import ec.domain.core.record.response.PersonaResponseRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
  PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

  PersonaResponseRecord entityToResponseRecord(PersonaEntity personaEntity);

  PersonaEntity requestRecordToEntity(PersonaRequestRecord requestRecord);

  void updateEntityFromRequest(
      PersonaRequestRecord requestRecord, @MappingTarget PersonaEntity entity);
}
