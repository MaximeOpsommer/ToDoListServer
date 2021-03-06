package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import bean.PanierBean;
import entity.Book;

/**
 * Servlet permettant de valider une commande d'un panier 
 * 
 * @author Serial
 *
 */
@WebServlet("/passerCommande")
public class PasserCommandeServlet extends HttpServlet{
	
	/**
	 * le panier de commande 
	 */
	@EJB
	private PanierBean panierBean;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		panierBean.getPanier().clear();
		response.sendRedirect("/books");
		
	}
}
