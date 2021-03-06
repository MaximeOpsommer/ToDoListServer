package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import bean.PanierBean;

/**
 * Servlet permettant la suppression d'un livre du panier de commande
 * et la mise à jour du stock dans la bibliotheque
 * 
 * @author Serial
 *
 */
@WebServlet("/supprimerDuPanier")
public class SupprimerDuPanierServlet extends HttpServlet{
	
	/**
	 * le panier de commande
	 */
	@EJB
	private PanierBean panierBean;
	
	/**
	 * la bibliotheque de livres
	 */
	@EJB
	private BookBean bookBean;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		
		panierBean.removeBook(id);
		bookBean.incrementerStock(id);
		
		response.sendRedirect("/books");
	}

}
