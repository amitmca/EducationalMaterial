<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Registration Form</title>


<font color="red">
<style type="text/css">

#informationbar{
position: fixed;
left: 0;
width: 100%;
text-indent: 5px;
padding: 5px 0;
background-color: lightyellow;
border-bottom: 1px solid black;
font: bold 12px Verdana;
}

* html #informationbar{ /*IE6 hack*/
position: absolute;
width: expression(document.compatMode=="CSS1Compat"? document.documentElement.clientWidth+"px" : body.clientWidth+"px");
}

</style>

<script type="text/javascript">

/***********************************************

* Animated Information Bar- by JavaScript Kit (www.javascriptkit.com)
* This notice must stay intact for usage
* Visit JavaScript Kit at http://www.javascriptkit.com/ for this script and 100s more

***********************************************/

function informationbar(){
	this.displayfreq="always"
	this.content='<a href="javascript:informationbar.close()"><img src="images/close.gif" style="width: 14px; height: 14px; float: right; border: 0; margin-right: 5px" /></a>'
}

informationbar.prototype.setContent=function(data){
	this.content=this.content+data
	document.write('<div id="informationbar" style="top: -500px">'+this.content+'</div>')
}

informationbar.prototype.animatetoview=function(){
	var barinstance=this
	if (parseInt(this.barref.style.top)<0){
		this.barref.style.top=parseInt(this.barref.style.top)+5+"px"
		setTimeout(function(){barinstance.animatetoview()}, 50)
	}
	else{
		if (document.all && !window.XMLHttpRequest)
		this.barref.style.setExpression("top", 'document.compatMode=="CSS1Compat"? document.documentElement.scrollTop+"px" : body.scrollTop+"px"')
	else
		this.barref.style.top=0
	}
}

informationbar.close=function(){
	document.getElementById("informationbar").style.display="none"
	if (this.displayfreq=="session")
		document.cookie="infobarshown=1;path=/"
}

informationbar.prototype.setfrequency=function(type){
	this.displayfreq=type
}

informationbar.prototype.initialize=function(){
	if (this.displayfreq=="session" && document.cookie.indexOf("infobarshown")==-1 || this.displayfreq=="always"){
		this.barref=document.getElementById("informationbar")
		this.barheight=parseInt(this.barref.offsetHeight)
		this.barref.style.top=this.barheight*(-1)+"px"
		this.animatetoview()
	}
}

window.onunload=function(){
	this.barref=null
}

</script>


<script type="text/javascript">
<!--Invocation code-->

var infobar=new informationbar()
infobar.setContent('                            Register only once and manage your projects forever.Enjoy it......                     ')
//infobar.setfrequency('session') //Uncomment this line to set information bar to only display once per browser session!
infobar.initialize()

</script>
</font>


<SCRIPT TYPE="text/javascript">
<!--
function popup(mylink, windowname)
{
if (! window.focus)return true;
var href;
if (typeof(mylink) == 'string')
   href=mylink;
else
   href=mylink.href;
window.open(href, windowname, 'width=400,height=200,scrollbars=yes');
return false;
}
//
-->
</SCRIPT>


</head>

<body background="images/banner2_old1.jpg">


<script language="JavaScript1.2" src="js_disable_right_click_cfg.js"></script>
<script language="JavaScript1.2" src="js_disable_right_click.js"></script>

<table border="0" width="886" height="124" bgcolor="lightyellow" align="center">
	<tr>
		<td height="78" width="258" valign="middle" align="center">
		<img src="images/logosmall_free.gif" width="258" height="60">
		</td>
		<td height="78" width="511" valign="middle" align="center">
		
		<img border="0" src="images/regitser.bmp" width="455" height="77" align="center" onmouseover="showTip('Please read the tips given for every field and then fill the form',200,25)"  onmouseout="hideTip()" >
		</td>
		<td height="78" width="4" valign="middle" align="center">
		<fieldset>
		<FONT face="Verdana, Arial, Helvetica" color=red>
		<b>
		<script>

/*Current date in form credit: 
JavaScript Kit (www.javascriptkit.com)
Over 200+ free scripts here!
*/

