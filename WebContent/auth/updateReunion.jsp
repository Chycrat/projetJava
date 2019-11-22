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
	
	${reunion.id_reunion}
	${reunion.date}
	${reunion.lieu}
	${reunion.objectif}
	${reunion.compte_rendu}

	
	
</body>
</html>