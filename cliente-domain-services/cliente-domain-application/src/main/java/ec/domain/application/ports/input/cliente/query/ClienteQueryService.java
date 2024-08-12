package ec.domain.application.ports.input.cliente.query;

import ec.domain.core.record.response.ClienteResponseRecord;
import java.util.List;

public interface ClienteQueryService {

  List<ClienteResponseRecord> findAllActive();

  ClienteResponseRecord findById(Integer id);
}
