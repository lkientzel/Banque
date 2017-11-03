package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.*;


import Model.Client;
import dao.ClientManager;
import Model.Compte;
import Model.TestJPA;
import dao.CompteManager;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/Compte")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(CompteServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		Client client = ClientManager.loadClientByID(2);
//		request.setAttribute("client", client);
//		
//		
//		
//		ArrayList<Compte> comptes = CompteManager.loadCompteByID(2);
//		PersistenceUtil util = Persistence.getPersistenceUtil();
//		for(Compte cmpt : comptes) {
//			logger.info(cmpt.toString());
//			logger.debug("comptes chargés ? " + util.isLoaded(cmpt));
//		}
//		request.setAttribute("compte", comptes);
//		
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listCompte.jsp");
//		dispatcher.forward(request, response);
		
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("client");
		request.setAttribute("client", client);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listCompte.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String login = request.getParameter("login");
//		String password = request.getParameter("password");
//		
//		Client client = ClientManager.loadClientByLogin(login, password);
//		request.setAttribute("client", client);
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("client", client);
//		
//		ArrayList<Compte> comptes = CompteManager.loadCompteByID(client.getIdClient());
//		PersistenceUtil util = Persistence.getPersistenceUtil();
//		for(Compte cmpt : comptes) {
//			logger.info(cmpt.toString());
//			logger.debug("comptes chargés ? " + util.isLoaded(cmpt));
//		}
//		request.setAttribute("compte", comptes);
		
	}

}
