package ec.domain.dataaccess.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    name = "cliente",
    schema = "public",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@Where(clause = "estado = true")
public class ClienteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq_gen")
  @SequenceGenerator(name = "cliente_seq_gen", sequenceName = "cliente_id_seq", allocationSize = 1)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @NotNull(message = "{cliente.personaId.notNull}")
  @OneToOne
  @JoinColumn(name = "persona_id", nullable = false)
  private PersonaEntity persona;

  @NotBlank(message = "{cliente.contrasena.notBlank}")
  @Column(name = "contrasena", nullable = false, length = 255)
  private String contrasena;

  @NotNull(message = "{cliente.estado.notNull}")
  @Column(name = "estado", nullable = false)
  private Boolean estado;

  @Transient private StampedLock lock = new StampedLock();

  public StampedLock getLock() {
    return lock;
  }
}
