package fr.cesi.gestioncr.dao;

import java.util.List;

import fr.cesi.gestioncr.entity.Reunion_Collab;
import fr.cesi.gestioncr.entity.Tache_Collab;

public interface Tache_CollabDao {

	public Tache_Collab addTache_Collab(Tache_Collab tache_collab);
	
	public Tache_Collab findTache_CollabById(Long id);
	
	public List<Tache_Collab> getAllTache_Collab();
	
	public void updateTache_Collab(Tache_Collab tache_collab);
	
	public List<Tache_Collab> getTache_Collab_by_TacheId(Long id);

	public List<Tache_Collab> getAllTache_Collab_by_CollabId(Long id);

	public void removeTache_Collab(Tache_Collab tache_collab);
	
}
