<!--[if gte mso 9]>
<xml><o:shapedefaults v:ext="edit" spidmax="1027"/>
</xml><![endif]-->
<font color="red"><h2><center>
<?php
 session_start();
 
 $rno=$_POST['rno'];
 $m=$_POST['month'];
 $d=$_POST['day'];
 $y=$_POST['year'];
 
 
 $conn=mysql_connect("localhost","root","") or die("Error");
 
 $db=mysql_select_db("hotel") or die("Error");
 
 $query="select * from room where rno='$rno'";
					
 $rs=mysql_query($query) or die("ERROR:Query Not Executed");
 
 $row=mysql_fetch_row($rs);
 
 if(!$row)
 	{
 	echo "No Such Room Allocated";
 	?>
 	<a href="http://localhost/Hotel/rec.htm">Go Back</a>
 	<?php
 	}
else 
 {
?>
</center></h2>
 	</font>
<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">
<head>
<title>Welcome To Aniket's Hotel</title>


<!--[if !mso]>
<style>
v\:*         { behavior: url(#default#VML) }
o\:*         { behavior: url(#default#VML) }
.shape       { behavior: url(#default#VML) }
</style>
<![endif]-->
<link rel="File-List" href="receipt_files/filelist.xml">


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
		<img border="0" src="images/header.gif" width="101" height="27">
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
				<center>&nbsp;</center>
				<script src="template6js.js" type="text/javascript"></script><noscript><OBJECT id="template6obj" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" WIDTH=226 HEIGHT=320> <PARAM NAME=movie VALUE="template6.swf"> <PARAM NAME=menu VALUE=false> <PARAM NAME=quality VALUE=high> <PARAM NAME=wmode VALUE=opaque> <PARAM NAME=bgcolor VALUE=#FFFFFF> <EMBED src="template6.swf" menu=false quality=high wmode=opaque bgcolor=#FFFFFF  WIDTH=226 HEIGHT=320 TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"></EMBED></OBJECT></noscript>
				</td>
				<td width="561" height="373" align="center">
				<fieldset style="background-image:url('images/bg1.jpg')">
				<table cellpadding="0" cellspacing="0" width="467" height="371">
					<!-- MSTableType="layout" -->
					<tr>
					<td width="467" height="371" valign="top">
					&nbsp;
					<table cellpadding="0" cellspacing="0" width="467" height="349">
						<!-- MSTableType="layout" -->
						<tr>
							<td height="36" colspan="3" align="center">
							<img border="0" src="images/header.gif" width="113" height="34"></td>
						</tr>
						<tr>
							<td align="center">
							<FONT face="Verdana, Arial, Helvetica"  color=green>
							<b>
							Name
							</b>
							</FONT>
							</td>
							<td align="center"><b>:</b></td>
							<td height="38">
							<FONT face="Verdana, Arial, Helvetica"  color=red>
							<b>
							<?php
							if($row)
								{
								$_SESSION['fname']=$row[1];
								echo $_SESSION['fname'];
								}
							?>
							</b></FONT>
							</td>
						</tr>
						<tr>
							<td align="center">
							<FONT face="Verdana, Arial, Helvetica"  color=green>
							<b>
							Room No
							</b>
							</FONT>
						    </td>
							<td align="center"><b>:</b></td>
							<td height="34">
							<FONT face="Verdana, Arial, Helvetica"  color=red>
							<b>
							<?php
							if($row)
								{
								$_SESSION['rno']=$row[0];
								echo $_SESSION['rno'];
								}
							?>
							</b></FONT>

							</td>
						</tr>
						<tr>
							<td align="center"><FONT face="Verdana, Arial, Helvetica"  color=green>
							<b>
							Arr Date
							</b>
							</FONT></td>
							<td align="center"><b>:</b></td>
							<td height="37">
							<FONT face="Verdana, Arial, Helvetica"  color=red>
							<b>
							<?php
							if($row)
								{
								$_SESSION['month']=$row[6];
								$_SESSION['day']=$row[7];
								$_SESSION['year']=$row[8];
								echo $_SESSION['day']."/".$_SESSION['month']."/".$_SESSION['year'];
								}
							?>
							</b></FONT>

							</td>
						</tr>
						<tr>
							<td align="center">
							<FONT face="Verdana, Arial, Helvetica"  color=green>
							<b>
							Dep Date
							</b>
							</FONT>
							</td>
							<td align="center"><b>:</b></td>
							<td height="29">
							<FONT face="Verdana, Arial, Helvetica"  color=red>
							<b>
							<?php
							echo "$d/$m/$y";
							?>
							</b>
							</FONT>
							</td>
						</tr>
						<tr>
							<td align="center">
							<FONT face="Verdana, Arial, Helvetica"  color=green>
							<b>
							Room Charges							
							</b>
							</FONT>
							</td>
							<td align="center"><b>:</b></td>
							<td height="34">
							<FONT face="Verdana, Arial, Helvetica"  color=red>
							<b>
							<?php
							$ch=1000;
							echo $ch;								
							?>
							</b>
							</FONT>
							</td>
						</tr>
						<tr>
							<td align="center">
							<FONT face="Verdana, Arial, Helvetica"  color=green>
							<b>
							No.Of Days
							</b>
							</FONT>
							</td>
							<td align="center"><b>:</b></td>
							<td height="33">
							<FONT face="Verdana, Arial, Helvetica"  color=red>
							<b>
							<?php
							$n=$d-$_SESSION['day'];
							if($n==0)
								{
								$n=1;
								}
							echo $n;								
							
							?>
							</b>
							</FONT>
							</td>
						</tr>
						<tr>
							<td align="center" style="border:solid black">
							<FONT face="Verdana, Arial, Helvetica"  color=green>
							<b>
							Total Charges
							<?php
							echo "<hr>";
							?>
							</b>
							</FONT>
							</td>
							<td align="center"><b>:</b></td>
							<td height="33" style="border:solid black">
							<FONT face="Verdana, Arial, Helvetica"  color=red>
							<b>
							<?php
							$n=$d-$_SESSION['day'];
							if($n==0)
								{
								$n=1;
								}
							$ch=1000;
										
							$total=$n*$ch;
							echo $total;								
							echo "<hr>";
							
						    $query="delete from hotel.room where rno='$rno'";
					
							$rs=mysql_query($query) or die("ERROR:Query Not Executed");
							}	
							?>
							</b>
							</FONT>
							</td>
						</tr>
						<tr>
							<td width="181">
							<form>
							<input type=button name=print value="Print This page" onClick="javascript:window.print()"> 
							</form>
							</td>
							<td width="30">&nbsp;</td>
							<td height="75" width="256" valign="middle">
							<!--[if gte vml 1]><v:shapetype id="_x0000_t136"
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
</v:shapetype><v:shape id="_x0000_s1025" type="#_x0000_t136" style='width:105pt;
 height:24.75pt' fillcolor="#b2b2b2" strokecolor="#33c" strokeweight="1pt">
 <v:fill opacity=".5"/>
 <v:shadow on="t" color="#99f" offset="3pt"/>
 <v:textpath style='font-family:"Arial Black";font-size:18pt;v-text-kern:t'
  trim="t" fitpath="t" string="Thank You"/>
</v:shape><![endif]--><![if !vml]><img border=0 width=145 height=37
src="receipt_files/image001.gif" alt="Thank You" v:shapes="_x0000_s1025"><![endif]></td>
						</tr>
					</table>
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