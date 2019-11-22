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
				<input type="date" id="date" name="date" value="${reunion.date}" min="2019-01-01" max="2030-12-31">
				<input type="text" name="objectif" placeholder="Objectif *" value=" ${reunion.objectif}" required>
				<input type="text" name="lieu" placeholder="Lieu *" value="${reunion.lieu}" required>
				<textarea name="compte-rendu" id="compte-rendu"  >${reunion.compte_rendu}"</textarea>
 				<select name="collab" multiple required>
					<c:forEach items ="${collab}" var="col">
						<option value="${col.id_collab}"> ${col.nom}</option>
					</c:forEach>	 
		  		</select>
			</fieldset>
			<input type="submit" value="Mettre à jour de la réunion">
		</div>
	</form>
			
</body>
</html>