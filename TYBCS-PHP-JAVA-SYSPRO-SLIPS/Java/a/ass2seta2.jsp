<%@ page language="java"
   import="java.io.File"%>
<%
String ext=request.getParameter("ext");
out.print("Ext::"+ext);

String dirname="/root";
File f1=new File(dirname);
	
if(f1.isDirectory())
	{
		String s[]=f1.list();
		for(int i=0;i<s.length;i++)
		{
			File f=new File(dirname+"/"+s[i]);
			
			if(s[i].endsWith(ext))
		
			{
				out.print("<br>");
				//out.print(s[i]);
				out.print("<a href >"+s[i]+"</a>");
								out.print("<br>");
			}
		}
	}

%>
