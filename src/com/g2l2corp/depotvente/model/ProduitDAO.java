package com.g2l2corp.depotvente.model;

import java.sql.SQLException;
import java.util.Collection;


public interface ProduitDAO {

	Produit findById(int id) throws SQLException, Exception;
	Collection<Produit> findByProvider(Fournisseur fournisseur) throws Exception;
	Collection<Produit> findAll() throws SQLException;
	void create(Produit produit) throws DAOException, SQLException;
	void delete(Produit produit) throws DAOException, Exception;
	//void update(Produit produit int id) throws DAOException;
	void update(Produit produit) throws DAOException, Exception;
	void update(Fournisseur fournisseur) throws DAOException;
	//Collection<Produit> findAllByProvider(Utilisateur utilisateur);
	Collection<Produit> produitsEnVente() throws DAOException;
	Collection<Produit> listeProduits() throws DAOException;

}
