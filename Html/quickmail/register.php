<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<HTML>
<HEAD>
		
<SCRIPT LANGUAGE="JavaScript">
<!-- Original:  Robert Bui (astrogate@hotmail.com) -->
<!-- Web Site:  http://astrogate.virtualave.net -->
<!-- Begin
var interval =60; // delay between rotating images (in seconds)
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

<script language="javascript">

function checklogin()
{
  var err="";
  var name=document.form.txtname.value;
  var pass=document.form.txtpass.value;
  var vpass=document.form.txtvpass.value;
  
  if(document.getElementById("txtname").value=="")
  { err +="\nName field cannot be blank .\t\n";}
  
  if(name.length<=1 || !isNaN(name))
  { err +="\nPlease enter a valid name .\t\n";}
 
   if(document.getElementById("txtuid").value=="")
  { err +="\nUser Id cannot be blank.\t\n";}   
  
     if(document.getElementById("txtpass").value=="")
  { err +="\nPassword cannot be blank.\t\n";}   
  
  if(pass.length<6)
  { err +="\nPassword must be minimum 6 characters long .\t\n";}
  
     if(document.getElementById("txtvpass").value=="")
  { err +="\nVerify password field cannot be blank.\t\n";}   
  
  
  if(vpass!=pass)
  { err +="\nPassword typed does not match .\t\n";}
  
     if(document.getElementById("security").value=="")
  { err +="\nYou must select the security question.\t\n";}   
  
 
       if(document.getElementById("txtans").value=="")
  { err +="\nPlease write answer for the security question.\t\n";}   
  
        if(document.getElementById("emailid").value=="")
  { err +="\nPlease provide an alternate Email ID\t\n";}   
   
       if(document.getElementById("month").value=="")
  { err +="\nSelect your month of birth.\t\n";}   
  
         if(document.getElementById("date1").value=="")
  { err +="\nSelect your day of birth.\t\n";}   
  
         if(document.getElementById("year").value=="")
  { err +="\nSelect your year of birth.\t\n";}   
  
         if(document.getElementById("gender").value=="")
  { err +="\nSelect your gender.\t\n";}   
  
         if(document.getElementById("country").value=="")
  { err +="\nSelect your country.\t\n";}   
  
         if(document.getElementById("verify").value=="")
  { err +="\nEnter the verification text(Captcha).\t\n";}   
  
   
  	 if(err=="")
  { return true;}
  else
  { alert(err) 
   return false;
   }
  
}

</script>

<script language="javascript">
function echeck()
{
 if(document.form.emailid.value=="")
	{
		alert("Please Enter a valid E-mail Address");
		document.form.emailid.focus();
		return false;
	}
	//E-mail field should accept valid characters only.
	if (document.form.emailid.value != " ")
	{
		var checkOK="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-@._";
		var checkStr = document.form.emailid.value;
		var allValid = 'true';
		for (i = 0;  i < checkStr.length+1;  i++)
		{

		ch = checkStr.charAt(i);
			for (j = 0;  j < checkOK.length+1;  j++)
			{
				if (ch == checkOK.charAt(j))
				break;
				if (j == checkOK.length)
				{
					allValid = 'false';
					break;
				}
			}
		}
	}
	//E-mail id must have '@'
	if(document.form.emailid.value != "")
	{
		var val=document.form.emailid.value ;
		var pass1=val.indexOf('@',0);
		if(pass1==-1)
		{
			alert("Not a valid E-Mail Address");
			document.form.emailid.value="";
			document.form.emailid.focus();
			return false;
		}
	}
	//E-mail id must have '.'
	if(document.form.emailid.value != "")
	{
		var val=document.form.emailid.value ;
		var pass2=val.indexOf('.',0);
		if(pass2==-1)
		{
			alert("Not a valid E-Mail Address");
			document.form.emailid.value="";
			document.form.emailid.focus();
			return false;
		}
		if((pass2 - pass1)== 1)
		{
			alert("Not a valid E-Mail Address");
			document.form.emailid.value="";
			document.form.emailid.focus();
			return false;
		}
	}
	//E-mail id should have only @,.,_ and - with the letters and digits
	if (!allValid)
	{
		alert("Please enter only letters, digits,and \"@\"  \"_\"  \".\"  \"-\"  characters in the \"EMail\" field.");
		document.form.emailid.focus();
		return false;
	}
	var valid=true;
	if(document.form.agree.value=="")
	{
	valid=false;
	}
	if(!valid)
			alert("You Must be agreed upon the terms and conditions");
	return valid;			
}
</script>


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
function FP_swapImg() {//v1.0
 var doc=document,args=arguments,elm,n; doc.$imgSwaps=new Array(); for(n=2; n<args.length;
 n+=2) { elm=FP_getObjectByID(args[n]); if(elm) { doc.$imgSwaps[doc.$imgSwaps.length]=elm;
 elm.$src=elm.src; elm.src=args[n+1]; } }
}

