<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1>Usuarios</h1>
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
	<h1>Lista de usuarios</h1>
	<table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Username</th>
                    <th>Nombre</th>
                    <th>Telefono</th>
                    <th>Email</th>
                    <th>Contrasena</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach var="usuario" items="${listaUsuarios}">
                        <tr>
                            <td><c:out value=""></c:out></td>
                            <td><c:out value="${usuario.username}"></c:out></td>
                            <td><c:out value="${usuario.nombre}"></c:out></td>
                            <td><c:out value="${usuario.telefono}"></c:out></td>
                            <td><c:out value="${usuario.email}"></c:out></td>
                           	<td><c:out value="${usuario.contrasena}"></c:out></td>
                           	<td>
                            
                            	<a href="/usuario/actualizar/${usuario.id}">Editar</a>
                            
                            	<form action="/usuario/eliminar" method="POST">
									<input type="hidden" name="id" value="<c:out value="${usuario.id}" />" >
									<input type="submit" value="Eliminar">
								</form>
                            
                            </td>
                           
                        </tr>
                    </c:forEach>
                </tr>
            </tbody>
        </table> 
		<br>
		<a href="logout"><input type="button" value="Logout"></a>
	
	</div>
</body>
</html>