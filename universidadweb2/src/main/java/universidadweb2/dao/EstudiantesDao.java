package universidadweb2.dao;

import universidadweb2.model.Estudiante;
import util.Conexion;

public class EstudiantesDao extends Conexion<Estudiante> {

	public EstudiantesDao() {
		super(Estudiante.class);
	}

}
