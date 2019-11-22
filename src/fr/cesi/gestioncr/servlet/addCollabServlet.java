package fr.cesi.gestioncr.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.gestioncr.dao.jpa.JpaCollabDao;
import fr.cesi.gestioncr.dao.jpa.JpaRoleDao;
import fr.cesi.gestioncr.entity.Collab;
import fr.cesi.gestioncr.entity.Role;



@WebServlet(urlPatterns = "/addCollab")
public class addCollabServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String AJOUT = "/auth/addCollab.jsp";
	private static final String VUE = "/listCollab";
	private EntityManagerFactory emf;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaRoleDao jpaRole = new JpaRoleDao(emf);
		List<Role> roles = jpaRole.getAllRole();
		request.setAttribute("role", roles);
		this.getServletContext().getRequestDispatcher(AJOUT).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaCollabDao jpaCollab = new JpaCollabDao(emf);
		JpaRoleDao jpaRole = new JpaRoleDao(emf);
	
		String nom = request.getParameter("Nom");
		String prenom = request.getParameter("Prenom");
		String login = request.getParameter("Login");
		String password = request.getParameter("Password");
		String email = request.getParameter("email");
		Long id_role = Long.parseLong(request.getParameter("id_role"));
		
		Collab collab = new Collab();
		collab.setNom(nom);
		collab.setPrenom(prenom);
		collab.setLogin(login);
		collab.setPassword(password);
		collab.setRole(jpaRole.findRoleById(id_role));
		collab.setEmail(email);
		jpaCollab.addCollab(collab);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			
	}
}
