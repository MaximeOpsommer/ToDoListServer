package car.tp4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import car.tp4.bean.ListeBean;
import car.tp4.bean.SQLRequestHandler;
import car.tp4.entity.Liste;

public class ListeBeanTest {

	private ListeBean bean;
	
	@Before
	public void init() {
		this.bean = new ListeBean();
	}
	
	@Test
	public void testAddListe() {
		SQLRequestHandler handler = Mockito.mock(SQLRequestHandler.class);
		Liste liste = Mockito.mock(Liste.class);
		
		bean.addListe(liste);
		
		Mockito.verify(handler).executeQuery(Mockito.anyString());
		
	}

}
