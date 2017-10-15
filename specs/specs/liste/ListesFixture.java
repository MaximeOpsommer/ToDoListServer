package specs.liste;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import servlet.CreateListeServlet;

@RunWith(ConcordionRunner.class)
public class ListesFixture {

	public Result getTestBuildListe(String intitule) {
		
		Result result = new Result();
		result.intitule = CreateListeServlet.buildListe(intitule).getIntitule();
		return result;
		
	}
	
	class Result {
		public String intitule;
	}
	
}
