package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstudiantesDao;
import model.Estudiante;

@WebServlet({"/EstudiantesController", "/"})
public class EstudiantesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EstudiantesDao eDao;

	public EstudiantesController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		this.eDao = new EstudiantesDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarUsuario(request, response);
				break;
			case "/delete":
				eliminarUsuario(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarUsuario(request, response);
				break;
			default:
				listUsuarios(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("estudiante.jsp");
		dispatcher.forward(request, response);
	}

	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int nota1 = Integer.parseInt(request.getParameter("nota1"));
		int nota2 = Integer.parseInt(request.getParameter("nota2"));
		int nota3 = Integer.parseInt(request.getParameter("nota3"));
		int promedio = promedioEstudiante(nota1, nota2, nota3);
		Estudiante estudiante = new Estudiante(nombre, apellido, nota1, nota2, nota3, promedio);
		eDao.insert(estudiante);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Estudiante estudianteActual = eDao.find(id);
		request.setAttribute("estudiante", estudianteActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("estudiante.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int nota1 = Integer.parseInt(request.getParameter("nota1"));
		int nota2 = Integer.parseInt(request.getParameter("nota2"));
		int nota3 = Integer.parseInt(request.getParameter("nota3"));
		int id = Integer.parseInt(request.getParameter("id"));
		int promedio = promedioEstudiante(nota1, nota2, nota3);
		Estudiante estudiante = new Estudiante(id, nombre, apellido, nota1, nota2, nota3, promedio);
		eDao.update(estudiante);
		response.sendRedirect("list");
	}

	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Estudiante estudianteActual = eDao.find(id);
		eDao.delete(estudianteActual);
		response.sendRedirect("list");
	}

	private void listUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Estudiante> listEstudiantes = eDao.list();
		request.setAttribute("listEstudiantes", listEstudiantes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("estudiantelist.jsp");
		dispatcher.forward(request, response);
	}

	private int promedioEstudiante(int nota1, int nota2, int nota3) {
		int promedio = (nota1 + nota2 + nota3) / 3;
		return promedio;
	}
}
