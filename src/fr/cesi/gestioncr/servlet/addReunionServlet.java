package fr.cesi.gestioncr.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
 * Servlet implementation class addReunionServlet
 */
@WebServlet("/addReunion")
public class addReunionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String AJOUT = "/auth/addReunion.jsp";
	private static final String VUE = "/listReunion";
	
	
	private String username = "";
	private String password = "";
	
	
	private EntityManagerFactory emf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addReunionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaCollabDao myDao = new JpaCollabDao(emf);
		Collection<Collab> collabs = myDao.getAllCollab();
		request.setAttribute("collab", collabs);
		this.getServletContext().getRequestDispatcher( AJOUT ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaReunionDao jpaReu = new JpaReunionDao(emf);
		JpaCollabDao jpaCol = new JpaCollabDao(emf);
		JpaReunion_CollabDao jpaReuCol = new JpaReunion_CollabDao(emf);
		
		try {
			Date dateReu = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
			String lieu = request.getParameter("lieu");
			String objectif = request.getParameter("objectif");
			String[] list_collab = request.getParameterValues("collab");
			Reunion reunion = new Reunion();
			Reunion_Collab reunion_collab = new Reunion_Collab();
			
			reunion.setDate(dateReu);
			reunion.setLieu(lieu);
			reunion.setObjectif(objectif);
			jpaReu.addReunion(reunion);

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.host","smtp.gmail.com");
			props.put("mail.smtp.port","587");
			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});


			
			Long id_reunion = reunion.getId_reunion();
			for (String id_collab : list_collab) {
				Collab colab = jpaCol.findCollabById(Long.parseLong(id_collab));
				reunion_collab.setCollab(jpaCol.findCollabById(Long.parseLong(id_collab)));
				reunion_collab.setReunion(jpaReu.findReunionById(id_reunion));
				jpaReuCol.addReunion_Collab(reunion_collab);
				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(username));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(colab.getEmail()));
					message.setSubject("Test email");
					message.setText("Bonjour, ce message est un test ...");

					Transport.send(message);
					System.out.println("Message_envoye");
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				} 
			}
			
			
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
