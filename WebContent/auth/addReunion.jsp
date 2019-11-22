<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="fr.cesi.gestioncr.entity.Collab" %>    
<%@page import="fr.cesi.gestioncr.dao.CollabDao" %>   

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="auth/page.css"/>
<meta charset="ISO-8859-1">
<title>Création réunion</title>

</head>
<body>

	<c:import url="header.jsp" />
	<form name="formulaire" method="post" action="/GestionCR/Addreunion">
		<div class="form-style-5">
			<fieldset>
				<legend><span class="number">1</span>Création d'une réunion</legend>
				<input type="date" name="date" placeholder="Date *">
				<input type="text" name="objectif" placeholder="Objectif *">
				<input type="text" name="lieu" placeholder="Lieu *">
				<select name="collab" multiple>
					<c:forEach items =${collab}" var"col">
					<option value=${col.id}> ${col.nom}</option>
					
					
					</c:forEach>	 
		  		</select>
			</fieldset>
			<input type="submit" value="Création de la réunion">
		</div>
	</form>

<br><br>
</body>
</html>