package com.g2l2corp.depotvente.web;

import java.io.IOException;
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
import com.g2l2corp.depotvente.model.EtiquetteDAOMySQL;

/**
 * Servlet implementation class CTRLEtiquette
 */
@WebServlet("/CTRLEtiquette")
public class CTRLEtiquette extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* Variables globales utiles */
	private EtiquetteDAOMySQL daoEtiquette = new EtiquetteDAOMySQL();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTRLEtiquette() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Initialisation de la session:
		HttpSession session = request.getSession();
		// Liste des etiquettes:
		List<Etiquette> listeEtiquettes = null;
			
		String action = request.getParameter("action");
		// On a selectionné l'onglet "Etiquettes des produits" pour imprimer les etiquettes:
		
		if (action.equals("creeretiquette")) {
			System.out.println("1111111111111111111111111111111111111111111111111");
			try {
				listeEtiquettes = (List<Etiquette>) daoEtiquette.creerEtiquette();
				System.out.println("2222222222222222222222222222222222222222222222");
			} catch (DAOException e) {
				e.printStackTrace();
			}
			System.out.println("3333333333333333333333333333333333333333");
			request.setAttribute("listeEtiquettes", listeEtiquettes);
			RequestDispatcher rd = request.getRequestDispatcher("afficheretiquettes.jsp");
			rd.forward(request, response);
			return;
		}
		
	} // Fin doGet().

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
