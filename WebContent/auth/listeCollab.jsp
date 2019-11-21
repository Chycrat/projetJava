<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Collaborateurs</title>
<link rel="stylesheet" type="text/css" href="page.css"/>
</head>

<body>

	<c:import url="header.jsp" />
	
	<c:forEach items ="${collab}" var="col">
			${col.id_collab} - ${col.nom} - ${col.prenom} - ${col.login}
			<a href="http://localhost:8080/gestionCR/removeCollab?id=${col.id_collab}">Supprimer collaborateur</a><br>
	</c:forEach>
	
	<li> <a href="http://localhost:8080/gestionCR/addCollab">Ajouter un collaborateur</a> <li>
	
	
</body>
</html>