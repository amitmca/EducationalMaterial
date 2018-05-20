<?php session_start(); ?>
<html>
<head>
<title>Welcome To Aniket's Hotel</title>
<SCRIPT LANGUAGE="JavaScript">
<!-- Original:  Robert Bui (astrogate@hotmail.com) -->
<!-- Web Site:  http://astrogate.virtualave.net -->
<!-- Begin
var interval =2; // delay between rotating images (in seconds)
var random_display = 1; // 0 = no, 1 = yes
interval *= 1000;
var image_index = 0;
image_list = new Array();
image_list[image_index++] = new imageItem("images/hotel.jpg");
image_list[image_index++] = new imageItem("images/sharon-hotel.jpg");
image_list[image_index++] = new imageItem("images/Auckland_Hotel_Accommodation_Airedale.jpg");
image_list[image_index++] = new imageItem("images/hotel_ga_signage_small.jpg");
image_list[image_index++] = new imageItem("images/florence_hotel.jpg");

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

</head>
<body OnLoad="rotateImage('rImage')">
<table border="0" width="712" height="513" align="center">
	<tr>
		<td height="509" width="33" rowspan="4">
		<img border="0" src="images/left.gif" width="42" height="509"></td>
		<td height="30" width="627" colspan="3">
		<img border="0" src="images/up.gif" width="705" height="42"></td>
		<td height="509" width="38" rowspan="4">
		<img border="0" src="images/right.gif" width="42" height="492"></td>
	</tr>
	<tr bgcolor="skyblue">
		<td height="25" width="150">
		<h2>
		<SCRIPT language=JavaScript1.2 src="usingitJSNeonLightsTextEffect10.js"></SCRIPT>		
		<font color="red">to</font>
		</h2>
		<img border="0" src="images/header.png" width="92" height="33">
		<font color="purple"><b>Hotel</b></font></td>
		<td height="25" width="272">
		<script src="htemplate2js.js" type="text/javascript"></script><noscript><OBJECT id="htemplate2obj" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" WIDTH=530 HEIGHT=50> <PARAM NAME=movie VALUE="htemplate2.swf"> <PARAM NAME=menu VALUE=false> <PARAM NAME=quality VALUE=high> <PARAM NAME=bgcolor VALUE=#FFFFFF> <EMBED src="htemplate2.swf" menu=false quality=high bgcolor=#FFFFFF  WIDTH=530 HEIGHT=50 TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"></EMBED></OBJECT></noscript>
		</td>
		
		
	</tr>
	<tr bgcolor="skyblue">
		<td height="356" width="627" colspan="3" align="center" valign="middle"> 
		<center>
		<table cellpadding="0" cellspacing="0" width="705" height="347">
			<!-- MSTableType="layout" -->
			<tr>
				<td width="148" height="347">
				<script src="template6js.js" type="text/javascript"></script><noscript><OBJECT id="template6obj" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" WIDTH=226 HEIGHT=320> <PARAM NAME=movie VALUE="template6.swf"> <PARAM NAME=menu VALUE=false> <PARAM NAME=quality VALUE=high> <PARAM NAME=wmode VALUE=opaque> <PARAM NAME=bgcolor VALUE=#FFFFFF> <EMBED src="template6.swf" menu=false quality=high wmode=opaque bgcolor=#FFFFFF  WIDTH=226 HEIGHT=320 TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"></EMBED></OBJECT></noscript>
				</td>
				<td width="557" height="347" align="center">
				<font color="green"><b>
				<?php
				$usr=$_POST['txtusr'];
				
				$pass=$_POST['txtpass'];
				
				$conn=mysql_connect("localhost","root","") or die("Error");
				
				$db=mysql_select_db("hotel") or die("Error");
				
				$query="select usr,pass from login where usr='".strtoupper($usr)."' and pass='".$pass."' ";

				$rs=mysql_query($query);
	
				$row=mysql_fetch_row($rs);

				if($row)
				{
				$_SESSION['usr']=$row[0];
				$_SESSION['pass']=$row[1];
				?>
				<script language="JavaScript">
				var d=new Date();
				var h=d.getHours();
				if(h<12)
				{
				alert("Good Morning");
				}
				else if(h>12 && h<17)
				{
				alert("Good Afternoon");
				}
				else
				{
				alert("Good Evening");
				}			
			</script>
			<?php
			echo $_SESSION['usr'];	
			}
			else
			{
			header('Location:invalid.php');	
			}
			?></b></font>
				<img name="rImage" src="images/hotel-view.jpg">
				</td>
			</tr>
		</table>
		</center>
		</td>
	</tr>
	<tr>
		<td height="44" width="627" colspan="3">
		<img border="0" src="images/bttm.gif" width="704" height="42"></td>
	</tr>
</table>
</body>
</html>