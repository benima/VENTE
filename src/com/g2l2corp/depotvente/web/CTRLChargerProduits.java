package com.g2l2corp.depotvente.web;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

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
 * Servlet implementation class CTRLChargerProduits
 */
@WebServlet("/CTRLChargerProduits")
public class CTRLChargerProduits extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProduitDAOMySQL daoProduit = new ProduitDAOMySQL(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTRLChargerProduits() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Initialisation de la session:
		//HttpSession session = request.getSession();
		
		// Liste des erreurs:
		HashMap<String, String> erreurs_chargerfichier = new HashMap<>();
		
		Collection<Produit> produits = null;
		
		// On a selectionné le fichier contenant les produits:
		String action = request.getParameter("action");
		
		RequestDispatcher rd;
		//String fichierProduits = request.getParameter("fichierProduits");
		//System.out.println("LE FICHER TELECHARGER EST: "+fichierProduits);
		
		System.out.println("ACTION = "+action+"\n *************************");
		
		if ((action != null) && (action.equals("OK"))) {
			// le bouton submit "Valider" a été cliqué. On recupère les valeurs entrées.
			String fichierProduits = request.getParameter("fichierProduits");
			System.out.println("LE FICHER TELECHARGER EST: "+fichierProduits);
			System.out.println("00000000000000000000   000000000000000000   0000000000000000000000");
			System.out.println("00000000000000000000   000000000000000000   0000000000000000000000");
			System.out.println("00000000000000000000   000000000000000000   0000000000000000000000");
			System.out.println("00000000000000000000   000000000000000000   0000000000000000000000");
			System.out.println("00000000000000000000   000000000000000000   0000000000000000000000");
			/* On lance le chargement des produits */
			try {
				System.out.println("111111111111111111111111111111111111111111");
				System.out.println(fichierProduits);
				produits = daoProduit.chargerProduit("C:/Users/BEN/Documents/CQP/STAGE2014-01/SWSandro/Docs/FicherProduit01.csv");
				System.out.println("222222222222222222222222222222222222222222");
			} catch (DAOException e) {
				e.printStackTrace();
			}
			/*
			if (produits.isEmpty()) {
				erreurs_chargerfichier.put("nom", "Aucun fichier n'a été chargé. Merci de verifier votre fichier.");
			}
			*/
			/* Si pas d'erreur lors du chargement des produits */
			if (erreurs_chargerfichier.isEmpty()) {
				rd = request.getRequestDispatcher("chargerproduitsvalide.jsp");
			} else { /* Si erreur de chargement des produits */
				request.setAttribute("erreurs_chargerfichier", erreurs_chargerfichier);
				rd = request.getRequestDispatcher("chargerproduits.jsp");
			}
			rd.forward(request, response);
			return;
		} /* Fin If. */
		
	} /* Fin doPost. */

}
