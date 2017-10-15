package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ListeBean;
import entity.Liste;

@SuppressWarnings("serial")
@WebServlet("/createListe")
public class CreateListeServlet extends HttpServlet {

	@EJB
	private ListeBean listeBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("books", listeBean.getAllListes());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/createListe.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");

	    String intitule = request.getParameter("intitule");
	    Liste liste = buildListe(intitule);
	    
	    listeBean.addListe(liste);
	    response.sendRedirect("listes");
	}
	
	public static Liste buildListe(String intitule) {
		Liste liste = new Liste();
	    liste.setIntitule(intitule);
	    return liste;
	}

}