function FP_preloadImgs() {//v1.0
 var d=document,a=arguments; if(!d.FP_imgs) d.FP_imgs=new Array();
 for(var i=0; i<a.length; i++) { d.FP_imgs[i]=new Image; d.FP_imgs[i].src=a[i]; }
}

function FP_getObjectByID(id,o) {//v1.0
 var c,el,els,f,m,n; if(!o)o=document; if(o.getElementById) el=o.getElementById(id);
 else if(o.layers) c=o.layers; else if(o.all) el=o.all[id]; if(el) return el;
 if(o.id==id || o.name==id) return o; if(o.childNodes) c=o.childNodes; if(c)
 for(n=0; n<c.length; n++) { el=FP_getObjectByID(id,c[n]); if(el) return el; }
 f=o.forms; if(f) for(n=0; n<f.length; n++) { els=f[n].elements;
 for(m=0; m<els.length; m++){ el=FP_getObjectByID(id,els[n]); if(el) return el; } }
 return null;
}
-->
</SCRIPT>


</HEAD>
<BODY OnLoad="FP_preloadImgs(/*url*/'button3.jpg', /*url*/'button4.jpg'); rotateImage('rImage')">
<SCRIPT src="preloader.js" type=text/javascript></SCRIPT>
<DIV id=waitDiv 
style="LEFT: 39%; VISIBILITY: hidden; WIDTH: 178px; POSITION: absolute; TOP: 132px; HEIGHT: 99px; BACKGROUND-COLOR: #ffffff; TEXT-ALIGN: center">
<TABLE style="BORDER-COLLAPSE: collapse" borderColor=#4269c0 height="101%" 
cellSpacing=0 cellPadding=0 width="100%" border=2 >
  <TBODY>
  <TR>
    <TD width="99%" bgColor=#ffffff>
      <TABLE cellPadding=6 width=216 border=0>
        <TBODY>
        <TR>
          <TD dir=ltr vAlign=top align=middle width=200><FONT 
            style="FONT-SIZE: 8pt" face=Tahoma><IMG height=16 
            src="images/l.gif" width=16 border=0> 
            <FONT color="#0055bb" face="Verdana, Arial, Helvetica">&nbsp;<b>Register Once Stay Forever....</b>
            <P><IMG height=15 src="images/loading5.gif" 
            width=200 border=0> 
            <P><FONT style="FONT-WEIGHT: 700; FONT-SIZE: 8pt" face="Verdana, Arial, Helvetica" color="red">Loading......
  </FONT></P></FONT></FONT></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></DIV>
<SCRIPT>ap_showWaitMessage('waitDiv', 3); </SCRIPT>

<FORM  name=form  action="http:\\localhost\quickmail\registeration.php" method="post" onsubmit="return echeck(this)">

