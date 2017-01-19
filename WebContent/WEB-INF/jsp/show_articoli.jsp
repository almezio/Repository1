<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/show.css" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Elenco Articoli</title>
</head>
<body>
	<div class="styleShow">
		<h1>${message}</h1>
		<table>
			<tr>
				<th><p>Id Articolo</p></th>
				<th><p>Descrizione</p></th>
				<th><p>Prezzo</p></th>
				<th><p>Categoria</p></th>
			</tr>
			
			<c:forEach var="articoli" items="${articoli}">
		  	<tr>
		  		<td><p>${articoli.idArticolo}</p></td>
					<td><p>${articoli.descArticolo}</p></td>
					<td><p>${articoli.prezzoArticolo}</p></td>
					<td><p>${articoli.idCategoria}</p></td>
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