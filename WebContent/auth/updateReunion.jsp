<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Update de réunion</title>
	<link rel="stylesheet" type="text/css" href="auth/page.css"/>
</head>
<body>
	<c:import url="header.jsp" />
	
	<form name="formulaire" method="post" action="updateReunion">
		<div class="form-style-5">
			<fieldset>
				<legend><span class="number">1</span>Mise à jour d'une réunion</legend>
				<span><b>Pour le : </b>${reunion.date}</span><br><br>
				<span><b>Objectif : </b>${reunion.objectif}</span><br><br>
				<span><b>Lieu : </b>${reunion.lieu}</span> <br><br>
				<textarea name="cr" id="cr" style="height: 150px">${reunion.compte_rendu}</textarea>
			</fieldset>
			<input type="hidden" value="${reunion.id_reunion }" name="id_reunion" id="id_reunion"/>
			<input type="submit" value="Mettre à jour de la réunion">
			<a href="http://localhost:8080/gestionCR/addTache?id=${reunion.id_reunion}">  Créer une tache </a> 
		</div>
	</form>
			
</body>
</html>