package fr.cesi.gestioncr.dao;

import java.util.List;
import fr.cesi.gestioncr.entity.Collab;

public interface CollabDao {
	
	public boolean Collab_existe(String name, String password);
	
	public Collab addCollab(Collab collab);
	
	public Collab findCollabById(Long id);
	
	public List<Collab> getAllCollab();
	
	public void updateCollab(Collab collab);
	
	public void removeCollab(Collab collab);
	
}
