<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajout de collaborateur</title>
        <link type="text/css" rel="stylesheet" href="page.css" />
    </head>
    <body>  
    
		<ul>
			<li> <img src="https://cdn1.iconfinder.com/data/icons/business-and-finance-20/200/vector_65_02-256.png" alt="Team pic" width="5%"> </li>
			<li> <a href="http://localhost:8080/gestionCR/listCollab">Liste des collaborateurs </a> <li>
			<li> <a href="http://localhost:8080/gestionCR/addReunion">Création réunion</a> <li>
			<li> <a href="http://localhost:8080/gestionCR/listeReunion">Liste réunion</a> <li>
		</ul>
		
        <form method="post" action="addCollab">
            <fieldset>
                <legend>Création d'un user</legend>

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
               	<label for="id_role">Role du collaborateur <span class="requis">*</span></label>
               	<select name="id_role">
	               	<c:forEach items="${roles}" var="ro">
					        <option value ="${ro.id_role}">${ro.nom_role}</option>
			        </c:forEach>
				</select>
				</br>
                <input type="submit" value="Ajouter" class="sansLabel" />
                <br />
            </fieldset>
        </form>
        <a href="http://localhost:8080/gestionCR/listCollab">Retour</a>
    </body>
</html>