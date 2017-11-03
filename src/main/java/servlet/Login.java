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

import Model.Client;
import Model.Compte;
import dao.ClientManager;
import dao.CompteManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Client client = ClientManager.loadClientByLogin(login, password);
		request.setAttribute("client", client);
		
		HttpSession session = request.getSession();
		session.setAttribute("client", client);
		
		ArrayList<Compte> comptes = CompteManager.loadCompteByID(client.getIdClient());
		request.setAttribute("compte", comptes);
		
		if(client != null) {
			response.sendRedirect(request.getContextPath() + "/CompteServlet");
		}
		
	}

}
