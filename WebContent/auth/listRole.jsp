<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>

<html>
	
	<head>
		<meta charset="ISO-8859-1">
		<title>R�les</title>
		<link rel="stylesheet" type="text/css" href="auth/page.css"/>
	</head>
	
	<body>
		<c:import url="header.jsp" />
		<h1>LISTE DES ROLES</h1>
		
		<table class="container">
			<tbody>
				<c:forEach items ="${role}" var="rol">
					<td>${rol.id_role}</td>
					<td>${rol.nom_role} </td>
					<td><a href="http://localhost:8080/gestionCR/removeRole?id=${reu.id_reunion}">Supprimer un r�le</a><br></td>
				<tr></tr>
				</c:forEach>
			</tbody>
		
		</table>
		<a href="http://localhost:8080/gestionCR/addRole">
		<table class="container">
			<tbody> <td> Cr�er un r�le </td> </tbody>
		</table>
		</a>
	
	
	</body>
	
</html>