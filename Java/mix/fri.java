import java.io.*;
import javax.servlet.*;
public class fri extends GenericServlet
	{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
		{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<b>AMIT<br>");
		pw.println("<b>ROHIT<br>");
		pw.println("<b>SATISH<br>");
		pw.println("<b>VIKRAM<br>");
		pw.println("<b>APPA<br>");
		pw.println("<b>SACHIN<br>");
		pw.println("<b>MAHENDRA<br>");
		pw.close();
		}
	}
