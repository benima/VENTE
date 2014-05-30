package com.g2l2corp.depotvente.web;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class CTRLCreerFournisseur
 */
@WebServlet("/CTRLCreerFournisseur")
public class CTRLCreerFournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitDAOMySQL fournidao = new ProduitDAOMySQL();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CTRLCreerFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if ((action != null) && (action.equals("creerfournisseur"))) {
			RequestDispatcher rd = request
					.getRequestDispatcher("fournisseur.jsp");
			rd.forward(request, response);
		}

		if ((action != null) && (action.equals("supmodfournisseur"))) {

			RequestDispatcher rd = request
					.getRequestDispatcher("modifsupfournisseur.jsp");
			rd.forward(request, response);
		}
		// Initialisation de la session:
		HttpSession session = request.getSession();
		// Liste des etiquettes:
		List<Fournisseur> listeFournisseurs = null;

		/* On recupère en session l'action effectuée: */

		if ((action != null) && (action.equals("listefournisseurs"))) {
			/*
			 * On a selectionné l'onglet "Les Fournisseurs" pour afficher la
			 * liste de tous les fournisseurs:
			 */
			try {
				listeFournisseurs = (List<Fournisseur>) fournidao
						.findAllFournisseurs();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("listeFournisseurs", listeFournisseurs);
			RequestDispatcher rd = request
					.getRequestDispatcher("listefournisseurs.jsp");
			rd.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		if ((action != null) && (action.equals("Enregistrer"))) {

			String nom = request.getParameter("nomFournisseur");
			String adresse = request.getParameter("adrfourni");
			String tel = request.getParameter("telfourni");
			String mail = request.getParameter("emailfourni");
			Fournisseur fournisseur = new Fournisseur(nom, adresse, tel, mail);
			try {

				fournidao.createFournisseur(fournisseur);
			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		if ((action != null) && (action.equals("Modifier"))) {
			HttpSession session = request.getSession();
			;
			String id = request.getParameter("idfournisseur");
			int idFournisseur = Integer.parseInt(id);
			System.out.println("id fournisseur : " + idFournisseur);
			Fournisseur fournimodif = null;

			try {
				fournimodif = fournidao.findFournisseurById(idFournisseur);
				System.out.println("nom fournisseur : " + fournimodif.getNom());
				System.out.println("adresse : " + fournimodif.getAdresse());
				System.out.println(" email : " + fournimodif.getEmail());
				System.out.println("telephone : " + fournimodif.getTelephone());
				

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("aucun founrisseir ne correspond à l'id");
				RequestDispatcher rd = request
						.getRequestDispatcher("modifsupfournisseur.jsp");
				rd.forward(request, response);
			}
			request.setAttribute("fournisseur", fournimodif);
			RequestDispatcher rd = request
					.getRequestDispatcher("confsupmodiffournisseur.jsp");
			rd.forward(request, response);
		}
		if ((action != null) && (action.equals("confirmer"))) {
			HttpSession session = request.getSession();
		}
			

	}
}
