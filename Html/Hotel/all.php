<?php session_start(); ?>
<html>
<head>
<title>Welcome To Aniket's Hotel</title>

</head>
<body >

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
		<img border="0" src="images/header.gif" width="103" height="27">
		<font color="purple"><b>Hotel</b></font></td>
		<td height="25" width="272">
		<script src="htemplate2js.js" type="text/javascript"></script><noscript><OBJECT id="htemplate2obj" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" WIDTH=530 HEIGHT=50> <PARAM NAME=movie VALUE="htemplate2.swf"> <PARAM NAME=menu VALUE=false> <PARAM NAME=quality VALUE=high> <PARAM NAME=bgcolor VALUE=#FFFFFF> <EMBED src="htemplate2.swf" menu=false quality=high bgcolor=#FFFFFF  WIDTH=530 HEIGHT=50 TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"></EMBED></OBJECT></noscript>
		</td>
	</tr>
	
	<tr>
		<td height="356" width="627" colspan="3" align="center" valign="middle"> 
		<center>
		<table cellpadding="0" cellspacing="0" width="705" height="373">
			<!-- MSTableType="layout" -->
			<tr>
				<td width="144">
				<script src="template6js.js" type="text/javascript"></script><noscript><OBJECT id="template6obj" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" WIDTH=226 HEIGHT=320> <PARAM NAME=movie VALUE="template6.swf"> <PARAM NAME=menu VALUE=false> <PARAM NAME=quality VALUE=high> <PARAM NAME=wmode VALUE=opaque> <PARAM NAME=bgcolor VALUE=#FFFFFF> <EMBED src="template6.swf" menu=false quality=high wmode=opaque bgcolor=#FFFFFF  WIDTH=226 HEIGHT=320 TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"></EMBED></OBJECT></noscript>
				</td>
				<td width="561" height="373" align="center">
				<fieldset style="background-image:url('images/bg1.jpg')">
				<table cellpadding="0" cellspacing="0" width="467" height="371">
					<!-- MSTableType="layout" -->
					<tr>
					<td width="467" height="371" valign="top">
				<FONT face="Verdana, Arial, Helvetica" size=-1 color=green><b>
					<?php
					$conn=mysql_connect("localhost","root","") or die("Error");
					
					$db=mysql_select_db("hotel") or die("Error");
					
					$query="select * from record order by rno";
					
					$rs=mysql_query($query) or die("ERROR:Query Not Executed");
					
					echo "<table border=1 bordercolor='red' align='center' width=100% height=45%>";
					echo "<tr>";
					echo "<td align=center ><b><FONT face=Verdana, Arial, Helvetica size=-1 color=green>Room No</font></td>";
					echo "<td align=center ><b><FONT face=Verdana, Arial, Helvetica size=-1 color=green>Name</font></td>";
					echo "<td align=center><b><FONT face=Verdana, Arial, Helvetica size=-1 color=green>Address</font></td>";
					echo "<td align=center><b><FONT face=Verdana, Arial, Helvetica size=-1 color=green>City</font></td>";
					echo "<td align=center><b><FONT face=Verdana, Arial, Helvetica size=-1 color=green>Contact</font></td>";
					echo "<td align=center><b><FONT face=Verdana, Arial, Helvetica size=-1 color=green>Date</font></td>";	
					echo "</tr>";
					while($row=mysql_fetch_array($rs))
					{
					echo "<tr>";
					echo "<td align=center>"."<FONT face=Verdana, Arial, Helvetica size=-1 color=blue>".$row["rno"]."</font></td>";
					echo "<td align=center>"."<FONT face=Verdana, Arial, Helvetica size=-1 color=blue>".$row["fname"]."</font></td>";
					echo "<td align=center>"."<FONT face=Verdana, Arial, Helvetica size=-1 color=blue>".$row["addr"]."</td>";
					echo "<td align=center>"."<FONT face=Verdana, Arial, Helvetica size=-1 color=blue>".$row["city"]."</td>";
					echo "<td align=center>"."<FONT face=Verdana, Arial, Helvetica size=-1 color=blue>".$row["contact"]."</td>";
					echo "<td align=center>"."<FONT face=Verdana, Arial, Helvetica size=-1 color=blue>".$row["day"]."/".$row["month"]."/".$row["year"]."</td>";
					echo "</tr>";
					}
					echo "</table>";
					?></b>
					</FONT> 
					</td>
					</tr>
				</table>
				</fieldset>
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