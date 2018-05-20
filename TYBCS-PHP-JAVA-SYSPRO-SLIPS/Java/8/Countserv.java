import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

public class Countserv extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
	try
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		Cookie c[]=req.getCookies();
		int flag=0;
		if(c!=null)
		{
			for(int i=0;i<c.length;i++)
			{
			if(c[i].getName().equals("count"))
			{
			flag=1;
			int x=Integer.parseInt(c[i].getValue());
			x++;
			c[i].setValue(x+"");
			c[i].setMaxAge(10);
			res.addCookie(c[i]);
			pw.println("<h1>Welcome "+x+"time");
			}
			}
		}
		if(flag==0)
		{
			Cookie ck=new Cookie("count","1");
			ck.setMaxAge(10);
			res.addCookie(ck);
			pw.println("<h1>Welcome first time");
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}
			
			
