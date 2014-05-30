<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@include file="Header.jsp"%>
<body>

      <div class="main">

<form action="CTRLSupModifProduits" method="post">

	<p> id Produit : ${produit.getId()} <p>
	
	
	<p> Nom  :<input name="nomProduit" required type="text" value="${produit.getNomProduit()}" />${erreurs["nomProduit"]}</p>
	<p>Fournisseur : "${produit.getProprietaire().getNom()}"</p>
	<p>
	<label>Prix unitaire : </label> <input name="prixUnitaire" required type="text" value="${produit.getPrixUnitaire()}"/>${erreurs["prixUnitaire"]}</p>
	<label>Quantité : </label> <input name="quantite" required type="text" value="${produit.getQuantiteProduit()}"/>${erreurs["quantite"]}</p>
	<label>quantité vendu : </label> <input name="quantitevendu" required type="text" value="${produit.getQuantiteVendue()}"/>${erreurs["commentaire"]}</p>
	<label>Commentaire : </label> <input name="commentaire" required type="text" value="${produit.getCommentaire()}"/>${erreurs["commentaire"]}</p>
	<label>En vente : </label> <input name="enVente" required type="text" value="${produit.isEnVente()}"/>${erreurs["commentaire"]}</p>
	<p> Type<input name="type"  type="text" value="${param.type}" /></p>
	
	<p> <input name="idP"  type="text" Hidden=true value="${produit.getId()}" /></p>
	<p> <input name="idF"  type="text" Hidden=true value="${produit.getProprietaire().getId()}" /></p>
	
 <input type="submit" class="btn btn-lg btn-success" value="Confirmer" name="action"/> <bold>${error}</bold>
</form>

<a href="${retourlisteProduits}" >retour</a>
<div class="footer">
        <p> G2L2 Corp 2014</p>
      </div>
      </div>
      </div>
      
</body>
</html>
