package fr.cesi.gestioncr.dao;

import java.util.List;

import fr.cesi.gestioncr.entity.Collab;
import fr.cesi.gestioncr.entity.Reunion_Collab;

public interface Reunion_CollabDao {

	public Reunion_Collab addReunion_Collab(Reunion_Collab reunion_collab);
	
	public Reunion_Collab findReunion_CollabById(Long id);
	
	public List<Reunion_Collab> getAllReunion_Collab();

	public List<Reunion_Collab> getReunion_Collab_by_ReunionId(Long id);

	public List<Reunion_Collab> getAllReunion_Collab_by_CollabId(Long id);
	
	public void updateReunion_Collab(Reunion_Collab reunion_collab);
	
	public void removeReunion_Collab(Reunion_Collab reunion_collab);
	
	public List<Reunion_Collab> getCollabFromReunion();

	public List<Collab> getCollabFromReunion(Long id_reunion);

}
