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

var speed = 100 
var pause = 1000 
var timerID = null
var texttype = false
var ar = new Array()

ar[0] = "Manage Your Projects Online"
ar[1] = "An Easy Online Project Management tool"
ar[2] = "Upload your projects and get the results"

var msgnow = 0
var offset = 0

function stopBanner() {
        if (texttype)
                clearTimeout(timerID)
        texttype = false
}

function startBanner() {
        stopBanner()
        showBanner()
}

function showBanner() {
        var text = ar[msgnow]

        if (offset < text.length) {
                if (text.charAt(offset) == " ")
                        offset++                        

                var partialMessage = text.substring(0, offset + 1) 
                window.status = partialMessage
                offset++ 
                timerID = setTimeout("showBanner()", speed)
                texttype = true
        } else {
                offset = 0
                msgnow++
                if (msgnow == ar.length)
                        msgnow = 0

                timerID = setTimeout("showBanner()", pause)
                texttype = true
        }
}

</SCRIPT>
</head>

<BODY onLoad="startBanner()">
<form name="uploadform" enctype="multipart/form-data" action="http:\\localhost\project\upload.php" method="post">
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

<table border="0" width="979" height="423">
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
		<td height="423" width="752" valign="top">
		<fieldset>
		<table cellpadding="0" cellspacing="0" width="748" height="430">
			<!-- MSTableType="layout" -->
			<tr>
			<td valign="middle" align="center">
			<FONT face="Verdana, Arial, Helvetica" 
             color=#003366 size=4><B>Folders</B></FONT>
            
			</td>
				<td height="34">&nbsp;</td>
			</tr>
			<tr>
			<td height="154" valign="top" align="left" colspan="2">
			<fieldset>
			<table cellpadding="0" cellspacing="0" width="744" height="152">
				<!-- MSTableType="layout" -->
				<tr>
					<td valign="top" align="center">
					<br>
					<FONT face="Verdana, Arial, Helvetica" 
             		color=magenta size=2><B>Folder</B></FONT>
             		</td>
             		
					<td valign="top" align="center">
					<br>
					<FONT face="Verdana, Arial, Helvetica" 
             		color=magenta size=2><B>Size</B></FONT>
					</td>
				<td height="38">&nbsp;</td>
				</tr>
				<tr>
					<td valign="top" align="center">
					<br>
					<FONT face="Verdana, Arial, Helvetica" 
            		color=green size=2><B>Inbox</B></FONT>
					</td>
					<td valign="top">&nbsp;</td>
					<td height="38">&nbsp;</td>
				</tr>
				<tr>
					<td valign="top" align="center">
					<br>
					<FONT face="Verdana, Arial, Helvetica" 
            		color=green size=2><B>Folder</B></FONT>
					</td>
					<td valign="top">&nbsp;</td>
					<td height="38">&nbsp;</td>
				</tr>
				<tr>
					<td width="301" valign="top" align="center">
					<br>
					<FONT face="Verdana, Arial, Helvetica" 
            		color=green size=2><B>Total</B></FONT>
					</td>
					<td width="431" valign="top">&nbsp;</td>
					<td height="38" width="12">&nbsp;</td>
				</tr>

			</table>
			</fieldset>
			</td>
			</tr>
			<tr>
				<td width="734">&nbsp;</td>
				<td height="242" width="14">&nbsp;</td>
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