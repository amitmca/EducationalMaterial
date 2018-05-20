<%@ page language="java" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.sql.*" %>
<%

    Connection conn = null;
    String url = "jdbc:odbc:mysql";
    //String dbName = "user_register";
    String driver = "sun.jdbc.odbc.Driver";
    String userName = "root"; 
    String password = " ";

    int sumcount=0; 
	Statement st;
  String username= "";
	if(request.getParameter("username")!=null && 
           request.getParameter("username")!="")
	{
	  username = request.getParameter("username").toString();
	 
	}

%>

<HTML>
<head>
<script>
function validate(){

	if(document.frm.username.value=="")
	{
		alert("Please enter username");
		document.frm.username.focus();
		return false;
	}
}
function User(val){

 var url = "addform.jsp";
 var userid = document.getElementById("userid").value;
        if(val=="Insert")
		{
          window.location.href="addform.jsp";
		}
		else if(val=="Update")
		{
			
            if(userid!="-1")
			{
             url = url + "?id="+userid;
			 window.location.href=url;
			}
			else
			{
		          alert("Please select username");
			}
		}
		else if(val=="Delete")
	   {
			 if(userid!="-1")
			{
             url = "delete.jsp?id="+userid;
			  window.location.href=url;
			}
			else
			{
		          alert("Please select username");
			}
	   }
}
</script>

</head>
<BODY>
<FORM NAME="frm" METHOD="post" ACTION="" 
 onsubmit="return validate();">
 </BR> </BR>

<H3> <P ALIGN="CENTER"> <FONT SIZE=6> Search User
                        </FONT> </P> </H3>  </BR>

<TABLE CELLSPACING=5 CELLPADDING=5 border=0 
BGCOLOR="LIGHTBLUE" COLSPAN=2 ROWSPAN=2 
ALIGN="CENTER" width="400px">

<TR>
<TD> <FONT SIZE=4>Search</TD>
<TD><INPUT TYPE="TEXT" NAME="username" 
     id="username" value="<%=username%>">

</FONT> </TD><td><INPUT TYPE="submit" NAME="search" 
                  VALUE="Search"></td>
</TR>
<TR >
<td><FONT SIZE=4>Username</font></td>
<TD colspan=2 align="left"> <FONT SIZE=5 >
<select name="userid" id="userid"> 
 <option value="-1">Select</option>
<%
if(request.getParameter("username")!=null && 
   request.getParameter("username")!="")
	{
try {
      Class.forName(driver).newInstance();
	 
      conn = DriverManager.getConnection
             (url,userName,password);
	    String query = "select * from register where  username LIKE '"+username+"%'";
	    
       st = conn.createStatement();
	   ResultSet  rs = st.executeQuery(query);
	   while(rs.next())
		{
		   
%>
	<option value="<%=rs.getInt(1)%>">
        <%=rs.getString(2)%></option>
<%
		}

       
		
	}
	catch (Exception e) {
      e.printStackTrace();
    }
	}
%>
</select>
</TD>
</FONT> </TR>
<TR> <FONT SIZE=6>
<TD colspan=3 align="center"> 
<INPUT TYPE="button" NAME="Insert" VALUE="Insert" 
onclick="User(this.value);">
<INPUT TYPE="button" NAME="Delete" VALUE="Delete" 
onclick="User(this.value);">
<INPUT TYPE="button" NAME="Update" VALUE="Update" 
onclick="User(this.value);">
 </TD>
</TR> </FONT>

</FORM>
</BODY>
</HTML>
