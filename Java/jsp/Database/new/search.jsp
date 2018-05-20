<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">

<head>
<style type="text/css">
 tr{font-size:17px;font-weight:bold;text-align:center}
</style>  
<!--[if !mso]>
<style>
v\:*         { behavior: url(#default#VML) }
o\:*         { behavior: url(#default#VML) }
.shape       { behavior: url(#default#VML) }
</style>
<![endif]-->
<link rel="File-List" href="search_files/filelist.xml">
<!--[if gte mso 9]>
<xml><o:shapedefaults v:ext="edit" spidmax="1027"/>
</xml><![endif]-->
</head>

<body>
<center>
<div style="border-style: solid; border-width: 1px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px">
	<span style="background-color: #FFFF00"><b>
	<font face="Verdana" color="#0000FF"><a href="http://localhost:8080/examples/jsp/Database/new/menu.html">Home</a> |&nbsp;<a href="http://localhost:8080/examples/jsp/Database/new/insert.html">Insert </a>|<a href="http://localhost:8080/examples/jsp/Database/new/delete.html"> Delete </a>|<a href="http://localhost:8080/examples/jsp/Database/new/update.html"> Update</a> | 
	<a href="http://localhost:8080/examples/jsp/Database/new/select.jsp">Display</a>|<a href="http://localhost:8080/examples/jsp/Database/new/search.html">Search</a>
	</font></b></span></div>
</center>



<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <!--[if gte vml 1]><v:shapetype id="_x0000_t136"
 coordsize="21600,21600" o:spt="136" adj="10800" path="m@7,l@8,m@5,21600l@6,21600e">
 <v:formulas>
  <v:f eqn="sum #0 0 10800"/>
  <v:f eqn="prod #0 2 1"/>
  <v:f eqn="sum 21600 0 @1"/>
  <v:f eqn="sum 0 0 @2"/>
  <v:f eqn="sum 21600 0 @3"/>
  <v:f eqn="if @0 @3 0"/>
  <v:f eqn="if @0 21600 @1"/>
  <v:f eqn="if @0 0 @2"/>
  <v:f eqn="if @0 @4 21600"/>
  <v:f eqn="mid @5 @6"/>
  <v:f eqn="mid @8 @5"/>
  <v:f eqn="mid @7 @8"/>
  <v:f eqn="mid @6 @7"/>
  <v:f eqn="sum @6 0 @5"/>
 </v:formulas>
 <v:path textpathok="t" o:connecttype="custom" o:connectlocs="@9,0;@10,10800;@11,21600;@12,10800"
  o:connectangles="270,180,90,0"/>
 <v:textpath on="t" fitshape="t"/>
 <v:handles>
  <v:h position="#0,bottomRight" xrange="6629,14971"/>
 </v:handles>
 <o:lock v:ext="edit" text="t" shapetype="t"/>
</v:shapetype><v:shape id="_x0000_s1025" type="#_x0000_t136" style='width:469.5pt;
 height:31.5pt' fillcolor="#369" stroked="f">
 <v:shadow on="t" color="#b2b2b2" opacity="52429f" offset="3pt"/>
 <v:textpath style='font-family:"Times New Roman";font-size:28pt;v-text-kern:t'
  trim="t" fitpath="t" string="Displaying Searched Data From Database using JSP"/>
</v:shape><![endif]--><![if !vml]><img border=0 width=630 height=45
src="search_files/image001.gif"
alt="Displaying Searched Data From Database using JSP" v:shapes="_x0000_s1025"><![endif]></p>



<%@page import="java.sql.*" %>
<table border="1" bordercolor="red"  align="center" valign="middle" background="HDR_WIZ_RIGHT.PNG">
<th>
	<tr>
		<td><font color="red"><b>Emp No</font></td>
		<td><font color="red"><b>Emp Name</font></td>
		
	</tr>
</th>

<%
String eno1;
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:SQLITE";
			
			Connection conn=DriverManager.getConnection(url);
		
			Statement st=conn.createStatement();
			
			eno1=request.getParameter("eno");

			String sql="select * from emp where eno="+eno1+"";

			ResultSet rs=st.executeQuery(sql);

			String eno="",ename="";
				
			
				while(rs.next())
					{
					eno=rs.getString(1);
					ename=rs.getString(2);
					%>
				<tr>
				<td><font color="green"><b><% out.println(eno); %></b></font></td>
				<td><font color="green"><% out.println(ename); %></b></font></td>
				</tr>
				<%				
				}		
			
			conn.close();
			}

		catch(Exception e)
			{
			out.println(e);
			}

%>


</table>
</body>
</html>