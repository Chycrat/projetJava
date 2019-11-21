package fr.cesi.gestioncr.dao;

import java.util.List;
import fr.cesi.gestioncr.entity.Reunion;

public interface ReunionDao {

	public Reunion addReunion(Reunion reunion);
	
	public Reunion findReunion(Long id);
	
	public List<Reunion> getAllReunion();
	
	public void updateReunion(Reunion reunion);
	
	public void removeReunion(Reunion reunion);
	
}
