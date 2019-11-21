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
import fr.cesi.gestioncr.dao.jpa.JpaReunion_CollabDao;
import fr.cesi.gestioncr.dao.jpa.JpaTache_CollabDao;
import fr.cesi.gestioncr.entity.Collab;
import fr.cesi.gestioncr.entity.Reunion_Collab;
import fr.cesi.gestioncr.entity.Tache_Collab;

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
		JpaReunion_CollabDao reColDao = new JpaReunion_CollabDao(emf);
		Collab collab = myDao.findCollabById(id);
		Collection<Reunion_Collab> listReunionColab= reColDao.getAllReunion_Collab_by_CollabId(id);
		for (Reunion_Collab reunion_Collab : listReunionColab) {
			reColDao.removeReunion_Collab(reunion_Collab);
		}
		JpaTache_CollabDao taColDao = new JpaTache_CollabDao(emf);
		Collection<Tache_Collab> listTacheColab= taColDao.getAllTache_Collab_by_CollabId(id);
		for (Tache_Collab tache_collab : listTacheColab) {
			taColDao.removeTache_Collab(tache_collab);
		}
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
