package ec.domain.application.ports.output.repository.cliente.query;

import ec.domain.core.record.response.ClienteResponseRecord;
import java.util.List;

public interface ClienteQueryRepository {
  List<ClienteResponseRecord> findAllActive();

  ClienteResponseRecord findById(Integer id);
}
