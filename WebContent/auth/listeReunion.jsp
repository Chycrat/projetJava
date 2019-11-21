<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Réunions</title>

</head>
<body>

	<ul>
		<li> <img src="https://cdn1.iconfinder.com/data/icons/business-and-finance-20/200/vector_65_02-256.png" alt="Team pic" width="5%"> </li>
		<li> <a href="http://localhost:8080/gestionCR/listCollab">Liste des collaborateurs </a> <li>
		<li> <a href="http://localhost:8080/gestionCR/addReunion">Création réunion</a> <li>
		<li> <a href="http://localhost:8080/gestionCR/listeReunion">Liste réunion</a> <li>
	</ul>
	<c:forEach items =${reunions}" var"reunion">
			
			
			
	</c:forEach>
</body>
</html>