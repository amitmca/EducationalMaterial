import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class mypost extends HttpServlet
	{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{
		String color=req.getParameter("Friends");
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<b>The Selected Friend Is:");
		pw.println(color);
		pw.close();
		}
	}

