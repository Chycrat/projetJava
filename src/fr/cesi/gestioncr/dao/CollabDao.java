package fr.cesi.gestioncr.dao;

import java.util.List;
import fr.cesi.gestioncr.entity.Collab;

public interface CollabDao {
	
	public Collab addCollab(Collab collab);
	
	public Collab findCollab(Long id);
	
	public List<Collab> getAllCollab();
	
	public void updateProjet(Collab collab);
	
	public void removeProjet(Collab collab);
	
}
