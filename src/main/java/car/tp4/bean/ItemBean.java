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

import car.tp4.entity.Item;
import car.tp4.entity.Liste;

@Stateless
@Local
public class ItemBean {
	
	@PersistenceContext(unitName = "item-pu")
	private EntityManager entityManager;
	
	private List<Item> items = new ArrayList<Item>();
	
	public List<Item> getAllItems() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		List<Item> items = new ArrayList<Item>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite::resource:todolist.db");
			st = conn.createStatement();
			rs = st.executeQuery("select * from Item");
			
			Item item;
			
			while(rs.next()) {
				item = new Item();
				item.setId(rs.getLong(1));
				item.setIntitule(rs.getString(2));
				items.add(item);
			}
			System.out.println("\n\n\n\n\nNOMBRE D'ITEMS : " + items.size() + "\n\n\n\n\n");
			
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
		
		return items;
	}

}
