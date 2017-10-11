package car.tp4.bean;

import java.util.List;

import javax.ejb.Remote;

import car.tp4.entity.Liste;

@Remote
public interface ListeBeanRemote {
	
	public List<Liste> getAllListes();

}
