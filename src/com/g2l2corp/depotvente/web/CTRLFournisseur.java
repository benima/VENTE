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
		// TODO Auto-generated method stub
	}

}
