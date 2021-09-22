<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto</title>
</head>
<body>
	<div>
	<h1>Productos</h1>
		<form:form action="/producto/insertar" method="post"
			modelAttribute="producto">
			<!-- para no pasar parametro por parametro -->

			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre" />
			<br>

			<form:label path="precio">Precio:</form:label>
			<form:input type="text" path="precio" />
			<br>

			<form:label path="tipo">Tipo:</form:label>
			<form:input type="text" path="tipo" />
			<br>

			<input type="submit" value="Insertar Producto">

		</form:form>

		<br>
		<h1>Lista de productos</h1>
		
		
		
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Tipo</th>
					<th>Acciones</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<c:forEach var="producto" items="${listaProductos}">
						<tr>
							<td><c:out value=""></c:out></td>
							<td><c:out value="${producto.nombre}"></c:out></td>
							<td><c:out value="${producto.precio}"></c:out></td>
							<td><c:out value="${producto.tipo}"></c:out></td>
							<td>
                            
                            	<a href="/producto/actualizar/${producto.id}">Editar</a>
                            
                            	<form action="/producto/eliminar" method="POST">
									<input type="hidden" name="id" value="<c:out value="${producto.id}" />" >
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