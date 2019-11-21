package fr.cesi.gestioncr.servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.gestioncr.dao.jpa.JpaCollabDao;
import fr.cesi.gestioncr.entity.Collab;

/**
 * Servlet implementation class removeCollab
 */
@WebServlet("/removeCollab")
public class removeCollabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/listCollab";
	private EntityManagerFactory emf;	
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		JpaCollabDao myDao = new JpaCollabDao(emf);
		Collab collab = myDao.findCollabById(id);
		myDao.removeCollab(collab);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
