<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<%@include file="Header.jsp"%>
<body>

 <p>
<form  method="post" action="CTRLCreerFournisseur" >
			<fieldset>
			    <legend><h2>Rechercher le fournisseur à supprimer ou modifier</h2></legend>
			    <p>
			    	L'id du fournisseur: <input type="text" name="idfournisseur" required />
			    	
			    </p>
			   
			    <div><p><input name="action" value="Supprimer" id="Supprimer" type="submit" /> </div><div>  <input name="action" value="Modifier" id="Modifier" type="submit" /> </div></p><br />
			</fieldset>
		</form>
<div class="footer">
        <p>&copy; G2L2 Corp 2014</p>
     
      </div>
      </div>
</body>
</html>