package fr.cesi.gestioncr.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.gestioncr.dao.jpa.JpaTacheDao;
import fr.cesi.gestioncr.entity.Tache;

@WebServlet(urlPatterns = "/listTache")
public class listTacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/auth/listeTache.jsp";
	private EntityManagerFactory emf;
       
    public listTacheServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaTacheDao myDao = new JpaTacheDao(emf);
		Collection<Tache> taches = myDao.getAllTache();
		request.setAttribute("tache", taches);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
