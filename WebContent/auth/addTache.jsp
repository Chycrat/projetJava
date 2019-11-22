<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajout d'une tache</title>
        <link type="text/css" rel="stylesheet" href="auth/page.css" />
    </head>
    <body>  
    
		<c:import url="header.jsp" />
        <form method="post" action="addTache">
        	<div class="form-style-5">
	            <fieldset>
	                <legend>Création d'une tache</legend>
	
	                <label for="nom_tache">Nom <span class="requis">*</span></label>
	                <input type="text" id=nom_tache name="nom_tache" value="" size="20" maxlength="60" />
	                <br />
	                <label for="description">Description <span class="requis">*</span></label>
	                <input type="text" id="description" name="description" value="" size="20" maxlength="60" />
	                <br />
	                <label for="date_reu">date <span class="requis">*</span></label>
	                <input type="date" id="date_reu" name="date_reu"/>
	                <br/> 
	               	<input type="hidden" id="id_reunion" value="${reunion.id_reunion}">
	               	
	                <input type="submit" value="Ajouter" class="sansLabel" />
	                <br />
	            </fieldset>
	          </div>
        </form>
        <a href="http://localhost:8080/gestionCR/listTache">Retour liste</a>
    </body>
</html>