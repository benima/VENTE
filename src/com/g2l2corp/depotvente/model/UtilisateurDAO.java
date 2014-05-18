package com.g2l2corp.depotvente.model;

import java.sql.SQLException;
import java.util.Collection;

public interface UtilisateurDAO {
	Utilisateur verif(String pseudo, String pwd) throws DAOException;
	void create(Utilisateur d) throws DAOException, SQLException;
	void update(Utilisateur d) throws DAOException;
	void delete(Utilisateur d) throws DAOException;
	Collection<Utilisateur> findAll();
}
