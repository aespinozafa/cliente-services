package ec.domain.application.ports.input.cliente.command;

import ec.domain.core.record.request.ClienteRequestRecord;
import ec.domain.core.record.response.ClienteResponseRecord;

public interface ClienteCommandService {

  ClienteResponseRecord createOrUpdate(ClienteRequestRecord requestRecord);

  void delete(Integer id);
}
