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
				<table>
					<thead>
						<tr>
							<th><h1>Id</h1></th>
							<th><h1>Nom</h1></th>
							<th><h1>Description</h1></th>
							<th><h1>DeadLine</h1></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items ="${taches}" var="tache">
							<tr>
								<td>${tache.id_tache}</td>
							
								<td>${tache.nom_tache} </td>
							
								<td> ${tache.description}</td>
							
								<td> ${tache.deadline}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
	</div>	
</body>
</html>