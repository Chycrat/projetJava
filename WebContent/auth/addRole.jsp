<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajout d'un r�le</title>
        <link type="text/css" rel="stylesheet" href="auth/page.css" />
    </head>
    <body>  
    
		<c:import url="header.jsp" />
        <form method="post" action="addRole">
        	<div class="form-style-5">
	            <fieldset>
	                <legend>Cr�ation d'un r�le</legend>
	
	                <label for="Nom">Nom</label>
	                <input type="text" id="Nom_role" name="Nom_role" value="" size="20" maxlength="60" />
	                <input type="submit" value="Ajouter" class="sansLabel" />
	                <br />
        			<a href="http://localhost:8080/gestionCR/listRole">Retour</a>
	            </fieldset>
	          </div>
        </form>
    </body>
</html>