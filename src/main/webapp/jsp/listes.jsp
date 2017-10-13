<%@page import="car.tp4.entity.Liste"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-theme.min.css">

<link rel="stylesheet" type="text/css" href="css/book.css">

<script src="../js/bootstrap.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../js/npm.js"></script>


<title>Home</title>
</head>
<body>
	<h2>Existing ToDo lists</h2>

	<%
		Collection<Liste> listes = (Collection<Liste>) request.getAttribute("listes");
		
		for (Liste lst : listes) {
			out.print("<br>");
			out.print("<p>" + lst.getIntitule() + "</p>");
		}
	%>

	<br>




	<br>





</body>
</html>
