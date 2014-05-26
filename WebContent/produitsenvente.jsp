<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/style02.css">
		<title>G2L2Corp: Depôt Vente</title>
	</head>
<body>
	<div id="container">
		<h1 class="titre">Gestion Depôts-Ventes</h1>
		<ul class="nav">
			<li>
				<a href="#">Produits</a>
				<ul class="dropdown">
					<li><a href="CTRLProduits?action=listeproduits">Liste Produits</a></li>
					<li><a href="CTRLProduits?action=produitsenvente">Produits en vente</a></li>
					<li><a href="chargerproduits.jsp">Charger Produits</a></li>
					<li><a href="#">Modifier Produit</a></li>
					<li><a href="CTRLProduits?action=creerproduit">Creer Produit</a></li>
					<li><a href="CTRLEtiquette?action=creeretiquette">Etiquettes des produits</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Ventes</a>
				<ul class="dropdown">
					<li><a href="#">Bilan Vente</a></li>
					<li><a href="#">Vente par Fournisseur</a></li>
					<li><a href="#">Vente par Produit</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Bilan Financier</a>
			</li>
			<li>
				<a href="#">Administration</a>
				<ul class="dropdown">
					<li><a href="CTRLFournisseur?action=listefournisseurs">Les Fournisseurs</a></li>
					<li><a href="creerfournisseur.jsp">Creer un Fournisseur</a></li>
					<li><a href="#">Les utilisateurs</a></li>
					<li><a href="#">Creer un utilisateur</a></li>
				</ul>
			</li>
		</ul> <!-- Fin de la class nav (navigation)  -->
		<p>
			<table class="pv-table">
				<caption class="leTitre"><h2>La liste des Produits en vente</h2></caption>
				<thead class="ttable"> <!-- En-tête du tableau -->
			       <tr>
			           <th>ID Produit</th>
			           <th>ID Fni</th>
			           <th>Nom Prdt</th>
			           <th>Prix</th>
			           <th>Qnt</th>
			           <th>Qnt Vendue</th>
			       </tr>
			   </thead>
			   <tfoot class="ttable"> <!-- Pied de tableau -->
			       <tr>
			           <th>ID Produit</th>
			           <th>ID Fni</th>
			           <th>Nom Prdt</th>
			           <th>Prix</th>
			           <th>Qnt</th>
			           <th>Qnt Vendue</th>
			       </tr>
			   </tfoot>
			   <tbody> <!-- Corps du tableau -->
			   <c:forEach items="${produitsEnVente}" var="produit">
				 <tr>
				 	 <td>${produit.getId()}</td>
				     <td>${produit.getProprietaire().getId()}</td>
				     <td>${produit.getNomProduit()}</td>
				     <td>${produit.getPrixUnitaire()} &euro;</td>
				     <td>${produit.getQuantiteProduit()}</td>
				     <td>${produit.getQuantiteVendue()}</td>
				</tr>
				</c:forEach>
			  </tbody>	
		 </table>
	  </p>
	</div>
</body>
</html>