<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/show.css" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Elenco Leghe</title>
</head>
<body>
	<div class="styleShow">
		<h1>${message}</h1>
		<table>
			<tr>
				<th><p>Id Categoria</p></th>
				<th><p>Desc Categoria</p></th>
				<th><p>Numero Articoli</p></th>
				<th></th>
			</tr>
			
			<c:forEach var="categoria" items="${categorie}">
		  	<tr>
		  		<td><p>${categoria.idCategoria}</p></td>
					<td><p>${categoria.descCategoria}</p></td>
					<td><p>${categoria.articoli.size()}</p></td>
					<td><s:form method="post" action="${pageContext.request.contextPath}/categoria/deleteCategoria.html"><input type="hidden" name="idcategoria" value="${categoria.idCategoria}"><input type="submit" value="elimina"/></s:form></td>
				</tr>
			</c:forEach>
			
		</table>
		<br>
		<br>
			<center>
				<a href="${pageContext.request.contextPath}/categoria/template.html">Torna alla pagina iniziale</a>
			</center>	
	</div>
</body>
</html>