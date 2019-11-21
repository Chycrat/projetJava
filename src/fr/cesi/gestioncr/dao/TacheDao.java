package fr.cesi.gestioncr.dao;

import java.util.List;
import fr.cesi.gestioncr.entity.Tache;


public interface TacheDao {

	//public boolean existRole(String name, String password)
	
			public Tache addTache(Tache tache);
			
			public Tache findTache(Long id);
			
			public List<Tache> getAllTache();
			
			public void updateTache(Tache tache);
			
			public void removeTache(Tache tache);
	
}
