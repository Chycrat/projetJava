package fr.cesi.gestioncr.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.cesi.gestioncr.dao.jpa.JpaRoleDao;
import fr.cesi.gestioncr.entity.Role;


@WebServlet("/listRole")
public class listRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/auth/listeRole.jsp";
	private EntityManagerFactory emf;   

	
    public listRoleServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaRoleDao myDao = new JpaRoleDao(emf);
		Collection<Role> roles = myDao.getAllRole();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher(VUE).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
