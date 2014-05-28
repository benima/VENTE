package com.g2l2corp.depotvente.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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
				System.out.println("aucun produit ne correspond � l'id");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("aucun produit ne correspond � l'id");
			}
			request.setAttribute("produit", produit);
			session.setAttribute("idProduit",produit.getNomProduit());
			session.setAttribute("nomProduit",produit.getNomProduit());
			session.setAttribute("idFournisseur",produit.getProprietaire().getId());
			session.setAttribute("nomFournisseur",produit.getProprietaire());
			session.setAttribute("commentaireProduit",produit.getCommentaire());
			
			System.out.println("session idproduit "+session.getAttribute("idProduit"));
			RequestDispatcher rd = request.getRequestDispatcher("/confmodifsupproduit.jsp");
			rd.forward(request, response);
			return;
		}
		// on souhaite supprimer le produit sp�cifi�
		if (action != null && action.equals("Supprimer")) {
			String id = request.getParameter("idproduit");
			System.out.println("dans supprimer");
			int idProduit=Integer.parseInt(id);
			try {
				produit = daoProduit.findById(idProduit);
			} catch (DAOException e) {
				e.printStackTrace();
				System.out.println("aucun produit ne correspond � l'id");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("idproduit",produit.getNomProduit());
			session.setAttribute("nomProduit",produit.getNomProduit());
			session.setAttribute("idfournisseur",produit.getProprietaire().getId());
		
			session.setAttribute("nomFournisseur",produit.getProprietaire());
			session.setAttribute("commentaireProduit",produit.getCommentaire());
			
			session.setAttribute("type","Supprimer");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/confmodifsupproduit.jsp");
			rd.forward(request, response);
			return;
		}
		// on confirme  la suppression ou la modification
		if (action != null && action.equals("Confirmer")) {
			System.out.println(action);
			String idF=request.getParameter("idF");
			String Comm= request.getParameter("commentaire");
			String Puni= request.getParameter("prixUnitaire");
			String Qu= request.getParameter("quantite");
			String idP=request.getParameter("idP");
			System.out.println(" session : "+session);
			System.out.println("idfournisseur  "+idF);
			System.out.println("idPropduit  "+idP);
			
			int idFournisseur= Integer.parseInt(idF);
			int idProduit= Integer.parseInt(idP);
			int Qte=Integer.parseInt(Qu);
			double prixUnitaire=Integer.parseInt(Puni);
			
			try {
				// recherche du fournisseur associer au produit � modifier
				System.out.println("phase recherche fournisseur et creation produit");
				Fournisseur fourni = daoProduit.findFournisseurById(idFournisseur);
				System.out.println("Nom Fournisseur : "+fourni.getNom());
				// produit � modifier
				produit= new Produit("nomproduit",prixUnitaire,Qte,fourni,Comm);
				System.out.println("produit � modifer : "+produit.getNomProduit());
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				request.setAttribute("error","erreur SQL");
				System.out.println("erreur SQL : fournisseur non trouv�");
				RequestDispatcher rd = request.getRequestDispatcher("/confmodifsupproduit.jsp");
				rd.forward(request, response);
				return;
			}
			 // lancement de la modification du produit
			try {
				System.out.println("phase maj");
				 daoProduit.update(produit);
				 
			} catch (DAOException e) {
				e.printStackTrace();
				request.setAttribute("error","erreur DAO");
				System.out.println(" erreur DAO aucun produit  trouv�");
				RequestDispatcher rd = request.getRequestDispatcher("/confmodifsupproduit.jsp");
				rd.forward(request, response);
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("error","La mise � jour � �chou�");
				System.out.println("erreur autre :  produit  pas mis � jour");
				RequestDispatcher rd = request.getRequestDispatcher("/confmodifsupproduit.jsp");
				rd.forward(request, response);
				return;
			}
			if (session.getAttribute("type").equals("Supprimer")) {
				
			}
			if (session.getAttribute("type").equals("Modifier")) {
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		
	}

}
