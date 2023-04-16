package model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the estudiantes database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="estudiantes")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String apellido;

	private String nombre;

	private Integer nota1;

	private Integer nota2;

	private Integer nota3;
	
	private Integer promedio;
	
	
	public Estudiante(String nombre, String apellido, Integer nota1, Integer nota2, Integer nota3, Integer promedio) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.promedio = promedio;
	}
	
	public int promedioEstudiante(int nota1, int nota2, int nota3) {
		int promedio = (nota1 + nota2 + nota3) / 3;
		return promedio;
	}


}