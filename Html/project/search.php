<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv="Content-Language" content="en-us">

<title>Manage Your Projects Online</title>


<link rel="stylesheet"
      style="text/css"
      href="ext.css">
      
<SCRIPT LANGUAGE="JavaScript">
<!--

function setColor(el, bg) 
{
  if (el.style) el.style.backgroundColor = bg;
}

function checkInput(form) 
{
  var bgBad = "lightyellow";
  var bgGood = "white";
  var valid = true;
  if (form.language.value == "") 
  {
    valid = false;
    setColor(form.language, bgBad);
  
  }
  else
   {
    setColor(form.language, bgGood);
  }
  
  if (!valid) alert("Please select name of the language.");
  return valid;
}
// -->
</SCRIPT>
      
<script language="javascript">
 
var startMsg = "WELCOME TO WORLD OF PROJECTS"; 
var str = ""; 
var msg = ""; 
var leftMsg = ""; 

function setMessage() 
{ 
if (msg == "") 
{ 
str = " "; 
msg = startMsg; 
leftMsg = ""; 
} 
if (str.length == 1) 
{ 
while (msg.substring(0, 1) == " ") 
{ 
leftMsg = leftMsg + str; 
str = msg.substring(0, 1); 
msg = msg.substring(1, msg.length); 
} 
leftMsg = leftMsg + str; 
str = msg.substring(0, 1); 
msg = msg.substring(1, msg.length); 
for (var ii = 0; ii < 120; ii++) 
{ 
str = " " + str; 
} 
} 
else 
str = str.substring(10, str.length); 
window.status = leftMsg + str; 

timeout = window.setTimeout('setMessage()',5); 
} 
</script>

<STYLE>

BODY
{
SCROLLBAR-FACE-COLOR: red; SCROLLBAR-HIGHLIGHT-COLOR: gray; 

SCROLLBAR-SHADOW-COLOR: black; SCROLLBAR-ARROW-COLOR: gray; 

SCROLLBAR-TRACK-COLOR: black; SCROLLBAR-DARKSHADOW-COLOR: red
}
font
{
text-decoration:None;
}
</STYLE>

</head>

<BODY onload="timeout = window.setTimeout('setMessage()',500);"> 

<FORM  name=form onSubmit="return checkInput(this)" action="http://localhost/project/search.php">

<table border="0" width="977" height="89">
	<tr>
		<td height="83" width="971" valign="middle" background="images/stylusstudio_02.gif">
		<img border="0" src="images/logosmall_free.gif" width="271" height="59">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<img border="0" src="images/employee.jpg" width="275" height="75"></td>
	</tr>

</table>
<table border="0" width="976" height="23">
	<tr>
		<td height="23" width="125" align="center" bgcolor="red"><a href="index.htm"><font color="white"><b><FONT face="Verdana, Arial, Helvetica" size=-1>Home</FONT></b></font></a></td>
		<td height="23" width="125" align="center" bgcolor="red"><a href="aboutus.htm"><font color="white"><b><FONT face="Verdana, Arial, Helvetica" size=-1>About Us</FONT></b></font></a></td>
		<td height="23" width="125" align="center" bgcolor="red"><a href="search.htm"><font color="white"><b><FONT face="Verdana, Arial, Helvetica" size=-1>Search</FONT></b></font></a></td>
		<td height="23" width="125" align="center" bgcolor="red"><a href="features.htm"><font color="white"><b><FONT face="Verdana, Arial, Helvetica" size=-1>Features</FONT></b></font></a></td>
		<td height="23" width="125" align="center" bgcolor="red"><a href="contactus.htm"><font color="white"><b><FONT face="Verdana, Arial, Helvetica" size=-1>Contact Us</FONT></b></font></a></td>
		<td height="23" width="125" align="center" bgcolor="red"><a href="feedback.htm"><font color="white"><b><FONT face="Verdana, Arial, Helvetica" size=-1>Feedback</FONT></b></font></a></td>
		<td height="23" width="125" align="center" bgcolor="red"><a href="help.htm"><font color="white"><b><FONT face="Verdana, Arial, Helvetica" size=-1>Help</FONT></b></font></a></td>
	</tr>
</table>
<br>
<table border="0" width="978" height="112" >
	<tr>
		<td height="24" width="125" valign="top">
		
		<a href="index.htm"><img border="0" src="images/login.gif" width="82" height="27" border="0"></a></td>
		
		<td height="24" width="682" valign="top" align="center">
		
		<script language="JavaScript1.2">
//configure message
message="Free Online Project Management"
//animate text in NS6? (0 will turn it off)
ns6switch=1

var ns6=document.getElementById&&!document.all
mes=new Array();
mes[0]=-1;
mes[1]=-4;
mes[2]=-7;mes[3]=-10;
mes[4]=-7;
mes[5]=-4;
mes[6]=-1;
num=0;
num2=0;
txt="";
function jump0(){
if (ns6&&!ns6switch){
jump.innerHTML=message
return
}
if(message.length > 6){
for(i=0; i != message.length;i++){
txt=txt+"<span style='position:relative;' id='n"+i+"'>"+message.charAt(i)+"</span>"};
jump.innerHTML=txt;
txt="";
jump1a()
}
else{
alert("Your message is to short")
}
}

function jump1a(){
nfinal=(document.getElementById)? document.getElementById("n0") : document.all.n0
nfinal.style.left=-num2;
if(num2 != 9){
num2=num2+3;
setTimeout("jump1a()",50)
}
else{
jump1b()
}
}

function jump1b(){
nfinal.style.left=-num2;
if(num2 != 0){num2=num2-3;
setTimeout("jump1b()",50)
}
else{
jump2()
}
}

