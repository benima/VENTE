package com.g2l2corp.depotvente.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g2l2corp.depotvente.model.DAOException;
import com.g2l2corp.depotvente.model.Fournisseur;
import com.g2l2corp.depotvente.model.Produit;
import com.g2l2corp.depotvente.model.ProduitDAOMySQL;

/**
 * Servlet implementation class CTRLProduits
 */
@WebServlet("/CTRLProduits")
public class CTRLProduits extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* Variables globales utiles */
	private ProduitDAOMySQL daoProduit = new ProduitDAOMySQL();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTRLProduits() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Liste des produits en vente:
		Collection<Produit> produitsEnVente = null;
					
		// Liste de tous les produits:
		Collection<Produit> listeProduits = null;
		
		// Liste de tous les produits:
		Collection<Fournisseur> fournisseurs = null;
		
		String action = request.getParameter("action");
		// On a selectionné l'onglet "Etiquettes des produits" pour imprimer les etiquettes:
		
		if ((action != null) && (action.equals("produitsenvente"))) {
			try {
				produitsEnVente = daoProduit.produitsEnVente();
			} catch (DAOException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("produitsEnVente", produitsEnVente);
			RequestDispatcher rd = request.getRequestDispatcher("produitsenvente.jsp");
			rd.forward(request, response);
			return;
		}
		
		/* On a selectionné l'onglet "Afficher tous les produits" */
		if ((action != null) && (action.equals("listeproduits"))) {
			try {
				listeProduits = daoProduit.listeProduits();
			} catch (DAOException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("listeProduits", listeProduits);
			RequestDispatcher rd = request.getRequestDispatcher("listeproduits.jsp");
			rd.forward(request, response);
			return;
		}
		
		/* On a selectionné l'onglet "Creer Produit" */
		if ((action != null) && (action.equals("creerproduit"))) {
			try {
				fournisseurs = daoProduit.findAllFournisseurs();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("fournisseurs", fournisseurs);
			RequestDispatcher rd = request.getRequestDispatcher("creerproduit.jsp");
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
		List<Fournisseur> listeFournisseurs = null;
		
		/* On recupère en session l'action effectuée: */
		String action = request.getParameter("action");
		
		if ((action != null) && (action.equals("Creer"))) {
			String nom = request.getParameter("creerproduit_nom");
			int quantite = Integer.parseInt(request.getParameter("creerproduit_quantite"));
			System.out.println("quantite = "+quantite);
			double prix = Double.parseDouble(request.getParameter("creerproduit_prix"));
			String enVente = request.getParameter("creerproduit_enVente");
			int fournisseur = Integer.parseInt(request.getParameter("creerproduit_fournisseur"));
			String commentaire = request.getParameter("creerproduit_commentaire");
			
			/* Création du produit */
			daoProduit.create(nom, quantite, prix, enVente, fournisseur, commentaire);
			
			request.setAttribute("creerproduit_fournisseur", fournisseur);
			request.setAttribute("creerproduit_prix", prix);
			request.setAttribute("creerproduit_nom", nom);
			request.setAttribute("creerproduit_quantite", quantite);
			RequestDispatcher rd = request.getRequestDispatcher("validecreerproduit.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

}
