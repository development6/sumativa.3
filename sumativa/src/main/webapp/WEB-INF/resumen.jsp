<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resumen</title>
</head>
<body>
	<div>
		<br>
		<h1>Resumen</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Tipo</th>
					<th>Cantidad</th>
					<th>Acciones</th>
				</tr>
			</thead>

			<tbody>
				<tr>
				
					<c:forEach var="resumen" items="${listaResumenes}">
						<tr>
							<td><c:out value=""></c:out></td>
							<td><c:out value="${resumen.nombre}"></c:out></td>
							<td><c:out value="${resumen.precio}"></c:out></td>
							<td><c:out value="${resumen.tipo}"></c:out></td>
							<td><c:out value="${resumen.cantidad}"></c:out></td>
							
							<td>
							

								<form action="/resumen/eliminar" method="POST">
									<input type="hidden" name="id"
										value="<c:out value="${resumen.id}" />"> <input
										type="submit" value="Eliminar">
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