<table border="0" width="786" height="622" align="center">
	<tr>
		<td height="616" width="786">
		<fieldset style="background-image:url('images/bg1.jpg')">
		<table border="0" width="886" height="625" align="center">
	<tr>
		<td height="80" width="258" valign="middle" align="center">
		<img border="0" src="images/4-p2.jpg" width="48" height="31"><img border="0" src="images/zapakemail_logo.gif" width="98" height="32"></td>
		<td height="80" width="511" valign="middle" align="center">
		
		<img border="0" src="images/regitser.bmp"></td>
		<td height="80" width="4" valign="middle" align="center">
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
		<td height="27" width="880" valign="top" align="center" colspan="3">
		<fieldset style="background-image:url('images/bg1.jpg')">
		<table cellpadding="0" cellspacing="0" width="866" height="36">
			<!-- MSTableType="layout" -->
			<tr>
				<td width="264">
				<FONT face=Verdana color=#e30102 size=-2>
				 All the fields are Compulsory.
				</FONT>
				</td>
				<td width="333">
				<FONT face=Verdana color=#e30102>
				<b>
				Register Once, Stay Forever.....
				</b>
				</FONT>
				</td>
				<td width="269" height="36" align="right">
				<a href="index.htm"><img border="0" src="images/already_member1.gif" width="224" height="26">
				</a>
				</td>
			</tr>
		</table>
		</fieldset>
		</td>
	</tr>
	
	<tr>
		<td height="495" width="880" valign="top" align="center" colspan="3">
		<fieldset style="background-image:url('images/bg1.jpg')">
		<table cellpadding="0" cellspacing="0" width="688" height="493">
			<!-- MSTableType="layout" -->
			<tr>
				<td>
				<label for=name><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Name  </FONT></label>
				</td>
				<td><b>:</b></td>
				<td colspan="2">
				<input id=txtname type="text" name="txtname"><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				e.g. Amit</FONT>

	</td>
			<td height="36"></td>
			</tr>
			<tr>
				<td><label for="txtuid"><FONT face=Verdana color=#e30102 size=-2>
				*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Choose your ID  </FONT></label>
				</td>
				<td><b>:</b></td>
				<td colspan="2"><input id="txtuid" type="text" name="txtuid"><FONT face="Verdana, Arial, Helvetica" color=#000000 size=-2>
				@Quickmail.com</font><a onClick="return popup(this, 'availability')" href="availability.html"><img border="0" id="img1" src="button2.jpg" height="25" width="124" alt="Check Availability" onmouseover="FP_swapImg(1,0,/*id*/'img1',/*url*/'button3.jpg')" onmouseout="FP_swapImg(0,0,/*id*/'img1',/*url*/'button2.jpg')" onmousedown="FP_swapImg(1,0,/*id*/'img1',/*url*/'button4.jpg')" onmouseup="FP_swapImg(0,0,/*id*/'img1',/*url*/'button3.jpg')" fp-style="fp-btn: Corporate 5" fp-title="Check Availability"></a>
				</td>
				<td height="38"></td>
			</tr>
			<tr>
				<td><label for=password><FONT face=Verdana color=#e30102 size=-2>
				*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Choose Password  </FONT></label>
				</td>
				<td><b>:</b></td>
				<td colspan="2"><input id="txtpass" type="password" name="txtpass">
				<FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Minimum 6 Characters.</FONT>
				</td>
				<td height="38"></td>
			</tr>
			<tr>
				<td><label for=vpassword><FONT face=Verdana color=#e30102 size=-2>
				*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Verify your Password  </FONT></label>
				</td>
				<td><b>:</b></td>
				<td colspan="2"><input id=txtvpass type="password" name="txtvpass">
				</td>
				<td height="38"></td>
			</tr>
			<tr>
				<td><label for=security><FONT face=Verdana color=#e30102 size=-2>
				*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Security Question  </FONT></label></td>
				<td><b>:</b></td>
				<td colspan="2">
				<select id=security name="security">
				<OPTION value="" selected>Please Select</OPTION>>
				<option value="spouse">Where do you meet your spouse ?</option>
				<option value="fschool">Where was the name of your first school 
				?</option>
				<option value="hero">Who was your childhood hero ?</option>
				<option value="ptime">What is your favorite pass time ?</option>
				<option value="fteam">What is your favorite sports team ?</option>
				<option value="father">What is your father's middle name ?</option>
				<option value="pet">What is your pet's name ?</option>
				</select>

				</td>
				<td height="31"></td>
			</tr>
			<tr>
				<td><label for=answer><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Your Answer  </FONT></label></td>
				<td><b>:</b></td>
				<td colspan="2"><input type="text" name="txtans"></td>
				<td height="37"></td>
			</tr>
			<tr>
				<td><label for=answer><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Other Email ID  </FONT></label></td>
				<td><b>:</b></td>
				<td colspan="2"><input type="text" name="emailid" alt="Used to send your account info if you forget your password" onchage="uservalidate()"> 
				
				</td>
				<td height="32"></td>
			</tr>
			<tr>
				<td rowspan="2"><label><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Date Of Birth  </FONT></label></td>
				<td height="1"></td>
				<td rowspan="2" colspan="3">
				 <select name="month" id="month" size="1">
                   <OPTION value="" selected>Month</OPTION>
                    <option value="1">January</option>
                    <option value="2">February</option>
                    <option value="3">March</option>
                    <option value="4">April</option>
                    <option value="5">May</option>
                    <option value="6">June</option>
                    <option value="7">July</option>
                    <option value="8">August</option>
                    <option value="9">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                  </select>
				<select name="date1" id="date1" size="1">
				  <OPTION value="" selected>Day</OPTION>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                  <option value="6">6</option>
                  <option value="7">7</option>
                  <option value="8">8</option>
                  <option value="9">9</option>
                  <option value="10">10</option>
                  <option value="11">11</option>
                  <option value="12">12</option>
                  <option value="13">13</option>
                  <option value="14">14</option>
                  <option value="15">15</option>
                  <option value="16">16</option>
                  <option value="17">17</option>
                  <option value="18">18</option>
                  <option value="19">19</option>
                  <option value="20">20</option>
                  <option value="21">21</option>
                  <option value="22">22</option>
                  <option value="23">23</option>
                  <option value="24">24</option>
                  <option value="25">25</option>
                  <option value="26">26</option>
                  <option value="27">27</option>
                  <option value="28">28</option>
                  <option value="29">29</option>
                  <option value="30">30</option>
                  <option value="31">31</option>
                </select>
                 
                  <select name="year" id="year" size="1">
                   <OPTION value="" selected>Year</OPTION>
					<option value="1970">1961</option>
					<option value="1970">1962</option>
					<option value="1970">1963</option>
					<option value="1970">1964</option>
					<option value="1970">1965</option>
					<option value="1970">1966</option>
					<option value="1970">1967</option>
					<option value="1970">1968</option>
					<option value="1970">1969</option>
                    <option value="1970">1970</option>
                    <option value="1971">1971</option>
                    <option value="1972">1972</option>
                    <option value="1973">1973</option>
                    <option value="1974">1974</option>
                    <option value="1975">1975</option>
                    <option value="1976">1976</option>
                    <option value="1977">1977</option>
                    <option value="1978">1978</option>
                    <option value="1979">1979</option>
                    <option value="1980">1980</option>
                    <option value="1981">1981</option>
                    <option value="1982">1982</option>
                    <option value="1983">1983</option>
                    <option value="1984">1984</option>
                    <option value="1985">1985</option>
                    <option value="1986">1986</option>
                    <option value="1987">1987</option>
                    <option value="1988">1988</option>
                    <option value="1989">1989</option>
                    <option value="1990">1990</option>
                    <option value="1991">1991</option>
                    <option value="1992">1992</option>
                    <option value="1993">1993</option>
                    <option value="1994">1994</option>
                    <option value="1995">1995</option>
                    <option value="1996">1996</option>
                    <option value="1997">1997</option>
                    <option value="1998">1998</option>
                    <option value="1999">1999</option>
                    <option value="2000">2000</option>
                  </select>
                  				
				</td>
			</tr>
			<tr>
				<td height="34"><b>:</b></td>
				</tr>
			<tr>
				<td rowspan="2"><label for=gender><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Gender  </FONT></label>
				</td>
				<td></td>
				<td rowspan="2" colspan="2">
				<select name="gender" id="gender">
				<OPTION value="" selected>Select</OPTION>
				<option value="male">Male</option>
				<option value="female">Female</option>
				</select>
			</td>
				<td height="1"></td>
			</tr>
			<tr>
				<td><b>:</b></td>
				<td height="37"></td>
			</tr>
			<tr>
				<td><label for=country><FONT face=Verdana color=#e30102 size=-2>
				*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Country  </FONT></label>
			</td>
				<td rowspan="2"><b>:</b></td>
				<td colspan="2"><select name="country">
				<OPTION value="" selected>Select</OPTION>
				<option value="India">India</option>
				<option value="United States">United States</option>
				<option value="United Kingdom">United Kingdom</option>
				<option value="Canada">Canada</option>
				<option value="Singapore">Singapore</option>
				<option value="Malaysia">Malaysia</option>
				<option value="Australia">Australia</option>
				<option value="South Africa">South Africa</option>
				</select>
			</td>
				<td height="39"></td>
			</tr>
			<tr>
				<td rowspan="2"><label><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Verify Your Registration  </FONT></label>
			</td>
				<td valign="middle" rowspan="2" colspan="2">
				<input type="text" name="verify" size="14"> 
					<img name="rImage" src="images/email/43535.gif" width=155 height=31>
				</td>
				<td height="1"></td>
			</tr>
			<tr>
				<td><b>:</b></td>
				<td height="38"></td>
			</tr>
			<tr>
				<td colspan="4"  valign="middle" align="center">
			   	<input type="checkbox" checked name="agree">&nbsp;&nbsp;
			   	<FONT face="Verdana, Arial, Helvetica" color=red size="-1">I agree to the Terms of use and Privacy Policy 
				</FONT>
				</td>
				<td height="49"></td>
			</tr>
			<tr>
				<td colspan="3" align="center" valign="middle">
				<input type="image" src="images/submit.gif" name="I1" onclick="return checklogin();">
				</td>
				<td>&nbsp;</td>
				<td height="42"></td>
			</tr>
			<tr>
				<td width="306"></td>
				<td width="10"></td>
				<td width="358"></td>
				<td width="12"></td>
				<td height="1" width="2"></td>
			</tr>

		</table>
		</fieldset>
					<br>
					<img src="images/separator_dotted.gif" width="467" height="1"><br>
					<a href="index.htm"><FONT face="Verdana, Arial, Helvetica" size="-1">Home</FONT></a> &nbsp;|
					<a href="aboutus.htm"><FONT face="Verdana, Arial, Helvetica" size="-1">About Us</FONT></a> &nbsp;|
					<a href="contactus.htm"><FONT face="Verdana, Arial, Helvetica" size="-1">Contact Us</FONT></a> &nbsp;|
					<a href="pp.htm"><FONT face="Verdana, Arial, Helvetica" size="-1">Private Policy</FONT></a> &nbsp;|
					<a href="tou.htm"><FONT face="Verdana, Arial, Helvetica" size="-1">Terms Of Use</FONT></a>
					<br><br>
					<FONT face="Verdana, Arial, Helvetica" size="-1">
					copyright @Quickmail.com 2008.All Rights Reserved</FONT> 
		</td>
	</tr>
	</table>
	</fieldset>
	</td>
	</tr>

</table>
<SCRIPT type=text/javascript>

var t=setTimeout("ap_showWaitMessage('waitDiv', 0);",5000)

</SCRIPT>
</FORM>

</BODY>
</HTML>