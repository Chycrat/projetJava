package fr.cesi.gestioncr.dao;

import java.util.List;
import fr.cesi.gestioncr.entity.Tache;
import fr.cesi.gestioncr.entity.Tache_Collab;


public interface TacheDao {
	
			public Tache addTache(Tache tache);
			
			public Tache findTacheById(Long id);
			
			public List<Tache> getAllTache();
			
			public void updateTache(Tache tache);
			
			public void removeTache(Tache tache);
			
			List<Tache> getTacheFromReunion(Long id_reunion);
	
}
