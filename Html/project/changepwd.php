<?php session_start(); ?>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Search,Register,Impelement,Login,Upload,Mofify/Suceess</title>
<style>
font{text-decoration:None;}
.t22gr {
	FONT: 22px verdana; COLOR: #77c805
}
</STYLE>

<SCRIPT LANGUAGE="JavaScript">
<!-- Original:  Robert Bui (astrogate@hotmail.com) -->
<!-- Web Site:  http://astrogate.virtualave.net -->
<!-- Begin
var interval =50; // delay between rotating images (in seconds)
var random_display = 1; // 0 = no, 1 = yes
interval *= 1000;
var image_index = 0;
image_list = new Array();
image_list[image_index++] = new imageItem("images/email/index3443434.gif");
image_list[image_index++] = new imageItem("images/email/index2.gif");
image_list[image_index++] = new imageItem("images/email/index222.gif");
image_list[image_index++] = new imageItem("images/email/index3444.gif");
image_list[image_index++] = new imageItem("images/email/index3443434.gif");
image_list[image_index++] = new imageItem("images/email/43535.gif");
image_list[image_index++] = new imageItem("images/email/index233.gif");
image_list[image_index++] = new imageItem("images/email/index344.gif");
image_list[image_index++] = new imageItem("images/email/index2222.gif");
image_list[image_index++] = new imageItem("images/email/3455335.gif");
image_list[image_index++] = new imageItem("images/email/34535335.gif");
var number_of_image = image_list.length;
function imageItem(image_location) {
this.image_item = new Image();
this.image_item.src = image_location;
}
function get_ImageItemLocation(imageObj) {
return(imageObj.image_item.src)
}
function generate(x, y) {
var range = y - x + 1;
return Math.floor(Math.random() * range) + x;
}
function getNextImage() {
if (random_display) {
image_index = generate(0, number_of_image-1);
}
else {
image_index = (image_index+1) % number_of_image;
}
var new_image = get_ImageItemLocation(image_list[image_index]);
return(new_image);
}
function rotateImage(place) {
var new_image = getNextImage();
document[place].src = new_image;
var recur_call = "rotateImage('"+place+"')";
setTimeout(recur_call, interval);
}
//  End -->
</script>

<SCRIPT LANGUAGE="JavaScript">
<!--

function setColor(el, bg) 
{
  if (el.style) el.style.backgroundColor = bg;
}

function checkInput(form) 
{
  var bgBad = "white";
  var bgGood = "lightyellow";
  var valid = true;
  if (form.txtpid.value == "") {
    valid = false;
    setColor(form.txtpid, bgBad);
  
  } else {
    setColor(form.txtpid, bgGood);
  }
  if (form.txtopass.value == "") {
    valid = false;
    setColor(form.txtopass, bgBad);
  
  } else {
    setColor(form.txtopass, bgGood);
  }
  
  
  if (form.txtnpass.value == "") {
    valid = false;
    setColor(form.txtnpass, bgBad);
  
  } else {
    setColor(form.txtnpass, bgGood);
  }
  
  
  if (form.txtnpass.value == "") {
    valid = false;
    setColor(form.txtnpass, bgBad);
  
  } else {
    setColor(form.txtnpass, bgGood);
  }
  
  
  if (form.txtvnpass.value == "") {
    valid = false;
    setColor(form.txtvnpass, bgBad);
  
  } else {
    setColor(form.txtvnpass, bgGood);
  }
  
  
  if (form.code.value == "") {
    valid = false;
    setColor(form.code, bgBad);
  
  } else {
    setColor(form.code, bgGood);
  }
  if (!valid) alert("Please fill out both the fields.");
  return valid;
}
// -->
</SCRIPT>

<script language="javascript">
function verifyPassword()
 {
	var pass=document.form.txtnpass.value;
	var vpass=document.form.txtvnpass.value;
    if (vpass!=pass) 
    {
	  alert("Password does not matches,correct it");
	  vpass.focus();
  	  vpass.blur();
	  vpass.select();
	}
	
}
</script>

</head>

<BODY OnLoad="rotateImage('rImage')">

<FORM  name=form onSubmit="return checkInput(this)" action="http://localhost/project/update.php" method="post">

<table border="0" width="995" height="89">
	<tr>
		<td height="83" width="989" valign="middle" background="images/stylusstudio_02.gif">
		<fieldset>
		<img border="0" src="images/logosmall_free.gif" width="271" height="60">&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
		<img border="0" src="images/employee.jpg" width="275" height="75">
		</fieldset>
		</td>
	</tr>

</table>

<table border="0" width="996" height="34" align="center">
	<tr>
		<td>
		<fieldset style="width: 984; height: 28">
		<table cellpadding="0" cellspacing="0" width="977">
		
			<tr>
			<td height="26" width="197" align="left" background="images/bg.gif">
		<h2>
<script language="JavaScript1.2">

/*
Neon Lights Text
By JavaScript  (http://learniran.com)
Over 500+ free scripts here!
*/

var message="Welcome"
var neonbasecolor="red"
var neontextcolor="blue"
var flashspeed=100  //in milliseconds

///No need to edit below this line/////

var n=0
if (document.all){
document.write('<font color="'+neonbasecolor+'">')
for (m=0;m<message.length;m++)
document.write('<span id="neonlight">'+message.charAt(m)+'</span>')
document.write('</font>')

//cache reference to neonlight array
var tempref=document.all.neonlight
}
else
document.write(message)

function neon(){

//Change all letters to base color
if (n==0){
for (m=0;m<message.length;m++)
tempref[m].style.color=neonbasecolor
}

//cycle through and change individual letters to neon color
tempref[n].style.color=neontextcolor

if (n<tempref.length-1)
n++
else{
n=0
clearInterval(flashing)
setTimeout("beginneon()",1500)
return
}
}

