import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class amit extends HttpServlet
  {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
       {
	try
	{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><head><title>Hello World!</title></head><body>");
        out.println("<h1>Amit </h1>");
        out.println("</body></html>");
	}
	/*catch(ServletException e1)
	{
	}*/
	catch(IOException e)
	{

	}
	
    }
}
