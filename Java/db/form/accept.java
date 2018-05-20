import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class accept extends HttpServlet
	{
	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
		{

		PrintWriter pw=resp.getWriter();

		String txtusr=req.getParameter("txtusr");

		String txtpass=req.getParameter("txtpass");

		if(txtusr.equals("amitp1"))
			{
			pw.println("<b>Welcome"+txtusr);			
			}

		resp.setContentType("text/html");

		pw.println("<b>User Id:");

		pw.println(txtusr);

		pw.println("<br>");

		pw.println("<b>Password:"+txtpass);

		pw.close();
		}
	}
