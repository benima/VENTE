<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<fieldset>
			<legend><h3>Création d'un nouveau Fournisseur valide !!</h3></legend><br />
			<p style="margin-left: 40px">La création d'un nouveau Fournisseur a été effectué avec succès. </p>
			<p style="margin-left: 40px">Les informations du fournisseur créé:</p>
			<p style="margin-left: 200px; color: white">ID: ${creerfournisseur_fournisseur.getId()}</p>
			<p style="margin-left: 200px; color: white">Nom Complet: ${creerfournisseur_fournisseur.getNom()}</p>
			<p style="margin-left: 200px; color: white">Adresse: ${creerfournisseur_fournisseur.getAdresse()}</p>
			<p style="margin-left: 200px; color: white">Telephone: ${creerfournisseur_fournisseur.getTelephone()}</p>
			<p style="margin-left: 200px; color: white">Email: ${creerfournisseur_fournisseur.getEmail()}</p>
			<p style="margin-left: 40px">La création d'un nouveau Fournisseur est terminée. </p>
		</fieldset>
	</div>
	
</body>
</html>