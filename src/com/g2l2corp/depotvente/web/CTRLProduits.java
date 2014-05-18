package com.g2l2corp.depotvente.web;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.g2l2corp.depotvente.model.DAOException;
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
		// TODO Auto-generated method stub
		
		// Initialisation de la session:
		//HttpSession session = request.getSession();
		
		// Liste des produits en vente:
		Collection<Produit> produitsEnVente = null;
					
		// Liste de tous les produits:
		Collection<Produit> listeProduits = null;
		
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
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
