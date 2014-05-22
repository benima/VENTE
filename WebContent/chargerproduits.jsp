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
					<li><a href="#">Creer un Fournisseur</a></li>
					<li><a href="#">Les utilisateurs</a></li>
					<li><a href="#">Creer un utilisateur</a></li>
				</ul>
			</li>
		</ul> <!-- Fin de la class nav (navigation)  -->
		<form name="chargerproduits" method="post" action="CTRLChargerProduits" >
			<fieldset>
			    <legend><h2>Entrer le chemin complet du fichier contenant des produits au bon format.</h2></legend>
			    <p>
			    	Le nom de votre fichier*: <input type="file" name="fichierProduits"  required />
			    	<label style="color:red">${erreurs_chargerfichier.get("nom")}</label><br />
			    </p>
			    <p><h3>Recommandations:</h3></p>
			    <p style="background-color:#85C630">
			    	Exemple du nom de fichier: <span>FichierProduits.csv</span><br />
			    	Votre fichier doit être placé dans le repertoire suivant: <span>../../../</span><br />
			    	Ce fichier doit être sous la forme: <br />
			    	<span>Nom Complet du fournisseur;Nom du produit;Quantité;Prix</span><br />
			    	Exemple de ligne: <span>Dupont Durand;produit1;5;30</span><br />
			    	Merci d'avance de respecter cette procédure.<br />
			    	Bien Cordialement,<br />
			    	Equipe G2L2 Corp.
			    </p>
			    <p><input type="reset" value="Effacer" name="action" /> <input type="submit" value="OK" name="action" /></p><br />
			</fieldset>
		</form>
	</div>
	
</body>
</html>