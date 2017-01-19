<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main_articolo.css" type="text/css" />			      
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Categoria</title>
</head>
<body>
 	<div class="styleMainArticolo">
		<s:form method="post" commandName="articolo" action="${operation}">
			<table>
				<tr>
					<td width="10%"><p>Id Articolo</p></td>
					<td width="90%"><s:input path="idArticolo" size="100"/></td>
				</tr>
				<tr>
					<td width="10%"><p>Desc Articolo</p></td>
					<td width="90%"><s:input path="descArticolo" size="100"/></td>
				</tr>
				<tr>
					<td width="10%"><p>Prezzo</p></td>
					<td width="90%"><s:input path="prezzoArticolo" size="100"/></td>
				</tr>
			</table>
			<br><br>
			<table >
				<tr>
					<th></th>
					<th><p>Id Categoria</p></th>
					<th><p>Descrizione</p></th>		
				</tr>			
				<c:forEach var="categoria" items="${categorie}">
	  			<tr>
						<td>
							<input type="radio" name="categoria" value="${categoria.idCategoria}"/>
						</td>
	  				<td><p>${categoria.idCategoria}</p></td>
						<td><p>${categoria.descCategoria}</p></td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
	  			<td></td>
					<td><input type="submit" value="conferma"/></td>
				</tr>
			</table>
		</s:form> 
	</div>
</body>
</html>