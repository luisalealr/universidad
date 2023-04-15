<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar nuevo estudiante</title>
</head>
<body>
	<c:if test="${estudiante != null}">
		<form action="update" method="post">
	</c:if>
	<c:if test="${estudiante == null}">
		<form action="insert" method="post">
	</c:if>
	<caption>
		<h2>
			<c:if test="${estudiante != null}">
            	Editar Estudiante
            </c:if>
			<c:if test="${estudiante == null}">
                Agregar Nuevo Estudiante
            </c:if>
		</h2>
	</caption>
	<c:if test="${estudiante != null}">
		<input type="hidden" name="id"
			value="<c:out value='${estudiante.id}' />" />
	</c:if>

	<fieldset class="form-group">
		<label>Nombre de Estudiante</label> <input type="text"
			value="<c:out value='${estudiante.nombre}' />" class="form-control"
			name="nombre" required="required">
	</fieldset>

	<fieldset class="form-group">
		<label>Apellido del Estudiante</label> <input type="text"
			value="<c:out value='${estudiante.apellido}' />" class="form-control"
			name="apellido">
	</fieldset>

	<fieldset class="form-group">
		<label>Nota Primer Previo</label> <input type="text"
			value="<c:out value='${estudiante.nota1}' />" class="form-control"
			name="nota1">
	</fieldset>

	<fieldset class="form-group">
		<label>Nota Segundo Previo</label> <input type="text"
			value="<c:out value='${estudiante.nota2}' />" class="form-control"
			name="nota2">
	</fieldset>

	<fieldset class="form-group">
		<label>Nota Tercer Previo</label> <input type="text"
			value="<c:out value='${estudiante.nota3}' />" class="form-control"
			name="nota3">
	</fieldset>

	<button type="submit" class="btn btn-success">Guardar</button>
</body>
</html>