<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="auth/page.css"/>
</head>
<body>
	<c:import url="header.jsp" />
	
	<form name="formulaire" method="post" action="addReunion">
		<div class="form-style-5">
			<fieldset>
				<legend><span class="number">1</span>Mise à jour d'une réunion</legend>
				<span>${reunion.date}</span>
				<span>${reunion.objectif}</span>
				<span>"${reunion.lieu}</span>
				<c:forEach items ="${collab}" var="col">
					<span> ${col.nom}</span>
				</c:forEach>	 
				<textarea name="compte-rendu" id="compte-rendu"  >${reunion.compte_rendu}"</textarea>
			</fieldset>
			<input type="submit" value="Mettre à jour de la réunion">
		</div>
	</form>
			
	<a href="http://localhost:8080/gestionCR/addTache?id=${reunion.id_reunion}">  Créer une tache </a> 
</body>
</html>