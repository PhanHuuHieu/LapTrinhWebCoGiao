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


@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int idSeed=100;
 
    public AddComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Add comment</title></head><body>");
		out.println("<form action='AddComment' method='POST'>");
		out.println("Name: <input type='text' name='name'/><br>");
		out.println("Name: <textarea name='message' rows='5'cols='60'></textarea><br>");
		out.println("<input type='submit' name='add' value='add'>");
		out.println("</form>");
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuessBookEntry> entries=(List<GuessBookEntry>)getServletContext().getAttribute("entries");
		String name=request.getParameter("name");
		String message=request.getParameter("message");
		entries.add(new GuessBookEntry(idSeed++,name,message));
		response.sendRedirect("GuessBook");
	}
	

}
