<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />			      
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Categoria</title>
</head>
<body>
 	<div class="styleMain">
		<s:form method="post" commandName="categoria" action="${operation}">
			<table>
				<tr>
					<td width="10%"><p>Id Categoria</p></td>
					<td width="90%"><s:input path="idCategoria" size="100"/></td>
				</tr>
				<tr>
					<td width="10%"><p>Desc Categoria</p></td>
					<td width="90%"><s:input path="descCategoria" size="100"/></td>
				</tr>
				<tr>
					<td width="10%">&nbsp;</td>
					<td width="90%"><div align="right"><input type="submit" value="conferma"/></div></td>
				</tr>
			</table>
		</s:form> 
	</div>
</body>
</html>