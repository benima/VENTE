package com.g2l2corp.depotvente.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EtiquetteDAOMySQL implements EtiquetteDAO {
	
	private static final String NOM_DRIVER="com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/sigdv";
	private static final String user = "root";
	private static final String password = "manager";
	
	private DataSource ds;
	private Connection connexion;
	
	/* Constructeur */
	public EtiquetteDAOMySQL() throws RuntimeException{
		Context ic;
		try {
			ic = new InitialContext();
			this.ds= ( DataSource)ic.lookup("jdbc/sigdv");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	} // Fin Constructeur.

	
	@Override
	public Collection<Etiquette> creerEtiquette() throws DAOException {
		/* Initialisation des données */
		ArrayList<Etiquette> etiquettes = new ArrayList<>();
		Etiquette etiquette;
		ResultSet rs;
		
		try (Connection cx = ds.getConnection()){
			/* La requette à lancer en base de données */
			PreparedStatement statement = cx.prepareStatement("SELECT * FROM produits WHERE enVente=?");
			statement.setString(1,"oui");
			rs = statement.executeQuery();
			while (rs.next()){
				int id = rs.getInt("id");
				int idFournisseur = rs.getInt("fournisseur");
				double prix = rs.getDouble("prix");
				
				/* Construction d'une etiquette pour un produit donné en vente */
				etiquette = new Etiquette(id, idFournisseur, prix);
				
				/* Ajouter l'etiquette dans la liste des étiquettes */
				etiquettes.add(etiquette);
			} /* Fin While. */
			
			/* Tout va bien: on retourne une liste d'étiquettes */
			return etiquettes;
		}
		catch(SQLException ex){
			ex.printStackTrace();
			throw new DAOException(ex.getMessage(),ex);
		} /* Fin try catch. */
		
	} // Fin creerEtiquette.

	
	@Override
	public Collection<Etiquette> creerEtiquette(Collection<Produit> produits) throws DAOException{
		/* A definir: peut être utiliser ? */
		return null;
	}

}
