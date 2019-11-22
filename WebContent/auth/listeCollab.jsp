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
	
<table class="container">
	<thead>
		<tr>
			<th><h1>Id</h1></th>
			<th><h1>Nom</h1></th>
			<th><h1>Prenom</h1></th>
			<th><h1>Login</h1></th>
			<th><h1>Role</h1></th>
			<th><h1>Email</h1></th>
			<th><h1>      </h1></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items ="${collab}" var="col">
			
			<td>${col.id_collab}</td>
			<td>${col.nom} </td>
			<td> ${col.prenom}</td>
			<td> ${col.login}</td>
			<td> ${col.role.nom_role} </td>
			<td> ${col.email} </td>
			
			<td><a href="http://localhost:8080/gestionCR/removeCollab?id=${col.id_collab}">Supprimer collaborateur</a><br></td>
			<tr></tr>
		</c:forEach>
	</tbody>
	</table>
	
	<table class="container">
		<tbody> <td> <a href="http://localhost:8080/gestionCR/addCollab">Ajouter un collaborateur</a> </td> </tbody>
	</table>
	
</body>
</html>