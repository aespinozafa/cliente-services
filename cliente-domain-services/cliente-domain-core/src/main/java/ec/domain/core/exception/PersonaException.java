package ec.domain.core.exception;

import ec.domain.core.exception.global.GlobalException;

public class PersonaException extends GlobalException {

  public PersonaException(String message) {
    super(message);
  }

  public PersonaException(String message, Throwable cause) {
    super(message, cause);
  }
}
