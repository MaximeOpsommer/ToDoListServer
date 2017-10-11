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
import javax.persistence.Query;

import car.tp4.entity.Liste;

@Stateless
@Local
public class ListeBean {
	
	@PersistenceContext(unitName = "liste-pu")
	private EntityManager entityManager;
	
	private List<Liste> listes = new ArrayList<Liste>();
	
	public List<Liste> getAllListes() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		List<Liste> listes = new ArrayList<Liste>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite::resource:todolist.db");
			st = conn.createStatement();
			rs = st.executeQuery("select * from Liste");
			
			Liste liste;
			
			while(rs.next()) {
				liste = new Liste();
				liste.setId(rs.getLong(1));
				liste.setIntitule(rs.getString(2));
				liste.setItems(rs.getString(3));
				listes.add(liste);
			}
			System.out.println("\n\n\n\n\nNOMBRE DE LISTES : " + listes.size() + "\n\n\n\n\n");
			
		}catch (Exception e) {
			e.printStackTrace();
		
		} finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
	    }
		
		
		/*Query query = entityManager.createQuery("SELECT m from Liste as m");
		listes =  query.getResultList();*/
		
		
		return listes;
	}

}
