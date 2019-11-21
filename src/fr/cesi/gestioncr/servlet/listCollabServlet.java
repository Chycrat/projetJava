package fr.cesi.gestioncr.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.gestioncr.dao.jpa.JpaCollabDao;
import fr.cesi.gestioncr.entity.Collab;

/**
 * Servlet implementation class listCollabServlet
 */
@WebServlet("/listCollabServlet")
public class listCollabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String AJOUT = "/addCollab.jsp";
	private static final String VUE = "/listCollab.jsp";
	private EntityManagerFactory emf;
       
    public listCollabServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaCollabDao myDao = new JpaCollabDao(emf);
		Collection<Collab> collabs = myDao.getAllCollab();
		request.setAttribute("collab", collabs);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
