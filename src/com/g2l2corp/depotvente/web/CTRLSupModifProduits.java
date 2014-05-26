package com.g2l2corp.depotvente.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g2l2corp.depotvente.model.DAOException;
import com.g2l2corp.depotvente.model.Produit;
import com.g2l2corp.depotvente.model.ProduitDAOMySQL;

/**
 * Servlet implementation class CTRLSupModifProduits
 */
@WebServlet("/CTRLSupModifProduits")
public class CTRLSupModifProduits extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitDAOMySQL daoProduit = new ProduitDAOMySQL();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTRLSupModifProduits() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		Produit produit = null;
				
		System.out.println("l'action : "+action);
// on souhaite modifier un produit selectionner
		if (action != null && action.equals("Modifier")) {
			String id = request.getParameter("idproduit");
			int idProduit=Integer.parseInt(id);
			System.out.println("id produit : "+idProduit);
			
			try {
				produit = daoProduit.findById(idProduit);
			} catch (DAOException e) {
				e.printStackTrace();
				System.out.println("aucun produit ne correspond à l'id");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("aucun produit ne correspond à l'id");
			}
			session.setAttribute("produit",produit);
			session.setAttribute("type","Modifier");
			System.out.println("nom produit : "+produit.getId());
			//request.setAttribute("nomProduit", produit.getNomProduit());
			RequestDispatcher rd = request.getRequestDispatcher("/confmodifsupproduit.jsp");
			rd.forward(request, response);
			return;
		}
		// on souhaite supprimer le produit spécifié
		if (action != null && action.equals("Supprimer")) {
			String id = request.getParameter("idproduit");
			System.out.println("dans supprimer");
			int idProduit=Integer.parseInt(id);
			try {
				produit = daoProduit.findById(idProduit);
			} catch (DAOException e) {
				e.printStackTrace();
				System.out.println("aucun produit ne correspond à l'id");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("produit",produit);
			session.setAttribute("type","Supprimer");
			request.setAttribute("nomProduit",produit.getNomProduit());
			RequestDispatcher rd = request.getRequestDispatcher("/confmodifsupproduitproduit.jsp");
			rd.forward(request, response);
			return;
		}
		// on confirme  la suppression ou la modification
		if (action != null && action.equals("Confirmer")) {
			if (session.getAttribute("type").equals("Supprimer")) {
				
			}
			if (session.getAttribute("type").equals("Modifier")) {
				
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/confmodifsupproduitproduit.jsp");
		rd.forward(request, response);
	}

}
