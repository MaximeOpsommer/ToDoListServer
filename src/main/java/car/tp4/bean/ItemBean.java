package car.tp4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public List<Item> getAllItems() {
		ResultSet rs = SQLRequestHandler.executeQuery("select * from Item");
		return buildListFromResultSet(rs);
	}
	
	public List<Item> getItemsByListeId(int listeId) {
		ResultSet rs = SQLRequestHandler.executeQuery("select * from Item where id_liste = " + listeId);
		return buildListFromResultSet(rs);
	}
	
	public void addItem(Item item) {
		SQLRequestHandler.executeQuery("insert into Item(id_liste, intitule, realisee) values ('"+ item.getIdListe() +"', '" + item.getIntitule() + "', '" + item.isRealisee() + "')");
	}
	
	public List<Item> buildListFromResultSet(ResultSet rs) {
		List<Item> items = new ArrayList<Item>();
		Item item;
		try {
			while(rs.next()) {
				item = new Item();
				item.setId(rs.getLong(1));
				item.setIdListe(rs.getInt(2));
				item.setIntitule(rs.getString(3));
				item.setRealisee(rs.getBoolean(4));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		};
		return items;
	}

}
