package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet implementation class ServletHelper
 */

public class ServletHelper extends HttpServlet {
	
	public static final String ACCOUTS = "WebContent/listCompte.jsp";
	public static final String SERVLET_ACCOUT = "servlet/CompteServlet";
	public static final String LOGIN = "WebContent/login.jsp";
	public static final String SERVLET_LOGIN = "servlet/Login";
			
	public static String getServletURL(String servlet, HttpServletRequest request) {
		return request.getContextPath()+servlet;
	}
	
}
