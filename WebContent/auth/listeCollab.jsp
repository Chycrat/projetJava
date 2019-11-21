<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Collaborateurs</title>
<link rel="stylesheet" type="text/css" href="auth/page.css"/>
</head>

<body>

	<c:import url="header.jsp" />
	
	<c:forEach items ="${collab}" var="col">
			${col.id_collab} - ${col.nom} - ${col.prenom} - ${col.login}
			<a href="http://localhost:8080/gestionCR/removeCollab?id=${col.id_collab}">Supprimer collaborateur</a><br>
	</c:forEach>
	
	<div id="wrapper">
		  <a href="http://localhost:8080/gestionCR/addCollab" class="my-super-cool-btn">
		    <div class="dots-container">
		      <div class="dot"></div>
		      <div class="dot"></div>
		      <div class="dot"></div>
		      <div class="dot"></div>
		    </div>
		    <span>Go!</span>
		  </a>
	</div>
	<a href="http://localhost:8080/gestionCR/addCollab">Ajouter un collaborateur</a>
	
	
</body>
</html>