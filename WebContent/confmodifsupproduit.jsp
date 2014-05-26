<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@include file="Header.jsp"%>
<body>

      <div class="main">

<form action="${accueilURL}" method="post">
<p> Nom  :<input name="nomProduit" required type="text" value="${param.nomProduit}" />${erreurs["nomProduit"]}</p>
	<p>Fournisseur :<input name="fournisseur" required type="text" value="${param.fournisseur}"/>${erreurs["fournisseur"]}</p>
	<p>
	<label>Prix unitaire : </label> <input name="prixUnitaire" required type="text" value="${param.prixUnitaire}"/>${erreurs["prixUnitaire"]}</p><br>
	<label>Quantité : </label> <input name="quantite" required type="text" value="${param.quantite}"/>${erreurs["quantite"]}</p><br>
	<label>Lot</label>
	oui :<input type="radio" name="lot" value="true" title="oui" id="radiobouton"> non :<input type="radio" title="non" name="lot" value="false" id="radiobouton"><br>${erreurs["lot"]} <br>
	<p>
 <input type="submit" class="btn btn-lg btn-success" value="Confirmer" name="action"/>
</form>

<a href="${retourlisteProduits}" >retour</a>
<div class="footer">
        <p>&alright; G2L2 Corp 2014</p>
      </div>
      </div>
      </div>
      
</body>
</html>
