package LTW.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LTW.model.GuessBookEntry;


@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditEntry() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuessBookEntry> entries=(List<GuessBookEntry>)getServletContext().getAttribute("entries");
		int index=Integer.parseInt(request.getParameter("index"));
		GuessBookEntry entry=entries.get(index);
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Edit comment</title></head><body>");
		out.println("<form action='EditEntry' method='POST'>");
		out.println("<input type='hidden' name='index' value='"+index+"'"); 
		out.println("Name: <input type='text' name='name' value='"+entry.getName()+"'/><br>");
		out.println("Name: <textarea name='message' rows='5'cols='60'>"+entry.getMassage()+"</textarea><br>");
		out.println("<input type='submit' name='add' value='add'>");
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GuessBookEntry> entries=(List<GuessBookEntry>)getServletContext().getAttribute("entries");
		String name=request.getParameter("name");
		String message=request.getParameter("message");
		int index=Integer.parseInt(request.getParameter("index"));
		entries.get(index).setName(name);
		entries.get(index).setMassage(message);
		response.sendRedirect("GuessBook");
	}

}
