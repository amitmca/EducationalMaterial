<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<HTML>
<HEAD>
    <TITLE>Navigating in a Database Table </TITLE>
</HEAD>
<BODY bgcolor="#ffffcc">
<font size="+3" color="green"><br>Welcome in roseindia !</font>
<%          int current = 0;

            Connection connection = null;

            String connectionURL = "jdbc:odbc:student";


            ResultSet rs = null;
%>
<FORM NAME="form1" ACTION="http://localhost:8080/examples/jsp/amit/jdbc/navi.jsp" METHOD="get">
<%
            if (request.getParameter("hidden") != null) {
                current = Integer.parseInt(request.getParameter("hidden"));
            }

            Statement statement = null;
            try {
                
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                
                connection = DriverManager.getConnection(connectionURL, "root", " ");

	//out.println("Connection Created");

                statement = connection.createStatement();

                rs = statement.executeQuery("select * from stu_info");
                for (int i = 0; i < current; i++) {
                    rs.next();
                }
                if (!rs.next()) {
%>
<FONT size="+2" color="red"></b>
<%
        out.println("Sorry ! found some problems with database.");
    } else {
%>
<TABLE style="background-color: #ECE5B6;" WIDTH="30%" >
    
    <TR><TH width="50%">ID</TH><TD width="50%"> <%= rs.getInt(1)%> 
    </TD></tr>
    <TR><TH>Name</TH><TD> <%= rs.getString(2)%> </TD></tr>
    <TR><TH>City</TH><TD> <%= rs.getString(3)%> </TD></tr>
    <TR><TH>Phone</TH><TD> <%= rs.getInt(4)%> </TD></tr>    
    </TR>
</TABLE>
<BR>
<INPUT TYPE="hidden" NAME="hidden" VALUE="<%=current + 1%>">
<INPUT TYPE="submit" VALUE="next record">
</FORM>
<%
    }
} 
catch (Exception ex) {
%>
<FONT size="+3" color="red"></b>
    <%
                out.println("Unable to connect to database.");
            } finally {
                // close all the connections.
                rs.close();
                statement.close();
                connection.close();
            }
    %>
</FONT>
</FORM>
</body> 
</html>
