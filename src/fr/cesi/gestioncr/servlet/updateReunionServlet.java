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
import fr.cesi.gestioncr.dao.jpa.JpaReunionDao;
import fr.cesi.gestioncr.dao.jpa.JpaReunion_CollabDao;
import fr.cesi.gestioncr.entity.Collab;
import fr.cesi.gestioncr.entity.Reunion;
import fr.cesi.gestioncr.entity.Reunion_Collab;

/**
 * Servlet implementation class updateReunionServlet
 */
@WebServlet(urlPatterns = "/updateReunion")
public class updateReunionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MODIF = "/auth/updateReunion.jsp";
	private static final String VUE = "/listReunion";
	private EntityManagerFactory emf;
       
    public updateReunionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaReunionDao myDao = new JpaReunionDao(emf);
		JpaReunion_CollabDao reuColabDao = new JpaReunion_CollabDao(emf);
		Reunion reunion = myDao.findReunionById(Long.parseLong(request.getParameter("id")));
		request.setAttribute("reunion", reunion);
		this.getServletContext().getRequestDispatcher(MODIF).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaReunionDao myDao = new JpaReunionDao(emf);
		String CompteRendu = request.getParameter("cr");
		Long id_Reu = Long.parseLong(request.getParameter("id_reunion"));
		Reunion reunion = myDao.findReunionById(id_Reu);
		
		reunion.setCompte_rendu(CompteRendu);
		myDao.updateReunion(reunion);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
