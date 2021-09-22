<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario</title>
</head>
<body>
	<div>
		<form:form action="/usuario/modificar" method="post" modelAttribute="usuario">
			<input type="hidden" name="_method" value="put" >
			<form:hidden path="id"/>
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
			
			<input type="submit" value="Modificar Usuario">
		</form:form>
		
	</div>
</body>
</html>