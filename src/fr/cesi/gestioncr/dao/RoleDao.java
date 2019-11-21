package fr.cesi.gestioncr.dao;

import java.util.List;
import fr.cesi.gestioncr.entity.Role;

public interface RoleDao {

	//public boolean existRole(String name, String password)
	
		public Role addRole(Role role);
		
		public Role findRole(Long id);
		
		public List<Role> getAllRole();
		
		public void updateRole(Role role);
		
		public void removeRole(Role role);
		
}
