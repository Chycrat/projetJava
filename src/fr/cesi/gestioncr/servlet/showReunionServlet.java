package fr.cesi.gestioncr.servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.gestioncr.dao.jpa.JpaReunionDao;

/**
 * Servlet implementation class showReunionServlet
 */
@WebServlet("/showReunionServlet")
public class showReunionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/auth/showReunion.jsp";
	private EntityManagerFactory emf;
       
    public showReunionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id_reu = Long.parseLong(request.getParameter("id"));
		JpaReunionDao myDao = new JpaReunionDao(emf);
		request.setAttribute("reunion", myDao.findReunionById(id_reu));
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
