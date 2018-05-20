import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ColorGetServlet extends HttpServlet
	{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{
		String color=req.getParameter("color");
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<b>The Selected Color Is:");
		pw.println(color);
		pw.close();
		}
	}

