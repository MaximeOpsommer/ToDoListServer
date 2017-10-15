package test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bean.ListeBean;
import bean.SQLRequestHandler;
import entity.Liste;

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
