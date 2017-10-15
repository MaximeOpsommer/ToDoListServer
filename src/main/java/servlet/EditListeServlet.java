package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ItemBean;
import bean.ListeBean;
import entity.Liste;

@WebServlet("/editListe")
public class EditListeServlet extends HttpServlet {

	@EJB
	private ListeBean listeBean;
	
	@EJB
	private ItemBean itemBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long idListe = Long.parseLong(request.getParameter("idListe"));
		Liste liste = listeBean.getListeById(idListe);
		
		if(liste != null) {
			request.setAttribute("intitule", liste.getIntitule());
		}
		
		request.setAttribute("idListe", new Long(idListe));
		request.setAttribute("items", itemBean.getItemsByListeId((int) idListe));
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/editListe.jsp");
		dispatcher.forward(request, response);
	}
	
	

}
