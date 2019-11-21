<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Connexion</title>
		<link rel="stylesheet" type="text/css" href="jsp/page.css"/>
	</head>
	 
	<body>
		<br><br>
		<form name="formulaire" method="post" action="login">
			<div class="form-style-5">
				<fieldset>
					<legend><span class="number">1</span>Information de connexion</legend>
					<input type="text" name="name" placeholder="Your Name *" required>
					<input type="password" name="password" placeholder="Your password * " required>
				</fieldset>
				<input type="submit" value="Connexion">
			</div>
		</form>
	
	
	</body>
</html>

