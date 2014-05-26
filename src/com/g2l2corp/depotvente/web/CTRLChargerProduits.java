package com.g2l2corp.depotvente.web;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
		
		Collection<Produit> produits_charges = null;
		
		// On a selectionné le fichier contenant les produits:
		String action = request.getParameter("action");
		
		RequestDispatcher rd;
		//String fichierProduits = request.getParameter("fichierProduits");
		//System.out.println("LE FICHER TELECHARGER EST: "+fichierProduits);
		
<<<<<<< HEAD
		System.out.println("ACTION = "+action+"\n *************************");
		
		if ((action != null) && (action.equals("Charger"))) {
			// le bouton submit "Valider" a été cliqué. On recupère les valeurs entrées.
			String fichierProduits = request.getParameter("fichierProduits");
=======
		if ((action != null) && (action.equals("Charger"))) {
			// le bouton submit "Valider" a été cliqué. On recupère les valeurs entrées.
			String fichierProduits = request.getParameter("ficherProduits");
			System.out.println("LE FICHER TELECHARGER EST: "+fichierProduits);
			
>>>>>>> 8a41026073c655637d0cdad544b72608a484d5b2
			/* On lance le chargement des produits */
			
			String fichier = fichierProduits.replaceAll("[^\\d\\p{L}!#$€%&'`(),;/@...]", "/");
			fichier = fichier.replace("//", "://");
			
			/*Identification du type d'erreur: fichier introuvable. */
			try {
<<<<<<< HEAD
				FileReader fic= new FileReader(fichier);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
				erreurs_chargerfichier.put("error", "Le fichier est introuvable. Merci de verifier le nom du fichier.");
				request.setAttribute("erreurs_chargerfichier", erreurs_chargerfichier);
				rd = request.getRequestDispatcher("chargerproduits.jsp");
				rd.forward(request, response);
				return;
			}
	
			/* Chargement des produits dans le fichier en question: */
			try {
				produits_charges = daoProduit.chargerProduit(fichierProduits);
=======
				System.out.println("111111111111111111111111111111111111111111");
				produits = daoProduit.chargerProduit(fichierProduits);
				System.out.println("222222222222222222222222222222222222222222");
>>>>>>> 8a41026073c655637d0cdad544b72608a484d5b2
			} catch (DAOException e) {
				e.printStackTrace();
				erreurs_chargerfichier.put("error", "Un problème lors du chargement. Merci de verifier le format du fichier.");
				request.setAttribute("erreurs_chargerfichier", erreurs_chargerfichier);
				rd = request.getRequestDispatcher("chargerproduits.jsp");
				rd.forward(request, response);
				return;
			}
<<<<<<< HEAD

			if (produits_charges.isEmpty()) {
				erreurs_chargerfichier.put("error", "Le fichier est vide, il ne contient aucun fichier !!");
=======
			
			if (produits.isEmpty()) {
				erreurs_chargerfichier.put("nom", "Aucun fichier n'a été chargé. Merci de verifier votre fichier.");
>>>>>>> 8a41026073c655637d0cdad544b72608a484d5b2
			}
			
			/* Si pas d'erreur lors du chargement des produits */
			if (erreurs_chargerfichier.isEmpty()) {
				request.setAttribute("produits_charges", produits_charges);
				rd = request.getRequestDispatcher("validechargerproduits.jsp");
			} else { /* Si erreur de chargement des produits */
				request.setAttribute("erreurs_chargerfichier", erreurs_chargerfichier);
				rd = request.getRequestDispatcher("chargerproduits.jsp");
			}
			
			rd.forward(request, response);
			return;
		} /* Fin If ==> Charger Produits. */
		
	} /* Fin doPost. */

}
