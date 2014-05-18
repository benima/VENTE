<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url var="urlcss1" value="css/etiquettes.css" />
<title>Depôt Vente: Liste des Etiquettes</title>
</head>
<body>
	<p><h1>Les etiquettes des produits en vente:</h1></p>
	
	<c:forEach items="${listeEtiquettes}" var="etiquette">
		<table>
			<tr>
				<td>identifiant produit: ${etiquette.idProduit}</td>
				<td>prix produit: ${etiquette.prixProduit}</td>
			</tr>
		</table>
	</c:forEach>
	<a href="index.jsp">Retour page Accueil</a>	
</body>
</html>