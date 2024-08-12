package ec.domain.application.services.cliente.query;

import ec.domain.application.ports.input.cliente.query.ClienteQueryService;
import ec.domain.application.ports.output.repository.cliente.query.ClienteQueryRepository;
import ec.domain.core.record.response.ClienteResponseRecord;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClienteQueryServiceImpl implements ClienteQueryService {

  private final ClienteQueryRepository queryRepository;

  @Override
  public List<ClienteResponseRecord> findAllActive() {

    return queryRepository.findAllActive();
  }

  @Override
  public ClienteResponseRecord findById(Integer id) {
    return queryRepository.findById(id);
  }
}
