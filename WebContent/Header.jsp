<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<script id="tinyhippos-injected">if (window.top.ripple) { window.top.ripple("bootstrap").inject(window, document); }</script><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Depotvente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">   
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

  <!-- Urls stylesheet -->
  <c:url var="normalize" value="/_css/normalize.css" > </c:url>
	<c:url var="authenfication" value="/_css/authentif.css" > </c:url>
	<c:url var="urlid" value="/menuAccueil" />
    <c:url var="bootsrap" value="/_css/bootstrap.css" />
    
    
    <!-- url -->
    <c:url var="urlid" value="/menuAccueil" />
    <c:url var="urllist" value="/menuAccueil" />
    <c:url var="accueilURL" value="index.jsp"/>
	<c:url var="retouraccueilURL" value="/menuAccueil.jsp"/>
	<c:url var="accueilURL" value="/depotvente/"/>
	<c:url var="listeproduit" value="/menuAccueil?action=produit"/>
	<c:url var="retouraccueilURL" value="/index.jsp"/>
	<c:url var="retourlisteProduits" value="/listeProduits.jsp"/>
	<c:url var="retourfournisseurURL" value="/menuAccueil.jsp"/>
	<c:url var="listefournisseur" value="/menuAccueil?action=fournisseur"/>
  
    
      
       <!-- StyleSheet -->
    
	<link rel="stylesheet" href="${normalize}" type="text/css" media="screen" />
    <link rel="stylesheet" href="${bootsrap}" type="text/css" media="screen"></link>
    <link rel="stylesheet" href="css/style.css" />
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
					<li><a href="modifsupproduits.jsp">Modifier/supprimer Produit</a></li>
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
					<li><a href="#">Les Fournisseurs</a></li>
					<li><a href="CTRLCreerFournisseur?action=creerfournisseur">Creer un Fournisseur</a></li>
					<li><a href="CTRLCreerFournisseur?action=supmodfournisseur">Modifier Supprimer Fournisseur</a></li>
					<li><a href="#">Les utilisateurs</a></li>
					<li><a href="#">Creer un utilisateur</a></li>
				</ul>
			</li>
		</ul> <!-- Fin de la class nav (navigation)  -->
	
  
