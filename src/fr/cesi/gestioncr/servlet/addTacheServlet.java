package fr.cesi.gestioncr.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.gestioncr.dao.jpa.JpaReunionDao;
import fr.cesi.gestioncr.dao.jpa.JpaTacheDao;
import fr.cesi.gestioncr.entity.Reunion;
import fr.cesi.gestioncr.entity.Tache;

/**
 * Servlet implementation class addTacheServlet
 */
@WebServlet("/addTacheServlet")
public class addTacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String AJOUT = "/auth/addTache.jsp";
	private static final String VUE = "/listCollab";
	private EntityManagerFactory emf;
       
    public addTacheServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaReunionDao myDao = new JpaReunionDao(emf);
		Collection<Reunion> reunions = myDao.getAllReunion();
		request.setAttribute("reunion", reunions);
		request.getRequestDispatcher(AJOUT).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaReunionDao jpaReu = new JpaReunionDao(emf);
		JpaTacheDao jpaTac = new JpaTacheDao(emf);
		try {
		
		String nom_tache = request.getParameter("nom_tache");
		String description = request.getParameter("description");
			Date deadline = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date_reu"));

		Long id_reu = Long.parseLong(request.getParameter("id_reunion"));
		
		Tache myTach = new Tache();
		
		myTach.setNom_tache(nom_tache);
		myTach.setDescription(description);
		myTach.setDeadline(deadline);
		myTach.setReunion(jpaReu.findReunionById(id_reu));
		jpaTac.addTache(myTach);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
