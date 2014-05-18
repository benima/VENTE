package com.g2l2corp.depotvente.model;

import java.util.Collection;

public interface EtiquetteDAO {
	/* Renvoyer une liste d'etiquettes pour tous les produits en base de données */
	public Collection<Etiquette> creerEtiquette () throws DAOException;
	
	/* Renvoyer une liste d'etiquettes à partir d'une liste de produits */
	public Collection<Etiquette> creerEtiquette (Collection<Produit> produits) throws DAOException;
	
}