var mydate=new Date()
var theyear=mydate.getYear()
if (theyear < 1000)
theyear+=1900
var theday=mydate.getDay()
var themonth=mydate.getMonth()+1
if (themonth<10)
themonth="0"+themonth
var theday=mydate.getDate()
if (theday<10)
theday="0"+theday

//////EDIT below three variable to customize the format of the date/////

var displayfirst=themonth
var displaysecond=theday
var displaythird=theyear

////////////////////////////////////

document.write(displaysecond+"/"+displayfirst+"/"+displaythird);
</script>
		</b>
		</FONT>	
		
		</fieldset>	
		</td>
	</tr>
	<tr>
		<td height="40" width="880" valign="top" align="center" colspan="3">
		<fieldset style="background-color:#efffed">
		<table cellpadding="0" cellspacing="0" width="866" height="36">
			<!-- MSTableType="layout" -->
			<tr>
				<td width="186">
				<a href="http://localhost:8080/examples/jsp/Assign/insert.htm">
				<FONT face=Verdana color=#e30102><b>Insert</b></FONT>
				</a>
				</td>
				<td width="198">
				<a href="http://localhost:8080/examples/jsp/Assign/delete.htm">
				<FONT face=Verdana color=#e30102><b>Delete</b></FONT>
				</a>
				</td>
				<td width="118">
				<a href="http://localhost:8080/examples/jsp/Assign/update.jsp">
				<FONT face=Verdana color=#e30102><b>Update</b></FONT>
				</a>
				</td>
				<td width="225" align="center">
				<a href="http://localhost:8080/examples/jsp/Assign/display.jsp">
				<FONT face=Verdana color=#e30102><b>Display</b></FONT>
				</a>
				</td>
				<td width="139" height="36" align="center">
				<a href="http://localhost:8080/examples/jsp/Assign/search.htm">
				<FONT face=Verdana color=#e30102><b>Search</b></FONT>
				</a>
				</td>
			</tr>
		</table>
		</fieldset>
		</td>
	</tr>
	
	</table>


		<%@page import="java.sql.*;" %>
		
		<%

		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:SQLITE";
			
			Connection conn=DriverManager.getConnection(url);
		
			Statement st=conn.createStatement();
			
			String pid1=request.getParameter("txtpid");

			String sql="select * from register where pid='"+pid1+"'";

			ResultSet rs=st.executeQuery(sql);

			String name="",pid="",pass="",security="",ans="",date="",gender="",country="";
				
	
			while(rs.next())
				{
				name=rs.getString(1);
				pid=rs.getString(2);
				pass=rs.getString(3);
				security=rs.getString(4);
				ans=rs.getString(5);
				date=rs.getString(6);
				gender=rs.getString(7);
				country=rs.getString(8);
		%>
	


<table border="1" width="895" height="40" align="center" bgcolor="lightyellow" bordercolor="red"> 
	<tr>
		<td height="36" width="885" valign="top">
		<fieldset>
	     <table cellpadding="0" cellspacing="0" width="886" height="34">
			<!-- MSTableType="layout" -->
			
			<tr>
				<td width="97"><font color="green"><b><% out.println(name); %></b></font></td>
				<td width="107"><font color="green"><b><% out.println(pid); %></b></font></td>
				<td width="115"><font color="green"><b><% out.println(pass); %></b></font></td>
				<td width="113"><font color="green"><b><% out.println(security); %></b></font></td>
				<td width="118"><font color="green"><b><% out.println(ans); %></b></font></td>
				<td width="112"><font color="green"><b><% out.println(date); %></b></font></td>
				<td width="114"><font color="green"><b><% out.println(gender); %></b></font></td>
				<td width="110"><font color="green"><b><% out.println(country); %></b></font></td>
			</tr>
			</table>
	    </fieldset>
		</td>
	</tr>
</table>

<%				
				}
			
			conn.close();
			}

		catch(Exception e)
			{
			out.println(e);
			}
		%></b>

	
<center>
<p>
<object classid="clsid:D27CDB6E-AE6D-11CF-96B8-444553540000" id="obj1" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" border="0" width="892" height="93">
	<param name="movie" value="Idbi.swf">
	<param name="quality" value="High">
	<embed src="Idbi.swf" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" name="obj1" width="892" height="93"></object>
</p>
</center>


	


</body>
</html>