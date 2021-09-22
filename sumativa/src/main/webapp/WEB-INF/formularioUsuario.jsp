<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Usuario</title>
</head>
<body>
	<div>
	<h1>Formulario Usuario</h1>
		<form:form action="/usuario/insertar" method="post" modelAttribute="usuario"> <!-- para no pasar parametro por parametro -->
			
			<form:label path="username">Username:</form:label>
			<form:input type="text" path="username"/><br>
			
			<form:label path="telefono">Telefono:</form:label>
			<form:input type="text" path="telefono"/><br>
			
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="email">Email:</form:label>
			<form:input type="text" path="email"/><br>
			
			<form:label path="contrasena">Contrasena:</form:label>
			<form:input type="text" path="contrasena"/><br>
			
			<input type ="submit" value="Insertar Usuario">
		
		</form:form>
	<br>
	
	
	</div>
</body>
</html>