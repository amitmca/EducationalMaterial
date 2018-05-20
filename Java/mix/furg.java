import java.io.*;
import javax.servlet.*;
public class furg extends GenericServlet 
	{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
		{
		res.setContentType("text/html");
		PrintWriter p=res.getWriter();
		p.println("<B>FERGUSSION COLLEGE ENTRANCE EXAM IS HELD ON 06-4-2007 AT 10.00 AM");
		p.println("<B>PLEASE SEE NOTICE BOARD FOR CHANGES IF ANY.....");
		p.close();
		}
	}
