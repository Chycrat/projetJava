<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Collaborateurs</title>

</head>
<body>
	<%@ include file="/jsp/header.jsp" %>
	<c:forEach items =${collab}" var"collab">
			<span class="text"> ${collab.id}</span>
			<span class="text"></span>${collab.prenom}</span>
			<span class="text"></span>${collab.nom}</span>
			<span class="text"><${collab.login}</span>
			<span class="text"></legend>
	</c:forEach>
</body>
</html>