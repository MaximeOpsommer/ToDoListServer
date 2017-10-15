package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ItemBean;
import entity.Item;
import entity.Liste;

@WebServlet("/ajouterUnItem")
public class AjouterUnItemServlet extends HttpServlet {
	
	@EJB
	private ItemBean itemBean;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");

	    int idListe = Integer.parseInt(request.getParameter("idListe"));
	    String intitule = request.getParameter("intituleItem");
	    
	    Item item = buildItem(idListe, intitule, false);
	    itemBean.addItem(item);
	    response.sendRedirect("editListe?idListe=" + idListe);
	}
	
	public static Item buildItem(int idListe, String intitule, boolean realisee) {
		Item item = new Item();
	    item.setIdListe(idListe);
	    item.setIntitule(intitule);
	    item.setRealisee(realisee);
	    return item;
	}
	
}
