<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@include file="Header.jsp"%>
<body>
<div class="container">
      
       <h1> Application depot/vente</h1>
      <h2>PAGE FOURNISSEURS</h2>
       
     
      <div class="main">

<form action="${accueilURL}" method="post">
<p> Nom  :<input name="nomFournisseur" type="text" value="${param.nomFournisseur}" />${erreurs["nomFournisseur"]}</p>
	<p>Prenom :<input name="prenomfournisseur" type="text" value="${param.prenomfournisseur}"/>${erreurs["prenomfournisseur"]}</p>
	<p>
	<label>Adresse : </label> <input name="adrfourni" type="text" value="${param.adrfourni}"/>${erreurs["adrfourni"]}</p><br>
	
	<p>
	<label>Telephone : </label> <input name="telfourni" type="text" value="${param.telfourni}"/>${erreurs["telfourni"]}</p><br>
	
	<p>
	<label>Email : </label> <input name="emailfourni" type="text" value="${param.emailfourni}"/>${erreurs["emailfourni"]}</p><br>
	
<input type="submit" class="btn btn-lg btn-success" value="enregistrerfournisseur" name="action"/>
</form>
</div>
<a href="${retourfournisseurURL}" >Retour liste fournisseur</a>
<div class="footer">
        <p>&copy; G2L2 Corp 2014</p>
      </div>
      </div>
      
</body>
</html>
