package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import entity.Book;

/**
 * Servlet permettant la création d'un livre et son ajout dans la bibliotheque
 * 
 * @author Serial
 *
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {

	/**
	 * la bibliotheque de livre
	 */
	@EJB
	private BookBean bookBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("books", bookBean.getAllBooks());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/create.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");

	    String titre = request.getParameter("titre");
	    String auteur = request.getParameter("auteur");
	    int annee = Integer.parseInt(request.getParameter("annee"));
	    bookBean.addBook(new Book(auteur, titre, annee));
	    response.sendRedirect("books");
	}

}
