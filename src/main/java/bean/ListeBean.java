package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Liste;

@Stateless
@Local
public class ListeBean {
	
	@PersistenceContext(unitName = "liste-pu")
	private EntityManager entityManager;
	
	public List<Liste> getAllListes() {
		ResultSet rs = SQLRequestHandler.executeQuery("select * from Liste");
		return buildListFromResultSet(rs);
	}
	
	public Liste getListeById(long id) {
		ResultSet rs = SQLRequestHandler.executeQuery("select * from Liste where id = " + id);
		List<Liste> list = buildListFromResultSet(rs);
		if(list.isEmpty())
			return null;
		return list.get(0);
	}

	public void addListe(Liste liste) {
		SQLRequestHandler.executeQuery("insert into Liste(intitule) values ('"+ liste.getIntitule() +"')");
	}
	
	public List<Liste> buildListFromResultSet(ResultSet rs) {
		List<Liste> listes = new ArrayList<Liste>();		
		Liste liste;
		try {
			while(rs.next()) {
				liste = new Liste();
				liste.setId(rs.getLong(1));
				liste.setIntitule(rs.getString(2));
				listes.add(liste);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		};
		return listes;
	}

}