function beginneon(){
if (document.all)
flashing=setInterval("neon()",flashspeed)
}
beginneon()


</script>

<font color="#FF0000" size="4">
<b>
		<?php

		echo $_SESSION['name'];
		?>
</b>		
</font>
<img src="images/correct.gif">
</h2>
			
		</td>
		<td height="26" width="336" align="right" background="images/bg.gif">
		<input type="text" size="25" name="search">
		<input type="image" src="images/search_trans2.gif">
		</td>
		<td height="26" width="239" align="center" background="images/bg.gif">
		<a href="changepwd.php"><FONT face="Verdana, Arial, Helvetica" color=#0055bb size=2><b> Change Password</b></font></a>
		</td>
		<td height="26" width="200" align="center" background="images/bg.gif">
		<a href="signout.php"><b><FONT face="Verdana, Arial, Helvetica" color=red size=2> Logout</FONT></b></font></a>
		</td>
			</tr>
		</table>
</fieldset>					
					
		</td>
	</tr>
</table>



<table border="0" width="974" height="423">
	<tr>
		<td height="423" width="206" valign="top">
	<fieldset style="width: 203px; height: 435px">
		<table cellpadding="0" cellspacing="0" width="199" height="470" background="images/star.gif">
			<!-- MSTableType="layout" -->
			<tr>
			<td valign="top" height="21">
			&nbsp;
			</td>
		

			</tr>
			<tr>
			<td valign="middle" height="48" bgcolor="red" align="center">
			<a href="login.php"><font color="yellow"><h3>Inbox</h3></font></a>
			</td>
			</tr>
			<tr>
			<td valign="middle" height="45" bgcolor="red" align="center">
			<a href="upload1.php"><font color="yellow"><h3>Upload</h3></font></a>
			</td>
			</tr>
			<tr>
			<td valign="middle" height="53" bgcolor="red" align="center">
			<a href="folders.php"><font color="yellow"><h3>Folders</h3></font></a>
			</td>
			</tr>
			<tr>
			<td valign="middle" height="303" width="199" background="images/star.gif" align="center">
			<br>
			<a href=" ">
			<object classid="clsid:D27CDB6E-AE6D-11CF-96B8-444553540000" id="obj1" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" border="0" width="193" height="242">
				<param name="movie" value="bigtv_SVOD&amp;PPV_USP's_185x260.swf">
				<param name="quality" value="High">
				<embed src="bigtv_SVOD&PPV_USP's_185x260.swf" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" name="obj1" width="193" height="242"></object>
			</a>
			
			</td>
			
			</tr>
						
		</table>
		</fieldset>

		</td>
		<td height="423" width="747" valign="top">
		<fieldset>
		<table cellpadding="0" cellspacing="0" width="744" height="428">
			<!-- MSTableType="layout" -->
	
			<tr>
			<td height="402">
			<FONT face="Verdana, Arial, Helvetica" 
      color=#003366 size=4><B>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</B></FONT><TABLE cellSpacing=1 cellPadding=10 width=460 align=center border=0>
        <TBODY>
        <TR vAlign=top>
          <TD><fieldset style="width: 428; height: 196;background-color:lightyellow">
          <FONT face="Verdana, Arial, Helvetica" 
             color=#003366 size=4><B><center>Change Password</center></B></FONT>
          <table cellpadding="0" cellspacing="0" width="436" height="263">
			<!-- MSTableType="layout" -->
			<tr>
				<td height="39" colspan="3"><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2>
				<center>Complete the following fields to change your password.</center></FONT>
				</td>
			</tr>
			<tr>
				<td><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2>
				 Project ID</font>
				</td>
				<td height="43" colspan="2">
				<input type="text" name="txtpid" value="<?php echo $_SESSION['txtpid']; ?>"></td>
			</tr>
			<tr>
				<td><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2>
				 Current Password</font>
				</td>
				<td height="43" colspan="2"><input type="password" name="txtopass" value="<?php echo $_SESSION['txtpass']; ?>"></td>
			</tr>
			<tr>
				<td><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2>
				 New Password</font>
			</td>
				<td height="45" colspan="2"><input type="password" name="txtnpass"></td>
			</tr>
			<tr>
				<td><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2>
				 Confirm New Password</font>
			</td>
				<td height="45" colspan="2"><input type="password" name="txtvnpass" onchange="verifyPassword();"></td>
			</tr>
			<tr>
				<td><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2>
				 Enter The Code Shown</font>
			</td>
				<td height="45" width="157"><input type="text" name="code"></td>
				<td height="45" width="91" valign="middle">
				<img name="rImage" src="images/email/43535.gif" width=115 height=31></td>
			</tr>
			<tr>
				<td height="45" colspan="3" valign="middle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="image" src="images/update.gif"><a href="login.html"><img border="0" src="images/cancel.gif" width="93" height="27"></a>
				</td>
			</tr>
			<tr>
				<td width="188"></td>
				<td height="1" width="248" colspan="2"></td>
			</tr>
			</table>
          </fieldset></TD></TR></TBODY></TABLE>
          </td>
			</tr>
			<tr>
				<td height="26" width="744">&nbsp;</td>
			</tr>
			
		</table>
		<br><br>
		</fieldset>
		</td>
	</tr>
</table>

<table border="0" width="974" height="5">
		<tr>
			<td height="30" width="974">
			<center><img src="images/logo-banner.gif" width="352" height="40"></center>
			</td>
		</tr>
	</table>
</form>
</body>

</html>