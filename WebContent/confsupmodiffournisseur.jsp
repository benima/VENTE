<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@include file="Header.jsp"%>
<body>

       
     
      <div class="main">

<form action="${creerfourni}" method="post">

<p> Nom  : <input name="nomFournisseur" type="text" value="${fournisseur.getNom()}" />${erreurs["nomFournisseur"]}</p>
	<p>
	<label>Adresse : </label> <input name="adrfourni" type="text" value="${fournisseur.getAdresse()}"/>${erreurs["adrfourni"]}</p>
	<p>
	<label>Telephone : </label> <input name="telfourni" type="text" value="${fournisseur.getTelephone()}"/>${erreurs["telfourni"]}</p>
	<p>
	<label>Email : </label> <input name="emailfourni" type="text" value="${fournisseur.getEmail()}"/>${erreurs["emailfourni"]}</p>
<input type="submit" class="btn btn-lg btn-success" value="confirmer" name="action"/>
</form>
</div>
<a href="${accueilURL}" >Accueil</a>
<div class="footer">
        <p>&copy; G2L2 Corp 2014</p>
      </div>
      </div>
      
</body>
</html>
