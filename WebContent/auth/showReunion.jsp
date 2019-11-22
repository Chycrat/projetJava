<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Réunion</title>
<link rel="stylesheet" type="text/css" href="auth/page.css"/>

</head>
<body>
	<c:import url="header.jsp" />
	
	<div class="form-style-5">
			<fieldset>
				<legend><span class="number">1</span>Réunion </legend>
				<text>${reunion.date}"</text>
				<text>${reunion.objectif}"</text>
				<text>${reunion.lieu}"</text>
				<textarea>${reunion.compte_rendu}"</textarea>
				<c:forEach items ="${collab}" var="col">
					<text> ${col.nom} ${col.prenom}</text>
				</c:forEach>
				
				<c:forEach items ="${tache}" var="tac">
					<text> ${tac.nom_tache} ${tac.description} ${tac.deadline}</text>
				</c:forEach>
						
			</fieldset>
	</div>	
</body>
</html>