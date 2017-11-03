package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import servlet.ServletHelper;

@WebFilter("/*")
public class ConnectionFilter implements Filter {
		
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
		throws IOException, ServletException{
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession session = req.getSession(false);
			
			String loginURI = req.getContextPath() + "/Login";
			
			boolean loggedIN = session != null && session.getAttribute("client") != null;
			boolean loginRequest = req.getRequestURI().equals(loginURI);
			if (loggedIN || loginRequest) {
				chain.doFilter(request, response);
			}
			else {
				res.sendRedirect(loginURI);
			}
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
	
	

