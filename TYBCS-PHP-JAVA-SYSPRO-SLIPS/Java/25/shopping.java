import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class shopping extends HttpServlet
{

	
		public void doGet(HttpServletRequest req,HttpServletResponse res)
		{
			try
			{
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			
			String n=req.getParameter("t1");
			pw.println("<h1>WELCOME"+n+"</h1>");





			}		
			catch (Exception e)
			{
			e.printStackTrace();
			}

			

			}
	



}
