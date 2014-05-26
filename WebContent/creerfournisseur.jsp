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
					<li><a href="creerfournisseur.jsp">Creer un Fournisseur</a></li>
					<li><a href="#">Les utilisateurs</a></li>
					<li><a href="#">Creer un utilisateur</a></li>
				</ul>
			</li>
		</ul> <!-- Fin de la class nav (navigation)  -->
		<br />
		<form name="creerfournisseur" method="post" action="CTRLFournisseur" >
			<fieldset>
			    <legend><h3>Création d'un Fournisseur</h3></legend>
			    <p style="color: red; margin-left: 20px">${erreurs_creerfournisseur.get("error")}</p>			    
			    <p>Nom Complet du Fournisseur*: <input type="text" size="50" name="creerfournisseur_nom" required placeholder="Exemple: Jean-Pierre DUPONT"/></p>
				<p>Adresse*: <input type="text" size="50" name="creerfournisseur_adresse" required placeholder="Exemple: 5, rue Dubois, 69001 LYON"/></p>
				<p>Telephone*: <input type="tel" size="30" name="creerfournisseur_telephone" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" placeholder="Exemple: 0612345678" required /></p>
				<p>Email du Fournisseur*: <input type="email" size="50" name="creerfournisseur_email" placeholder="Exemple: rolland.dupont@gmail.com" required /></p>
				<!-- Ajout d'un commentaire -->				
			    <p>Entrer des informations complémentaires (optionnelles):<br />
			    <textarea name="creerfournisseur_commentaire" rows="5" cols="50" ></textarea></p>
			    <p>* Les champs obligatoires. </p>
			    <p><input style="margin-left: 100px" type="reset" value="Effacer" name="action" /> <input style="margin-left: 500px" type="submit" value="Creer" name="action"/></p>
			</fieldset>
		</form>
	</div>
	
</body>
</html>