<html>
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
  
  if (form.feedsub.value == "")
   {
    valid = false;
    setColor(form.feedsub, bgBad);
  
   }
   else
   {
    setColor(form.feedsub, bgGood);
   }
  
  if (form.txtname.value == "")
   {
    valid = false;
    setColor(form.txtname, bgBad);
  
   }
   else
   {
    setColor(form.txtname, bgGood);
   }


  if (form.phone.value == "")
   {
    valid = false;
    setColor(form.phone, bgBad);
     }
   else
   {
    setColor(form.phone, bgGood);
   }
   
     if (form.txtpid.value == "")
   {
    valid = false;
    setColor(form.txtpid, bgBad);
  
   }
   else
   {
    setColor(form.txtpid, bgGood);
   }
   
  if (!valid) alert("Please fill out all the fields.");
  return valid;
}

function checkFeed()
	{
	if(document.form.feedback.value==" " )
		{
		alert("Please enter your feedback");
		}	
	}		
function checkPhone()
	{
	if(isNaN(document.form.phone.value))
		{
		alert("Please enter only numbers");
		}
	if(document.form.phone.value.length <10)
		{
		alert("Please enter a valid phone number");
		}		
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

     BODY {
SCROLLBAR-FACE-COLOR: red; SCROLLBAR-HIGHLIGHT-COLOR: gray; 

SCROLLBAR-SHADOW-COLOR: black; SCROLLBAR-ARROW-COLOR: gray; 

SCROLLBAR-TRACK-COLOR: black; SCROLLBAR-DARKSHADOW-COLOR: red
}
font{text-decoration:None;}
</STYLE>
</head>
<BODY onload="timeout = window.setTimeout('setMessage()',500);"> 
<FORM  name=form  id=form action="http://localhost/project/feedback.php" onSubmit="return checkInput(this)" method="post">
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
<table border="0" width="978" height="77" >
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

</head>
<body>

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
		<img  src="images/register_now.gif" width="129" height="27" border="0" align="right"></a></td>
	</tr>
	
	<tr>
		<td height="39" width="978" valign="top" colspan="3">
		<center><img src="images/free_prices.gif"></center>		
	</tr>		

</table>
<br><br>
<table border="0" width="492" height="269" align="center">
	<tr>
		<td height="263" width="482" align="center" valign="middle">
		<fieldset style="width: 428; height: 196;background-color:lightyellow;">
		<br><br><br><br><br><b>
          <FONT face="Verdana, Arial, Helvetica" color=#0055bb>
			<?php
			
			$con=mysql_connect("localhost","root","");
			
			$db=mysql_select_db("amit");
			
			$feedsub=$_POST['feedsub'];
			
			$txtname=$_POST['txtname'];
			
			$phone=$_POST['phone'];
			
			$txtpid=$_POST['txtpid'];
			
			$feedback=$_POST['feedback'];
			
			$query="insert into feedback values('$feedsub','$txtname','$phone','$txtpid','$feedback')";
			
			mysql_query($query) or die("Error:Insertion Failed");
			
			echo "Your Feedback Has Been sended Successfully";
		
			?>
          </font></b>
          </fieldset>
		</td>
	</tr>
</table>
<br><br>
<table border="0" width="987" height="31">
	<tr>
		<td height="31" width="987">
		<center> <img src="images/logo-banner.gif" width="352" height="40" border="0"></center>
		</td>
	</tr>
</table>
</form>
</body>
</html>