<%@page import="car.tp4.entity.Item"%>

<%@page import="java.util.Collection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ToDo List online : Edit</title>

</head>
<body>

	<%
		Long idListe = (Long) request.getAttribute("idListe");
		String intitule = (String)request.getAttribute("intitule");
		List<Item> items = (List<Item>) request.getAttribute("items");
		out.print("<h1>Détails de la liste : " + intitule + "</h1>");
		out.print("<br>");
	%>
	
	<%
		if(items.isEmpty()) {
			out.print("<p>Aucun item n'est présent dans cette liste.</p>");
		}
	%>
	
	<table id="table">
		<tbody>

			<%
				for (Item item : items) {
					out.print("<tr>");
					out.print("<td>" + item.getIntitule() + "</td>");
					
					// checkbox Done
					out.print("<td><input name=\"id\" value=\"" + item.getId() + "\"  type=\"checkbox\" class=\"doneTask\" disabled=\"disabled\"");
					if(item.isRealisee()) {
						out.print(" checked=\"true\"");
					}
					out.print(">");
					
					// bouton pour valider un item
					out.print("<td><form method=\"POST\" action=\"/editListe\">");
					out.print("<input hidden name=\"id\" value=\"" + item.getId() + "\"></div>");
					out.print("<input type=\"submit\" value=\"Done\">");
					out.print("</form></td>");
					
					out.print("</tr>");
				}
			%>
		</tbody>

	</table>
	
	<br>
	
	<p>
		Nouvelle tâche
	</p>
	
	<div class="row">
		<form method="POST" action="ajouterUnItem">
			<input hidden name="idListe" value=<%= idListe %>>
			<input type="text" name="intituleItem">
			<button type="submit">Ajouter</button>
		</form>
	</div>

</body>
</html>