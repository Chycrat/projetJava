package fr.cesi.gestioncr.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.gestioncr.dao.jpa.JpaReunionDao;
import fr.cesi.gestioncr.entity.Reunion;

/**
 * Servlet implementation class addReunionServlet
 */
@WebServlet("/addReunion")
public class addReunionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String AJOUT = "/addReunion.jsp";
	private static final String VUE = "/listReunion.jsp";
	private EntityManagerFactory emf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addReunionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaReunionDao jpaReu = new JpaReunionDao(emf);
		
		try {
			Date dateReu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("date"));
			String lieu = request.getParameter("lieu");
			String objectif = request.getParameter("objectif");
			
			Reunion reunion = new Reunion();
			
			reunion.setDate(dateReu);
			reunion.setLieu(lieu);
			reunion.setObjectif(objectif);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
