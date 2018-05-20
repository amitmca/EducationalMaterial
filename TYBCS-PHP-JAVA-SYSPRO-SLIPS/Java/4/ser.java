import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ser extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		HttpSession hs=req.getSession(true);
		pw.println("<br>Session ID:"+hs.getId());
		pw.println("<br>Server name :"+req.getServerName());
		pw.println("<br>Browser"+req.getHeader("user-agent"));
		pw.println("<br>"+req.getServerPort());
		pw.println("<br>IP address:"+req.getRemoteAddr());
		pw.close();
	}
}
		
