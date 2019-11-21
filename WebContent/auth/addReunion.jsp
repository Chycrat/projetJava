<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="fr.cesi.gestioncr.entity.Collab" %>    
<%@page import="fr.cesi.gestioncr.dao.CollabDao" %>   

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="page.css"/>
<meta charset="ISO-8859-1">
<title>Cr�ation r�union</title>

</head>
<body>

	<ul>
		<li> <img src="https://cdn1.iconfinder.com/data/icons/business-and-finance-20/200/vector_65_02-256.png" alt="Team pic" width="5%"> </li>
		<li> <a href="http://localhost:8080/gestionCR/listCollab">Liste des collaborateurs </a> <li>
		<li> <a href="http://localhost:8080/gestionCR/addReunion">Cr�ation r�union</a> <li>
		<li> <a href="http://localhost:8080/gestionCR/listeReunion">Liste r�union</a> <li>
	</ul>
	<form name="formulaire" method="post" action="/GestionCR/Addreunion">
		<div class="form-style-5">
			<fieldset>
				<legend><span class="number">1</span>Cr�ation d'une r�union</legend>
				<input type="date" name="date" placeholder="Date *">
				<input type="text" name="objectif" placeholder="Objectif *">
				<input type="text" name="lieu" placeholder="Lieu *">
				<select name="collab" multiple>
					<c:forEach items =${collab}" var"col">
					<option value=${col.id}> ${col.nom}</option>
					
					
					</c:forEach>	 
		  		</select>
			</fieldset>
			<input type="submit" value="Cr�ation de la r�union">
		</div>
	</form>

<br><br>
</body>
</html>