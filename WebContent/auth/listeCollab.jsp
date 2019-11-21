<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Collaborateurs</title>

</head>
<body>
	<c:forEach items ="${collab}" var"col">
			<li><span class="text"> ${col.id_collab}</span></li>
			<li><span class="text"><${col.prenom}</span></li>
			<li><span class="text"><${col.nom}</span></li>
			<li><span class="text"><${col.login}</span></li>
	</c:forEach>
	
	<li> <a href="http://localhost:8080/gestionCR/addCollab">Liste réunion</a> <li>
	
</body>
</html>