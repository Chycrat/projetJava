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


@WebServlet("/removeRole")
public class removeRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/listRole";
	private EntityManagerFactory emf;	
	

    public removeRoleServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		JpaRoleDao myDao = new JpaRoleDao(emf);
		Role role = myDao.findRoleById(id);
		myDao.removeRole(role);
		request.getRequestDispatcher(VUE).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
