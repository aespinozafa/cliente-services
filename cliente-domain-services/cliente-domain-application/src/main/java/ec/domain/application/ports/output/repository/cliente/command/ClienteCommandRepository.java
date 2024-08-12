package ec.domain.application.ports.output.repository.cliente.command;

import ec.domain.core.record.request.ClienteRequestRecord;
import ec.domain.core.record.response.ClienteResponseRecord;

public interface ClienteCommandRepository {

  ClienteResponseRecord createOrUpdate(ClienteRequestRecord requestRecord);

  void delete(Integer id);
}
