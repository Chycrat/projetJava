<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajout de collaborateur</title>
        <link type="text/css" rel="stylesheet" href="auth/page.css" />
    </head>
    <body>  
    
		<c:import url="header.jsp" />
        <form method="post" action="addCollab">
        	<div class="form-style-5">
	            <fieldset>
	                <legend>Cr�ation d'un user</legend>
	
	                <label for="Nom">Nom <span class="requis">*</span></label>
	                <input type="text" id="Nom" name="Nom" value="" size="20" maxlength="60" />
	                <br />
	                <label for="Prenom">Prenom <span class="requis">*</span></label>
	                <input type="text" id="Prenom" name="Prenom" value="" size="20" maxlength="60" />
	                <br />
	                <label for="Login">Login <span class="requis">*</span></label>
	                <input type="text" id="Login" name="Login" value="" size="20" maxlength="60" />
	                <br />
	                <label for="Password">Mot de passe <span class="requis">*</span></label>
	                <input type="password" id="Password" name="Password" value="" size="20" maxlength="60" />
					<br/>
					<label for="email">Email<span class="requis">*</span></label>
	                <input type="email" id="email" name="email" value="" size="20" maxlength="80" />
					<br/>
	               	<label for="id_role">Role du collaborateur <span class="requis">*</span></label>
	               	<select name="id_role">
		               	<c:forEach items="${role}" var="ro">
						        <option value ="${ro.id_role}">${ro.nom_role}</option>
				        </c:forEach>
					</select>
					</br>
	                <input type="submit" value="Ajouter" class="sansLabel" />
	                <br />
	                <a href="http://localhost:8080/gestionCR/listCollab">Retour</a>
	            </fieldset>
	          </div>
        </form>
        
    </body>
</html>