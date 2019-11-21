package fr.cesi.gestioncr.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.gestioncr.dao.jpa.JpaReunionDao;
import fr.cesi.gestioncr.entity.Reunion;

/**
 * Servlet implementation class listReunionServlet
 */
@WebServlet(urlPatterns = "/listReunion")
public class listReunionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/auth/listeReunion.jsp";
	private EntityManagerFactory emf;

	public listReunionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaReunionDao myDao = new JpaReunionDao(emf);
		Collection<Reunion> reunions = myDao.getAllReunion();
		request.setAttribute("reunion", reunions);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
