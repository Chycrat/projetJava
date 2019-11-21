package fr.cesi.gestioncr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addReunionServlet
 */
@WebServlet("/addReunion")
public class addReunionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String AJOUT = "/addReunion.jsp";
	private static final String VUE = "/listReunion.jsp";
       
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
		JpaReunionDao
	}

}
