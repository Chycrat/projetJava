package fr.cesi.gestioncr.servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.cesi.gestioncr.dao.jpa.JpaRoleDao;
import fr.cesi.gestioncr.entity.Role;



@WebServlet("/addRole")
public class addRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String AJOUT = "/auth/addRole.jsp";
	private static final String VUE = "/listRole";
	private EntityManagerFactory emf;  

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( AJOUT ).forward( request, response );
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaRoleDao jpaRole = new JpaRoleDao(emf);
		String Nom_role = request.getParameter("Nom_role");
		Role role = new Role();
		role.setNom_role(Nom_role);
		jpaRole.addRole(role);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
