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

@WebServlet("/listes")
public class ListeServlet extends HttpServlet {
	
	@EJB
	private ListeBean listeBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listes", listeBean.getAllListes());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/listes.jsp");
		dispatcher.forward(request, response);
	}

}
