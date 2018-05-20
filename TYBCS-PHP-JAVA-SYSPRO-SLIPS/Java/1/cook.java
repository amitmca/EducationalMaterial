import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
	
public class cook extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
	try
	{
		String data=req.getParameter("vippy");
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();	
		
		Cookie []cookies=req.getCookies();
		if(cookies !=null)
		{
			pw.println("Existing Cookies :");
			for(int i=0;i<cookies.length;i++)
			{
				String name=cookies[i].getName();
				String value=cookies[i].getValue();
				pw.println("Name = "+name+" Value= "+value+"<br>");
			}
			for(int i=0;i<cookies.length;i++)
			{
				if(cookies[i].getValue().equals(data))
				{
				pw.println("Cookis Exists for "+data);
				}
			}
		}
		Cookie c=new Cookie("vippy",data);
		c.setMaxAge(6000);
		res.addCookie(c);
		pw.println("cookie added for Hobby  "+data);
	}
	catch(Exception e){}
    }
}
		





/*
<html>
	<body>
		<form action=cook method=post>
	        <input type=radio name=vippy value=Painting>Painting<br>
	
	        <input type=radio name=vippy value=Drawing>Drawing<br>
	
	        <input type=radio name=vippy value=Singing>Singing<br>
	
	        <input type=radio name=vippy value=Swimming>Swimming<br>
		<br><br>
		
		<input type=submit value=Next>
		</form>
	</body>
</html>
*/

			
