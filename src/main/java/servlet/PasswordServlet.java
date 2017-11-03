package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Client;
import dao.ClientManager;

/**
 * Servlet implementation class PasswordServlet
 */
@WebServlet("/Password")
public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/password.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String NPassword = request.getParameter("NPassword");
		String CPassword = request.getParameter("CPassword");
		if(NPassword.equals(CPassword)) {
			HttpSession session = request.getSession(false);
			Client client = (Client) session.getAttribute("client");
			ClientManager.changePassword(CPassword, client);
		}
		else {
			String messageErreur = "Confirmation non valide";
			request.setAttribute("erreur", messageErreur);
			this.getServletContext().getRequestDispatcher("/password.jsp")
			.forward(request, response);
		}
		
	}

}
