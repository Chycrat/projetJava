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
		<form name="formulaire" method="post" action="addReunion">
			<div class="form-style-5">
				<fieldset>
					<legend><span class="number">1</span>Création d'une réunion</legend>
					<input type="date" id="date" name="date" value="2019-11-22" min="2019-01-01" max="2030-12-31">
					<input type="text" name="objectif" placeholder="Objectif *" required>
					<input type="text" name="lieu" placeholder="Lieu *" required>
					<select name="collab" multiple required>
						<c:forEach items ="${collab}" var="col">
							<option value="${col.id_collab}"> ${col.nom}</option>
						</c:forEach>	 
			  		</select>
				</fieldset>
				<input type="submit" value="Création de la réunion">
			</div>
		</form>
	</body>
</html>