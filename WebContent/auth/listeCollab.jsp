<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Collaborateurs</title>

</head>
<body>
	<c:forEach items ="${collab}" var"col">
			<span class="text"> ${col.id_collab}</span>
			<span class="text"></span>${col.prenom}</span>
			<span class="text"></span>${col.nom}</span>
			<span class="text"><${col.login}</span>
			<span class="text"></legend>
	</c:forEach>
</body>
</html>