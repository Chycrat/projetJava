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

import fr.cesi.gestioncr.dao.jpa.JpaCollabDao;
import fr.cesi.gestioncr.dao.jpa.JpaReunionDao;
import fr.cesi.gestioncr.entity.Collab;
import fr.cesi.gestioncr.entity.Reunion;
import fr.cesi.gestioncr.entity.Reunion_Collab;

/**
 * Servlet implementation class addReunionServlet
 */
@WebServlet("/addReunion")
public class addReunionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String AJOUT = "/auth/addReunion.jsp";
	private static final String VUE = "/auth/listeReunion.jsp";
	private EntityManagerFactory emf;
       
    public addReunionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaCollabDao myDao = new JpaCollabDao(emf);
		Collection<Collab> collabs = myDao.getAllCollab();
		request.setAttribute("collab", collabs);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaReunionDao jpaReu = new JpaReunionDao(emf);
		JpaCollabDao jpaCol = new JpaCollabDao(emf);
		
		try {
			Date dateReu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("date"));
			String lieu = request.getParameter("lieu");
			String objectif = request.getParameter("objectif");
			Long id_collab = Long.parseLong(request.getParameter("id_collab"));
			
			Reunion reunion = new Reunion();
			Reunion_Collab reunion_c= new Reunion_Collab();
			
			Long id_reunion = reunion.getId_reunion();
			
			reunion.setDate(dateReu);
			reunion.setLieu(lieu);
			reunion.setObjectif(objectif);
			
			reunion_c.setCollab(collab);
			reunion_c.setReunion(jpaReu.findReunionById(id_reunion));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}

}
