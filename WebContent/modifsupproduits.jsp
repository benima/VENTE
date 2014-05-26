<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<%@include file="Header.jsp"%>
<body>
<div class="container">
      <div class="header">
       <h1> Application depot/vente</h1>
      <h2> Liste des VENTE</h2>
    </div>
      <div class="main">
      <p>

	Entrer Id produit <input type="submit" class="btn btn-lg btn-success" value="validervente" name="action"/>
 </div>
 <p>
			<table class="pv-table">
				<caption class="leTitre"><h2>La liste de tous les Produits</h2></caption>
				<thead class="ttable"> <!-- En-tête du tableau -->
			       <tr>
			           <th>ID Produit</th>
			           <th>ID Fni</th>
			           <th>Nom Prdt</th>
			           <th>Prix</th>
			           <th>Qnt</th>
			           <th>Qnt Vendue</th>
			           <th>Commentaire</th>
			       </tr>
			   </thead>
			   <tfoot class="ttable"> <!-- Pied de tableau -->
			       <tr>
			           <th>ID Produit</th>
			           <th>ID Fni</th>
			           <th>Nom Prdt</th>
			           <th>Prix</th>
			           <th>Qnt</th>
			           <th>Qnt Vendue</th>
			           <th>Commentaire</th>
			       </tr>
			   </tfoot>
			   <tbody> <!-- Corps du tableau -->
			   <c:forEach items="${listeProduits}" var="produit">
				 <tr>
				 	 <td>${produit.getId()}</td>
				     <td>${produit.getProprietaire().getId()}</td>
				     <td>${produit.getNomProduit()}</td>
				     <td>${produit.getPrixUnitaire()} &euro;</td>
				     <td>${produit.getQuantiteProduit()}</td>
				     <td>${produit.getQuantiteVendue()}</td>
				     <td>${produit.getCommentaire()}</td>
				</tr>
				</c:forEach>
			  </tbody>	
		  </table>
<div class="footer">
        <p>&copy; G2L2 Corp 2014</p>
     
      </div>
      </div>
</body>
</html>