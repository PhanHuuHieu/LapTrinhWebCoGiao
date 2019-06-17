package LTW.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LTW.model.GuessBookEntry;

@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Members() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=(String)request.getSession().getAttribute("user");
		if(user!=null) {
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Member</title></head><body>");
		out.println("<h2>This is only member area</h2>");
		out.println("<h2>Welcome"+user+"</h2>");
		out.println("<a href='Logout'>Logout</a>");
		out.println("</body></html>");
		
		}
		else
			response.sendRedirect("Login1");
	}

}
