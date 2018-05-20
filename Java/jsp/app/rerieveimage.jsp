<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 


<% 
 Connection connection = null;

String connectionURL = "jdbc:odbc:mysql";

ResultSet rs = null;

PreparedStatement psmnt = null;

InputStream sImage;

try {

     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

     connection = DriverManager.getConnection(connectionURL, "root", "amit12");

     
    
     psmnt = connection.prepareStatement("SELECT i FROM storeimage WHERE id = ?");

    String p=request.getParameter("p");	

     psmnt.setString(1, p); 

    rs = psmnt.executeQuery();

    if(rs.next()) 
        {
         byte[] bytearray = new byte[1048576];
         int size=0;
         sImage = rs.getBinaryStream(1);
         response.reset();
         response.setContentType("image/jpeg");
        while((size=sImage.read(bytearray))!= -1 )
             {
              response.getOutputStream().write(bytearray,0,size);
             }
       }
%>
<a href="http://localhost:8080/examples/jsp/amit/app/image.html">Load Another Image</a>
<%

}
catch(Exception ex)
     {
     out.println("error :"+ex);
     }
finally
    {
     rs.close();
     psmnt.close();
    connection.close();
    }
%>