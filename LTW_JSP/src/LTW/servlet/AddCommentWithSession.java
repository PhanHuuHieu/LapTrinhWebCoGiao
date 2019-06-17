package LTW.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LTW.model.GuessBookEntry;


@WebServlet("/AddCommentWithSession")
public class AddCommentWithSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int idSeek=100;
 
    public AddCommentWithSession() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Add comment</title></head><body>");
		out.println("<form action='AddCommentWithSession' method='POST'>");
		String name=(String)request.getSession().getAttribute("name");

		if(name!=null) {
			out.println("Name: "+name+"<br>");
		}
		else
			out.println("Name: <input type='text' name='name'/><br>");
		out.println("Message: <textarea name='message' rows='5'cols='60'></textarea><br>");
		out.println("<input type='submit' name='add' value='add'>");
		out.println("</form>");
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=(String)request.getSession().getAttribute("name");

		if(name==null) {
			 name=request.getParameter("name");
			 request.getSession().setAttribute("name", name);
		}
		String message=request.getParameter("message");
		GuessBookEntry entry=new GuessBookEntry(idSeek++,name,message);
		List<GuessBookEntry> entries=(List<GuessBookEntry>)getServletContext().getAttribute("entries");
		entries.add(entry);
		response.sendRedirect("GuessBook");
	}
	

}
