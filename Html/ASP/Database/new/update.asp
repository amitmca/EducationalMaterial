<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">

<head>

<style type="text/css">
tr{font-size:16px;font-weight:bold;text-align:center}
</style> 
<link rel="File-List" href="update_files/filelist.xml">
<!--[if !mso]>
<style>
v\:*         { behavior: url(#default#VML) }
o\:*         { behavior: url(#default#VML) }
.shape       { behavior: url(#default#VML) }
</style>
<![endif]--><!--[if gte mso 9]>
<xml><o:shapedefaults v:ext="edit" spidmax="1027"/>
</xml><![endif]-->
</head>

<body>

<center>
<div style="border-style: solid; border-width: 1px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px">
	<span style="background-color: #FFFF00"><b>
	<font face="Verdana" color="#0000FF"><a href="http://localhost/asp/Database/new/menu.html">Home</a> |&nbsp;<a href="http://localhost/asp/Database/new/insert.html">Insert </a>|<a href="http://localhost/asp/Database/new/delete.html"> Delete </a>|<a href="http://localhost/asp/Database/new/update.html"> Update</a> | 
	<a href="http://localhost/asp/Database/new/select.asp">Display</a>| 
	</font></b></span><a href="http://localhost/asp/Database/new/search.html">
	<span style="background-color: #FFFF00"><b><font face="Verdana">Search</font></b></span></a></div>
</center>
<br><br>

<p><center>
<%

Set MyConn = Server.CreateObject("ADODB.Connection")

MyConn.Open "FILEDSN=C:\Inetpub\wwwroot\asp\Database\new\sqlite.dsn"

sql="UPDATE employee SET ename='"& request.Form("ename") &"' where eno="&request.form("eno") 
  
MyConn.execute(sql)

MyConn.Close


%>

</center> </p>

<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <!--[if gte vml 1]><v:shapetype id="_x0000_t136"
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
</v:shapetype><v:shape id="_x0000_s1025" type="#_x0000_t136" style='width:330pt;
 height:39pt' fillcolor="#9400ed" strokecolor="#eaeaea" strokeweight="1pt">
 <v:fill color2="blue" angle="-90" colors="0 #a603ab;13763f #0819fb;22938f #1a8d48;34079f yellow;47841f #ee3f17;57672f #e81766;1 #a603ab"
  method="none" type="gradient"/>
 <v:shadow on="t" type="perspective" color="silver" opacity="52429f" origin="-.5,.5"
  matrix=",46340f,,.5,,-4768371582e-16"/>
 <v:textpath style='font-family:"Arial Black";font-size:28pt;v-text-kern:t'
  trim="t" fitpath="t" string="Updated Successfully"/>
</v:shape><![endif]--><![if !vml]><img border=0 width=470 height=57
src="update_files/image001.gif" alt="Updated Successfully" v:shapes="_x0000_s1025"><![endif]>
</p>

<table border="1" align="center" valign="top">
<tr>
	<td bgcolor="red">Emp No</td>
	<td bgcolor="red">Emp Name</td>
</tr>
<%
Set MyConn = Server.CreateObject("ADODB.Connection")

MyConn.Open "FILEDSN=C:\Inetpub\wwwroot\asp\Database\new\sqlite.dsn"
sql = "SELECT * FROM employee"

Set RS = MyConn.Execute(sql)


WHILE NOT RS.EOF
	
	Response.write("<tr valign='top'><td align='center' bgcolor='#FFFF00'>"&RS("eno")&"</td><td align='center' bgcolor='#FFFF00'>"&RS("ename")&"</td></tr><br>")
RS.MoveNext 

WEND

RS.Close 

MyConn.Close
%>

</table>
<br>
<br><br><br><br><br><br><br><br><br><br>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img border="0" src="ad.gif" width="728" height="90"></p>

</body>