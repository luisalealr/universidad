<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estudiantes</title>
</head>
<body>
	<h3 class="text-center">Listado de Estudiantes</h3>
	<table>
		<jsp:useBean id="eDao" class="universidadweb2.dao.EstudiantesDao"
			scope="request">
		</jsp:useBean>
		<div class="container text-left">
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar
				Nuevo Estudiante</a>
		</div>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Primer previo</th>
			<th>Segundo previo</th>
			<th>Tercer previo</th>
			<th>Promedio</th>
		</tr>
		<c:forEach var="estudiante" items="${listEstudiantes}">
			<tr>
				<td><c:out value="${estudiante.id}" /></td>
				<td><c:out value="${estudiante.nombre}" /></td>
				<td><c:out value="${estudiante.apellido}" /></td>
				<td><c:out value="${estudiante.nota1}" /></td>
				<td><c:out value="${estudiante.nota2}" /></td>
				<td><c:out value="${estudiante.nota3}" /></td>
				<td><c:out value="${estudiante.promedio}" /></td>
				<td><a href="edit?id=<c:out value='${usuario.id}' />">Editar</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="delete?id=<c:out value='${usuario.id}' />">Elimnar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>