package car.tp4.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import car.tp4.entity.Liste;

@Stateless
@Local
public class ListeBean {
	
	@PersistenceContext(unitName = "liste-pu")
	private EntityManager entityManager;
	
	public List<Liste> getAllListes() {
		
		List<Liste> listes = new ArrayList<Liste>();
		
		Liste liste;
		
		ResultSet rs = SQLRequestHandler.executeQuery("select * from Liste");
		
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

	public void addListe(Liste liste) {
		SQLRequestHandler.executeQuery("insert into Liste(intitule) values ('"+ liste.getIntitule() +"')");
	}

}
