<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajout d'un rôle</title>
        <link type="text/css" rel="stylesheet" href="auth/page.css" />
    </head>
    <body>  
    
		<c:import url="header.jsp" />
        <form method="post" action="addRole">
        	<div class="form-style-5">
	            <fieldset>
	                <legend>Création d'un user</legend>
	
	                <label for="Nom">Nom <span class="requis">*</span></label>
	                <input type="text" id="Nom" name="Nom" value="" size="20" maxlength="60" />
	                <input type="submit" value="Ajouter" class="sansLabel" />
	                <br />
	            </fieldset>
	          </div>
        </form>
        <a href="http://localhost:8080/gestionCR/listRole">Retour</a>
    </body>
</html>