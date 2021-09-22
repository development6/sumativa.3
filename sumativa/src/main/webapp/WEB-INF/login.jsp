<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario</title>
</head>
<body>
	<div>
	<h1>Usuarios</h1>
		<form action="/usuario/ingresar" method="post"> <!-- para no pasar parametro por parametro -->
			
			<label for="email">Email:</label>
			<input type="text" name="email"/><br>
			
			<label for="contrasena">Contrasena:</label>
			<input type="text" name="contrasena"/><br>
			
			<input type ="submit" value="Iniciar Sesion">
			
			<a href="/usuario/registrar">Registro</a>
			
		</form>
		
	</div>
</body>
</html>