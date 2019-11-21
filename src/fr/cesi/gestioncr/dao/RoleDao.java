package fr.cesi.gestioncr.dao;

import java.util.List;
import fr.cesi.gestioncr.entity.Role;

public interface RoleDao {
	
		public Role addRole(Role role);
		
		public Role findRoleById(Long id);
		
		public List<Role> getAllRole();
		
		public void updateRole(Role role);
		
		public void removeRole(Role role);
		
}
