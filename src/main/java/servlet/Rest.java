package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.Client;
import dao.ClientManager;

/**
 * Servlet implementation class Rest
 */
@WebServlet("/Rest/*")


public class Rest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getRequestURI();
		String pathIdClient = path.substring(path.lastIndexOf("/") + 1);
		int idClient = Integer.parseInt(pathIdClient);
		
		
		Client client = ClientManager.loadClientByID(idClient);
		request.setAttribute("client", client);
		
		//ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(client.toJSON());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		ClientManager.newClient(nom, prenom, login, password);
	}

}
