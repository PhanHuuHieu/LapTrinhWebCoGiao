package LTW.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LTW.model.GuessBookEntry;

@WebServlet(urlPatterns="/GuessBook", loadOnStartup=1)
public class GuessBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GuessBook() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<GuessBookEntry> entries=new ArrayList<GuessBookEntry>();
		entries.add(new GuessBookEntry(1,"Jonh","hello"));
		entries.add(new GuessBookEntry(2,"Joe","nice"));
		getServletContext().setAttribute("entries", entries);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuessBookEntry> entries=(List<GuessBookEntry>)getServletContext().getAttribute("entries");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>GuestBook</title></head><body>");
		out.println("<h2>GuestBook</h2>");
		
		out.println("<table border='1'>");
		out.println("<tr><th>Name</th><th>Message</th>");
		for(int i=0;i<entries.size();i++)
		{
			GuessBookEntry entry=entries.get(i);
			out.print("<tr><td>"+entry.getName()+"says: </td><td>" +entry.getMassage()+"</td><td>"
					+ "<a href='EditEntry?index="+i+"'>Edit</a></td><td><a href='DeleteEntry?index="+i+"'>Delete</a></td>'</tr>");
		}
			out.println("</table>");
		out.println("<p><a href='AddComment'>Leave a comment</a></p>");
		out.println("<p><a href='AddCommentWithCookie'>Leave a comment With cookie</a></p>");
		out.println("<p><a href='AddCommentWithSession'>Leave a comment With ss</a></p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
