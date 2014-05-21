<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<link rel="stylesheet" href="css/style.css">
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
					<li><a href="#">Creer un Fournisseur</a></li>
					<li><a href="#">Les utilisateurs</a></li>
					<li><a href="#">Creer un utilisateur</a></li>
				</ul>
			</li>
		</ul> <!-- Fin de la class nav (navigation)  -->
		<form name="creerproduit" method="post" action="CTRLProduits" >
			<fieldset>
			    <legend><h2>Création d'un produit</h2></legend>
			    
			    
			    <p>Le nom du produit*: <input type="text" name="creerproduit_nom" required /></p>
				<p>Quantité*: <input type="number" step="1" value="1" min="1" max="5000" name="creerproduit_quantite" required /></p>
				<p>Prix (unitaire)*: <input type="number" step="0.01" min="0.00" max="50000" name="creerproduit_prix" required /></p>
				<p>
					Mettre en vente:<br />
					<label>Oui: <input type="radio" name="creerproduit_enVente" required color-indent="red" /> </label>
					<label>Oui: <input type="radio" name="creerproduit_enVente" required color-indent="red" /></label>
					<br /><label style="color:red">${erreurs_creerproduit.get("enVente")}</label>
				</p>
				<!-- Choix du fournisseur -->
				<label>Choisir un fournisseur:</label><br>
				<select name="creerproduit_fournisseur">
					<c:forEach items="${listeFournisseurs}" var="fournisseur">
						<option value="${fournisseur.getId()" ${type}>${fournisseur.getNom()}</option>
					</c:forEach>
				</select>
				<!-- Ajout d'un commentaire -->				
			    <p>Entrer des informations complémentaires (optionnelles):<br />
			    <textarea name="creerproduit_commentaire"></textarea></p>
			    <p>* Les champs obligatoires. </p>
			</fieldset>
		</form>
	</div>
	
</body>
</html>