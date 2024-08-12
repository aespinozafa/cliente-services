package ec.domain.core.record.request;

import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ClienteRequestRecordTest.Config.class})
class ClienteRequestRecordTest {

  @Autowired private Validator validator;

  @BeforeEach
  void setUp() {
    // No es necesario inicializar el validador manualmente, Spring lo hace
  }

  @Test
  void testClienteRequestRecordValid() {
    // Crea un objeto ClienteRequestRecord válido
    ClienteRequestRecord cliente =
        ClienteRequestRecord.builder()
            .id(1)
            .personaId(100)
            .persona(null)
            .contrasena("password123")
            .estado(true)
            .build();

    // Valida el objeto
    Set<ConstraintViolation<ClienteRequestRecord>> violations = validator.validate(cliente);

    // Asegúrate de que no haya violaciones de validación
    assertTrue(violations.isEmpty(), "El objeto ClienteRequestRecord debe ser válido");
  }

  static class Config {
    @Bean
    public Validator validator() {
      return new LocalValidatorFactoryBean();
    }
  }
}
