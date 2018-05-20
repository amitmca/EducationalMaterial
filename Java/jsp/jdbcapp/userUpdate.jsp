<%@ page import="java.sql.*" %> 
<%
String username = request.getParameter("username").toString();
String bttn = request.getParameter("submit").toString();
String user_pass=request.getParameter("user_pass").toString();
String firstname=request.getParameter("firstname").toString();
String lastname=request.getParameter("lastname").toString(); 
String email=request.getParameter("email").toString();
String state=request.getParameter("state").toString();
String city=request.getParameter("city").toString(); 
String country=request.getParameter("country").toString(); 
ResultSet rs_update = null;
int count_update=0;
int count=0;
Connection conn = null;
String url = "jdbc:odbc:mysql";
//String dbName = "user_register";
String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
String userName = "root"; 
String password = " ";
int id = 0;
int sumcount=0; 
Statement st;
String query_update="";
try {
Class.forName(driver).newInstance();

conn = DriverManager.getConnection(url,userName,password);
String query = "select count(*) from register where 
username='"+username+"'";

st = conn.createStatement();
ResultSet rs = st.executeQuery(query);
while(rs.next()){
count = rs.getInt(1);

}
if(bttn.equals("Add") && count==0){
query = "insert into register set username='"+username+"',password='"+user_pass+"',firstname='"+firstname+"',lastname='"+lastname+"',email='"+email+"',state='"+state+"',city='"+city+"',country='"+country+"'"; 

st= conn.createStatement();

}
else if(bttn.equals("Update")){
id = Integer.parseInt(request.getParameter("id").toString());
query_update = "select count(*) from register where username='"+username+"' and id!='"+id+"'";
// out.println(query_update);
st = conn.createStatement();
rs_update = st.executeQuery(query_update);
while(rs_update.next())
{
count_update = rs_update.getInt(1);
//out.println(rs_update.getInt(1));
}
// out.println(count_update);
if(count_update==0)
{
query = "update register set username='"+username+"',password='"+user_pass+"',firstname='"+firstname+"',lastname='"+lastname+"',mail='"+email+"',state='"+state+"',city='"+city+"',country='"+country+"' where id="+id" "; 
}
else
{
response.sendRedirect("addform.jsp?id="+id);
}
}
else
{
response.sendRedirect("addform.jsp");
}


int i = st.executeUpdate(query);
if(i>0)
{
response.sendRedirect("adduser.jsp");
}
}
catch (Exception e) {
e.printStackTrace();
}
%> 

 
