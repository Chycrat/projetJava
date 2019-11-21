package fr.cesi.gestioncr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cesi.gestioncr.dao.jpa.JpaCollabDao;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/jsp/login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("name");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		JpaCollabDao jpa = new JpaCollabDao(null);
		
		boolean existe = jpa.Collab_existe(user, password);
		
		session.setAttribute("name", user);
		if(existe == true) {
			response.sendRedirect(request.getContextPath() + "/accueil"); 
		}
		else {
			request.setAttribute("error", true);
			doGet(request, response);
		}
		
		
	}

}
