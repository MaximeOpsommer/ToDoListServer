package specs.item;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import entity.Item;
import servlet.AjouterUnItemServlet;

@RunWith(ConcordionRunner.class)
public class ItemsFixture {

public Result getTestBuildItem(int idListe, String intitule, boolean realisee) {
		
		Result result = new Result();
		Item item = AjouterUnItemServlet.buildItem(idListe, intitule, realisee);
		result.idListe = item.getIdListe();
		result.intitule = item.getIntitule();
		result.realisee = item.isRealisee();
		return result;
		
	}
	
	class Result {
		public int idListe;
		public String intitule;
		public boolean realisee;
	}
	
}
