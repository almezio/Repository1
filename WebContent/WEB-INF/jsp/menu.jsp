<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Homepage Lega</title>
</head>
<body>
  <div class="styleMenu">
		<a href="${pageContext.request.contextPath}/categoria/main.html?op=creaCategoria">Crea una nuova categoria</a><br>
		<a href="${pageContext.request.contextPath}/categoria/main.html?op=creaArticolo">Crea una nuovo articolo</a><br>
		<a href="${pageContext.request.contextPath}/categoria/main.html?op=creaCatConArt">Crea categoria con articoli</a><br>
		<a href="${pageContext.request.contextPath}/categoria/main.html?op=selArtFromCat">Cerca articoli da categoria</a><br>
	  <a href="${pageContext.request.contextPath}/categoria/main.html?op=selCategorie">Cerca tutte le categorie</a><br>
	</div>
</body>
</html>