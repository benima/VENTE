package com.g2l2corp.depotvente.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g2l2corp.depotvente.model.DAOException;
import com.g2l2corp.depotvente.model.Etiquette;
import com.g2l2corp.depotvente.model.Fournisseur;
import com.g2l2corp.depotvente.model.ProduitDAOMySQL;

/**
 * Servlet implementation class CTRLFournisseur
 */
@WebServlet("/CTRLFournisseur")
public class CTRLFournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private ProduitDAOMySQL dao = new ProduitDAOMySQL();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTRLFournisseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Initialisation de la session:
		HttpSession session = request.getSession();
		// Liste des etiquettes:
		List<Fournisseur> listeFournisseurs = null;
		
		/* On recupère en session l'action effectuée: */
		String action = request.getParameter("action");
		
		if ((action != null) && (action.equals("listefournisseurs"))) {
			/* On a selectionné l'onglet "Les Fournisseurs" pour afficher la liste de tous les fournisseurs: */
			try {
				listeFournisseurs =  (List<Fournisseur>) dao.findAllFournisseurs();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("listeFournisseurs", listeFournisseurs);
			RequestDispatcher rd = request.getRequestDispatcher("listefournisseurs.jsp");
			rd.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Initialisation de la session:
		HttpSession session = request.getSession();
		// Liste des etiquettes:
		Fournisseur creerfournisseur_fournisseur = null;
		RequestDispatcher rd;
		
		// Liste des erreurs:
		HashMap<String, String> erreurs_creefournisseur = new HashMap<>();
				
		/* On recupère en session l'action effectuée: */
		String action = request.getParameter("action");
		
		if ((action != null) && (action.equals("Creer"))) {
			/* Recuperation des paramètres saisis dans le formulaire: */
			String creerfournisseur_nom = request.getParameter("creerfournisseur_nom");
			String creerfournisseur_adresse = request.getParameter("creerfournisseur_adresse");
			String creerfournisseur_telephone = request.getParameter("creerfournisseur_telephone");
			String creerfournisseur_email = request.getParameter("creerfournisseur_email");
			String creerfournisseur_commentaire = request.getParameter("creerfournisseur_commentaire");
			
			try {
				creerfournisseur_fournisseur = dao.findFournisseurByName(creerfournisseur_nom);
			}  catch (SQLException | DAOException e) {
				e.printStackTrace();
				erreurs_creefournisseur.put("error", "Probleme d'accès en base de données. Merci de verifier votre connexion aux données.");
				request.setAttribute("erreurs_creefournisseur", erreurs_creefournisseur);
				rd = request.getRequestDispatcher("creerfournisseur.jsp");
				rd.forward(request, response);
				return;
			}
			
			/* Le cas où le fournisseur est déjà en base de données: */
			if (creerfournisseur_fournisseur != null) {
				erreurs_creefournisseur.put("error", "Le Fournisseur existe déjà en base de données. Son ID est: "+creerfournisseur_fournisseur.getId());
			}
			
			/* Si pas d'erreur, alors on créé le fournisseur: */
			if (erreurs_creefournisseur.isEmpty()) {
				try {
					/* creation du fournisseur: */
					dao.createFournisseur(creerfournisseur_nom, creerfournisseur_adresse, creerfournisseur_telephone, creerfournisseur_email, creerfournisseur_commentaire);
					creerfournisseur_fournisseur = dao.findFournisseurByName(creerfournisseur_nom);
				} catch (SQLException | DAOException e) {
					e.printStackTrace();
					erreurs_creefournisseur.put("error", "Probleme d'accès en base de données. Merci de verifier votre connexion aux données.");
					request.setAttribute("erreurs_creefournisseur", erreurs_creefournisseur);
					rd = request.getRequestDispatcher("creerfournisseur.jsp");
					rd.forward(request, response);
					return;
				}
				request.setAttribute("creerfournisseur_fournisseur", creerfournisseur_fournisseur);
				rd = request.getRequestDispatcher("validecreerfournisseur.jsp");
				rd.forward(request, response);
				return;
			}
			
		}
		
		
	}

}
