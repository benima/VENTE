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
		<form name="chargerproduits" method="post" action="CTRLChargerProduits" >
			<fieldset>
			    <legend><h3>Entrer le chemin complet du fichier contenant des produits au bon format</h3></legend>
			    <p>
			    	Le nom de votre fichier*: <input type="text" name="fichierProduits" size="100" placeholder="Entrez le chemin complet du fichier svp." required />
			    	<label style="color:red">${erreurs_chargerfichier.get("error")}</label><br />
			    </p>
			    <p><h4>Recommandations:</h4></p>
			    <p style="background-color:#85C630">
			    	<br />Exemple du nom de fichier: <code>G2L2Produits.csv</code><br />
			    	Le nom complet du chemin de votre fichier ne doit pas contenir d'espace(s) ou des caractères spéciaux:
			    	<br /><code>! § , ; & é ~ < " > # ' { ( ) [ ] - | è ` _ / ç ^ à @ = + ù % ê ^ £ $ ¤ </code><br />
			    	Ce fichier <code>csv</code> doit être sous la forme: <br />
			    	<code>Nom Complet du fournisseur;Nom du produit;Quantité;Prix</code><br />
			    	Exemple de ligne: <br /><code>Dupont Durand;produit 1;5;30</code><br />
			    	Exemple de chemin complet d'un fichier produit: 
			    	<br /><code>C:\Users\BEN\Documents\CQP\STAGE2014\Datas\G2L2Produits31052014.csv</code><br />
			    	<br />Merci d'avance de respecter cette procédure.<br />
			    	<br />Bien Cordialement,<br />
			    	<br />Equipe G2L2 Corp.<br />. 
			    </p><br />
			    <p><input type="reset" value="Effacer" name="action" /> <input type="submit" value="Charger" name="action" /></p><br />
			</fieldset>
		</form>
	</div>
	
</body>
</html>