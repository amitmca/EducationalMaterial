import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DateServlet extends HttpServlet
	{	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
		{
		HttpSession hs=request.getSession(true);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<b>");

		Date date=(Date)hs.getAttribute("date");
		if(date!=null)
			{
			pw.print("Last Access:"+date+"<br>");
			}
		date=new Date();
		hs.setAttribute("date",date);
		pw.println("Current Date:"+date);
		}
		
	}
