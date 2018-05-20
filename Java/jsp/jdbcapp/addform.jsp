<%@ page language="java" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.sql.*" %>
<%
String username=""; 
String user_pass="";
String firstname="";
String lastname=""; 
String email="";
String state="";
String city=""; 
String country=""; 

Connection conn = null;
String url = "jdbc:odbc:mysql";
//String dbName = "user_register";
String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
String userName = "root"; 
String password = " ";

int sumcount=0; 
Statement st;
String id="";

String bttn_value = "Add";

if(request.getParameter("id")!=null && request.getParameter("id")!="")
{
bttn_value = "Update";
id = request.getParameter("id");

try {
Class.forName(driver).newInstance();

conn = DriverManager.getConnection(url,userName,password);
String query = "select * from register where id='"+id+"'";

st = conn.createStatement();
ResultSet rs = st.executeQuery(query);
while(rs.next())
{

username=rs.getString(2); 
user_pass=rs.getString(3);
firstname=rs.getString(4);
lastname=rs.getString(5); 
email=rs.getString(6);
state=rs.getString(7);
city=rs.getString(8); 
country=rs.getString(9); 
}
}
catch (Exception e) {
e.printStackTrace();
}
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

if(document.frm.user_pass.value=="")
{
alert("Please enter password");
document.frm.user_pass.focus();
return false;
}

if(document.frm.firstname.value=="")
{
alert("Please enter first name");
document.frm.firstname.focus();
return false;
}

if(document.frm.lastname.value=="")
{
alert("Please enter last name");
document.frm.lastname.focus();
return false;
}

if(document.frm.email.value=="")
{
alert("Please enter email");
document.frm.email.focus();
return false;
}
if(document.frm.state.value=="")
{
alert("Please enter state");
document.frm.state.focus();
return false;
}

if(document.frm.city.value=="")
{
alert("Please enter city");
document.frm.city.focus();
return false;
}

if(document.frm.country.value=="")
{
alert("Please enter country");
document.frm.country.focus();
return false;
}
return true;
}
</script>
</head>
<BODY >
<FORM NAME="frm" METHOD="post" action=
"userUpdate.jsp" onsubmit="return validate();">
</BR> 
<INPUT TYPE="hidden" NAME="id" value="<%=id%>">
<H3> <P ALIGN="CENTER"> <FONT SIZE=6> 
EMPLOYEE DETAILS </FONT> </P> </H3> 

<BR>
<TABLE CELLSPACING=5 CELLPADDING=5 border=0 BGCOLOR="LIGHTBLUE" COLSPAN=2 
ROWSPAN=2 ALIGN="CENTER" width="400px">

<TR>
<TD> <FONT SIZE=3><b>Username</b></TD>
<TD><INPUT TYPE="TEXT" NAME="username" id="username" value="<%=username%>">

</FONT> </TD>
</TR>
<TR>
<TD> <FONT SIZE=3><b>Password</b></TD>
<TD><INPUT TYPE="password" NAME="user_pass" id="user_pass" value="<%=user_pass%>">

</FONT> </TD>
</TR>
<TR>
<TD> <FONT SIZE=3><b>First Name</b></TD>
<TD><INPUT TYPE="TEXT" NAME="firstname" id="firstname" value="<%=firstname%>">

</FONT> </TD>
</TR>
<TR>
<TD> <FONT SIZE=3><b>Last Name</b></TD>
<TD><INPUT TYPE="TEXT" NAME="lastname" id="lastname" value="<%=lastname%>">

</FONT> </TD>
</TR>
<TR>
<TD> <FONT SIZE=3><b>Email</b></TD>
<TD><INPUT TYPE="TEXT" NAME="email" 
id="email" value="<%=email%>">

</FONT> </TD>
</TR>


<TR>
<TD> <FONT SIZE=3><b>State</b></TD>
<TD><INPUT TYPE="TEXT" NAME="state" 
id="state" value="<%=state%>">

</FONT> </TD>
</TR>

<TR>
<TD> <FONT SIZE=3><b>City</b></TD>
<TD><INPUT TYPE="TEXT" NAME="city" 
id="city" value="<%=city%>">

</FONT> </TD>
</TR>

<TR>
<TD> <FONT SIZE=3><b>Country</b></TD>
<TD><INPUT TYPE="TEXT" NAME="country" 
id="country" value="<%=country%>">

</FONT> </TD>
</TR>


<TR> <FONT SIZE=6>
<TD colspan=3 align="center"> <INPUT TYPE=
"Submit" NAME="submit" VALUE="<%=bttn_value%>">
</TD>
</TR> </FONT>

</FORM>
</BODY>
</HTML> 