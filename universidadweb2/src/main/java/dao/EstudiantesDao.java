package dao;

import model.Estudiante;
import util.Conexion;

public class EstudiantesDao extends Conexion<Estudiante> {

	public EstudiantesDao() {
		super(Estudiante.class);
	}

}
