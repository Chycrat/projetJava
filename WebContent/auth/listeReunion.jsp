<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Réunions</title>
<link rel="stylesheet" type="text/css" href="auth/page.css"/>
</head>
<body>

	<c:import url="header.jsp" />
			
	<table class="container">
	<thead>
		<tr>
			<th><h1>Id</h1></th>
			<th><h1>Date</h1></th>
			<th><h1>Lieu</h1></th>
			<th><h1>Objectif</h1></th>
			<th><h1>Compte rendu</h1></th>
			<th><h1>      </h1></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items ="${reunion}" var="reu">
			
			<td>${reu.id_reunion}</td>
			<td>${reu.date} </td>
			<td> ${reu.lieu}</td>
			<td> ${reu.objectif}</td>
			<td> ${reu.compte_rendu} </td>
			
			<td><a href="http://localhost:8080/gestionCR/removeReunion?id=${reu.id_reunion}">Supprimer réunion</a><br></td>
			<td><a href="http://localhost:8080/gestionCR/updateReunion?id=${reu.id_reunion}">MaJ réunion</a><br></td>
			<tr></tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="http://localhost:8080/gestionCR/addReunion">
		<table class="container">
			<tbody>
			 	<tr> 
					<td> Créer une réunion</td>
				</tr> 
			</tbody>
		</table>
	</a> 
</body>
</html>