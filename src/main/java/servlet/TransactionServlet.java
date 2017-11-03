package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Compte;
import Model.Transaction;
import dao.CompteManager;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction/*")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String path = request.getRequestURI();
		String idString = path.substring(path.lastIndexOf("/") + 1);
		int numCompte =  Integer.parseInt(idString);
		
		Compte compte = CompteManager.loadCompteByNumero(numCompte);
		
		request.setAttribute("compte", compte);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/transaction.jsp");
		dispatcher.forward(request, response);
	}

}
