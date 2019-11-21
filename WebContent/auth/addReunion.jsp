<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="fr.cesi.gestioncr.entity.Collab" %>    
<%@page import="fr.cesi.gestioncr.dao.CollabDao" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cr�ation r�union</title>
 <%@ include file="/jsp/header.jsp" %>
</head>
<body>
<form name="formulaire" method="post" action="/GestionCR/Addreunion">
<div class="form-style-5">
	<fieldset>
		<legend><span class="number">1</span>Cr�ation d'une r�union</legend>
		<input type="date" name="date" placeholder="Date *">
		<input type="text" name="objectif" placeholder="Objectif *">
		<input type="text" name="lieu" placeholder="Objectif *">
		<select name="collab" multiple>
			<c:forEach items =${collabs}" var"collab">
			<option value=${collab.id}> ${collab.nom}</option>
			
			
			</c:forEach>	 
  		</select>
	</fieldset>
	<input type="submit" value="Cr�ation de la r�union">
</div>
</form>

<br><br>
</body>
</html>