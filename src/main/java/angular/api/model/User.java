package angular.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="users")
public class User {

    @Id @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String dni;
    private Date fNacimiento;
    private String sexo;
    private String nombrePadre;
    private String apellidoPadre;
    private String nombreMadre;
    private String apellidoMadre;
}
