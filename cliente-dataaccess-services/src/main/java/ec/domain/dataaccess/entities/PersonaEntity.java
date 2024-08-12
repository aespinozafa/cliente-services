package ec.domain.dataaccess.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.concurrent.locks.StampedLock;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@DynamicUpdate
@DynamicInsert
@Table(
    name = "persona",
    schema = "public",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@Where(clause = "estado = true")
public class PersonaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq_gen")
  @SequenceGenerator(name = "persona_seq_gen", sequenceName = "persona_id_seq", allocationSize = 1)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @NotBlank(message = "El nombre no puede estar vacío.")
  @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres.")
  @Column(name = "nombre", nullable = false, length = 100)
  private String nombre;

  @Size(max = 10, message = "El género no puede exceder los 10 caracteres.")
  @Column(name = "genero", length = 10)
  private String genero;

  @Column(name = "edad")
  private Integer edad;

  @NotBlank(message = "La identificación no puede estar vacía.")
  @Size(max = 25, message = "La identificación no puede exceder los 25 caracteres.")
  @Column(name = "identificacion", nullable = false, length = 25)
  private String identificacion;

  @NotBlank(message = "La dirección no puede estar vacía.")
  @Size(max = 100, message = "La dirección no puede exceder los 100 caracteres.")
  @Column(name = "direccion", nullable = false, length = 100)
  private String direccion;

  @NotBlank(message = "El teléfono no puede estar vacío.")
  @Size(max = 10, message = "El teléfono no puede exceder los 10 caracteres.")
  @Column(name = "telefono", nullable = false, length = 10)
  private String telefono;

  @Column(name = "estado")
  private Boolean estado;

  @Transient private StampedLock lock = new StampedLock();

  public StampedLock getLock() {
    return lock;
  }
}