function jump2(){
txt="";
for(i=0;i != message.length;i++){
if(i+num > -1 && i+num < 7){
txt=txt+"<span style='position:relative;top:"+mes[i+num]+"'>"+message.charAt(i)+"</span>"
}
else{txt=txt+"<span>"+message.charAt(i)+"</span>"}
}
jump.innerHTML=txt;
txt="";
if(num != (-message.length)){
num--;
setTimeout("jump2()",50)}
else{num=0;
setTimeout("jump0()",50)}}
</script>



<h2><div id="jumpx" style="color:green"></div></h2>
<script>
if (document.all||document.getElementById){
jump=(document.getElementById)? document.getElementById("jumpx") : document.all.jumpx
jump0()
}
else
document.write(message)
</script>
	</td>
		
		<td height="24" width="157" valign="top">
		<a href="register.htm">
		<img border="0" src="images/register_now.gif" width="129" height="27" border="0" align="right"></a>
		</td>
	</tr>
	
	<tr>
		<td height="77" width="978" valign="top" colspan="3">
		<center><img src="images/free_prices.gif"><p>&nbsp;</p>
		</center>
		</td>
	</tr>
</table>

	


	<table border="0" width="986" height="227">
		<tr>
			<td width="221" valign="top" rowspan="3">
			<table cellpadding="0" cellspacing="0" width="219" height="214">
				<!-- MSTableType="layout" -->
				<tr>
					<td height="214" valign="middle" align="center" width="219" bgcolor="blue">
					<fieldset>
					<script src="template7js.js" type="text/javascript"></script><noscript><OBJECT id="template7obj" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" WIDTH=226 HEIGHT=320> <PARAM NAME=movie VALUE="template7.swf"> <PARAM NAME=menu VALUE=false> <PARAM NAME=quality VALUE=high> <PARAM NAME=wmode VALUE=opaque> <PARAM NAME=bgcolor VALUE=#FFFFFF> <EMBED src="template7.swf" menu=false quality=high wmode=opaque bgcolor=#FFFFFF  WIDTH=226 HEIGHT=320 TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"></EMBED></OBJECT></noscript>
					</fieldset>
					</td>
				</tr>
			</table>
			</td>
			
			<td width="496" valign="top" height="130" align="center" onmouseover="this.bgColor='#993300'" onMouseOut="this.bgColor='red'">
			<fieldset style="background-color:lightyellow;">
			
			<FONT face="Verdana, Arial, Helvetica" color="red" size=+3><b>
			<?php
			$language=$_POST['language'];
			
			if($language=="c")
				{
				$temp="C";
				}

			if($language=="cpp")
				{
				$temp="C++";
				}

			if($language=="java")
				{
				$temp="JAVA";
				}
		
			if($language=="perl")
				{
				$temp="PERL";
				}
			
			if($language=="php")
				{
				$temp="PHP";
				}
				
			if($language=="js")
				{
				$temp="JAVA SCRIPT";
				}

			if($language=="vs")
				{
				$temp="VB SCRIPT";
				}

			if($language=="vb")
				{
				$temp="VISUAL BASIC";
				}
			
			if($language=="c#")
				{
				$temp="C#";
				}

			echo $temp." Projects";		
			echo "<br>";
			echo "<hr>";								
			?></b></font>
			<FONT face="Verdana, Arial, Helvetica" color="#9966FF"><b>
			<?php				
	
			$con=mysql_connect("localhost","root","") or die("ERROR:Connection Refused");

			$db=mysql_select_db("amit") or die("ERROR:Database Connection Refused");
	
			
			$query="select subject from search where langname='$language' order by subject";
			
			$rs=mysql_query($query) or die("ERROR:Query Not Executed");
			
			while($row=mysql_fetch_array($rs))
				{
				echo $row["subject"];
				echo "<br>";
				echo "<hr>";
				}			
			?>
			</b></font>
			<object classid="clsid:D27CDB6E-AE6D-11CF-96B8-444553540000" id="obj1" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" border="0" width="486" height="160">
				<param name="movie" value="dilbert_hero.swf">
				<param name="quality" value="High">
				<embed src="dilbert_hero.swf" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" name="obj1" width="486" height="160">
			</object>
			<a href="search.htm"><img src="images/prev.gif" border="0"></a>
			</fieldset>
			</td>
			
			<td width="256" valign="top" rowspan="3">
			<table cellpadding="0" cellspacing="0" width="214" height="211"  valign="top">
				<!-- MSTableType="layout" -->
				<tr>
					<td height="211" valign="top" width="214" bgcolor="blue">
					<fieldset>
						<script src="template6js.js" type="text/javascript"></script><noscript><OBJECT id="template6obj" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" WIDTH=215 HEIGHT=125> <PARAM NAME=movie VALUE="template6.swf"> <PARAM NAME=menu VALUE=false> <PARAM NAME=quality VALUE=high> <PARAM NAME=wmode VALUE=opaque> <PARAM NAME=bgcolor VALUE=#FFFFFF> <EMBED src="template6.swf" menu=false quality=high wmode=opaque bgcolor=#FFFFFF  WIDTH=215 HEIGHT=125 TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"></EMBED></OBJECT></noscript>
						</fieldset>
					</td>
				</tr>
			</table>
			</td>
			
		</tr>
	
	</table>
	
<table border="0" width="975" height="31">
		<tr>
		<td height="44" width="978" valign="top">
		<center> 
		<img src="images/logo-banner.gif" width="352" height="48"></center>
		</td>
	</tr>
</table>
	
</form>	
</body>
</html>