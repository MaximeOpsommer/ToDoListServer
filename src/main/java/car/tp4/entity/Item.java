package car.tp4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String intitule;
	
	private int idListe;
	
	private boolean realisee;
	
	public Item() {
		
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	public int getIdListe() {
		return idListe;
	}

	public void setIdListe(int idListe) {
		this.idListe = idListe;
	}

	public boolean isRealisee() {
		return realisee;
	}

	public void setRealisee(boolean realisee) {
		this.realisee = realisee;
	}

	

}
