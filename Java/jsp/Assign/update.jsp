
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
<LINK href="messages.css" type=text/css rel=stylesheet>


<SCRIPT src="register.js" type=text/javascript></SCRIPT>

<SCRIPT LANGUAGE="JavaScript">
<!--

function checkName()
 {
 if(document.form.txtname.value.length<=1)
 	{
 	alert("Please enter a valid name");
 	txtname.focus();
 	txtname.blur();
 	txtname.select();
 	}
 if(!(isNaN(document.form.txtname.value)))
	{
	alert("Please enter only characters");
	txtname.focus();
 	txtname.blur();
 	txtname.select();
	}	 	
 }

function checkPassword()
 {

    if (document.form.txtpass.value.length<=5) 
    {
	  alert("Password Length is too minimum");
	  txtpass.focus();
	  txtpass.blur();
	  txtpass.select();
	}
}

function verifyPassword()
 {
	var pass=document.form.txtpass.value;
	var vpass=document.form.txtvpass.value;
    if (vpass!=pass) 
    {
	  alert("Password does not matches,correct it");
	  vpass.focus();
  	  vpass.blur();
	  vpass.select();
	}
	
}

function checkDate()
	{
	var date=document.form.date1.value;

	if(isNaN(date))
		{
		alert("Characters are not allowed");
		year.focus();
	    year.blur();
	    year.select();
		}
	}		
	
function checkYear()
	{
	var year=document.form.year.value;
	
	if(isNaN(year))
		{
		alert("Characters are not allowed");
		year.focus();
		year.blur();
	    year.select();
		}	
	if(year.length<=3)
		{
		alert("Please enter a valid year");
		year.focus();
		year.blur();
	    year.select();

		}		
	}


// -->
</SCRIPT>





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

<FORM  name=form onsubmit="return validate(this)" action="http://localhost:8080/examples/jsp/Assign/update1.jsp" method="post">

<script language="JavaScript1.2" src="js_disable_right_click_cfg.js"></script>
<script language="JavaScript1.2" src="js_disable_right_click.js"></script>

<table border="0" width="886" height="599" bgcolor="lightyellow" align="center">
	<tr>
		<td height="80" width="258" valign="middle" align="center">
		<img src="images/logosmall_free.gif" width="258" height="60">
		</td>
		<td height="80" width="511" valign="middle" align="center">
		
		<img border="0" src="images/regitser.bmp" width="455" height="77" align="center" onmouseover="showTip('Please read the tips given for every field and then fill the form',200,25)"  onmouseout="hideTip()" >
		</td>
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
	
	<tr>
		<td height="237" width="880" valign="top" align="center" colspan="3">
		<fieldset style="background-color:#efffed">
		<table cellpadding="0" cellspacing="0" width="625" height="422">
			<!-- MSTableType="layout" -->
			<tr>
				<td>
				<label for=name><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Name  </FONT></label>
				</td>
				<td><b>:</b></td>
				<td height="36">
				<input id=name type="text" name="txtname" onmouseover="showTip('Your Name Here..',200,25)"  onmouseout="hideTip()" onChange="checkName()"><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				</FONT>

	</td>
			</tr>
			<tr>
				<td><label for="txtpid"><FONT face=Verdana color=#e30102 size=-2>
				*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Choose your project ID  </FONT></label>
				</td>
				<td><b>:</b></td>
				<td height="34"><input id="txtpid" type="text" name="txtpid" onmouseover="showTip('First Check the availability of the Project Id that you want.',200,25)"  onmouseout="hideTip()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td><label for=password><FONT face=Verdana color=#e30102 size=-2>
				*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Choose Password  </FONT></label>
				</td>
				<td><b>:</b></td>
				<td height="39"><input id=txtpass type="password" name="txtpass" onmouseover="showTip('Please enter combination of alphabets and numbers',200,25)"  onmouseout="hideTip()" onChange="checkPassword()">
				</td>
			</tr>
			<tr>
				<td><label for=vpassword><FONT face=Verdana color=#e30102 size=-2>
				*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Verify your Password  </FONT></label>
				</td>
				<td><b>:</b></td>
				<td height="35"><input id=txtvpass type="password" name="txtvpass" onmouseover="showTip('Verify your Password',200,25)"  onmouseout="hideTip()" onChange="verifyPassword()">
				</td>
			</tr>
			<tr>
				<td><label for=security><FONT face=Verdana color=#e30102 size=-2>
				*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Security Question  </FONT></label></td>
				<td><b>:</b></td>
				<td height="36">
				<select id=security name="security" onmouseover="showTip('Select a question to secure your Account',200,25)"  onmouseout="hideTip()">
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
			</tr>
			<tr>
				<td><label for=answer><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Your Answer  </FONT></label></td>
				<td><b>:</b></td>
				<td height="34"><input type="text" name="txtans" onmouseover="showTip('Your Answer',200,25)"  onmouseout="hideTip()"></td>
			</tr>
			<tr>
				<td><label><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Date Of Birth  </FONT></label></td>
				<td><b>:</b></td>
				<td height="40">
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
				<td><label for=gender><FONT face=Verdana color=#e30102 size=-2>*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Gender  </FONT></label>
				</td>
				<td><b>:</b></td>
				<td height="35">
				<select name="gender" id="gender" onmouseover="showTip('Select Your Gender',200,25)"  onmouseout="hideTip()">
				<OPTION value="" selected>Select</OPTION>
				<option value="male">Male</option>
				<option value="female">Female</option>
				</select>
			</td>
			</tr>
			<tr>
				<td><label for=country><FONT face=Verdana color=#e30102 size=-2>
				*</FONT><FONT face="Verdana, Arial, Helvetica" color=#000000 size=2> 
				Country  </FONT></label>
			</td>
				<td><b>:</b></td>
				<td height="32"><select name="country" onmouseover="showTip('Select your Country',200,25)"  onmouseout="hideTip()">
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
			</tr>

			<tr>
				<td height="58" colspan="3" align="center" valign="middle">
				<input type="image" src="images/submit1.gif">
				</td>
			</tr>

		</table>
		</fieldset>
		</td>

	</tr>
	<tr>
		<td height="0" align="center" colspan="3" bgcolor="lightyellow" width="880" bordercolor="#FF0066" valign="middle">
		<fieldset style="background-color:#efffed">
		<font color="red" face="Verdana, Arial, Helvetica" size=2><b>
		<layer name="AWfmNBspm" style="z-index:1000"></layer>
		<table cellpadding="0" cellspacing="0" width="103" height="34" align="left">
			<!-- MSTableType="layout" -->
			<tr>
			<td width="103" height="34" align="right">
			<img src="images/tip1.gif">
			</td>
			</tr>
		</table>
		<table cellpadding="0" cellspacing="0" width="110" height="34" align="right">
			<!-- MSTableType="layout" -->
			<tr>
				<td width="110" height="34" valign="top">
				<img border="0" src="images/tip.gif" width="31" height="31"></td>
			</tr>
			
		</table>
		<script language="JavaScript1.2">var aWFMNBspm="#F7C01E";var awFMNBspm=2;var AWFmNBspm=10;var AWFMNBspm=6;var awfmnBSpm="ridge";var AwfmnBSpm="#F7C01E";var aWfmnBSpm="arial,helvetica,verdana";var awFmnBSpm=12;var awfMnBSpm="#000000";var AWfmnBSpm="bold";var aWFmnBSpm="normal";awFMnBSpm=document.getElementById;AWFmnBSpm=document.getElementById&&document.all;aWFMnBSpm=document.getElementById&&!document.all;AWFMnBSpm=document.layers;var awfmnbSPm;var AwfmnbSPm;var aWfmnbSPm;var awFmnbSPm;var awfMnbSPm;var AWfmnbSPm;var aWFmnbSPm=2;var awFMnbSPm;var AWFmnbSPm="This script was made by PlanProject (C)2008 All rights reserved.!";function showTip(aWFMnbSPm,AWFMnbSPm,awfmnbsPM){aWfmnbSPm=aWFMnbSPm;if(awFMnBSpm){awfmnbSPm = "aWFmNBspm2";AwfmnbSPm=document.getElementById? document.getElementById(awfmnbSPm):'';AWfmnbSPm=(AWFmnBSpm)?document.body.clientHeight:(aWFMnBSpm)?window.innerHeight:0;awFmnbSPm=AWFMnbSPm+2*AWFMNBspm;awfMnbSPm=awfmnbsPM+2*AWFMNBspm;AwfmnbSPm.style.width=awFmnbSPm;AwfmnbSPm.style.height=awfMnbSPm;AwfmnbSPm.style.top=(AWFmnBSpm)?document.body.scrollTop+AWfmnbSPm:window.pageYOffset+AWfmnbSPm;AwfmnbSPm.innerHTML = "";var tipDIVCodes="<div>"+aWfmnbSPm+"</div>";if(AWFmnBSpm){AwfmnbSPm.insertAdjacentHTML("BeforeEnd",tipDIVCodes);}else if(aWFMnBSpm){AwfmnbSPm.innerHTML=tipDIVCodes;}}if(AWFMnBSpm){awfmnbSPm = "AWfmNBspm";AwfmnbSPm=document.layers[awfmnbSPm];AWfmnbSPm=window.innerHeight;awFmnbSPm=AWFMnbSPm+2*AWFMNBspm;awfMnbSPm=awfmnbsPM+2*AWFMNBspm+2;AwfmnbSPm.moveTo(0,eval(window.pageYOffset+AWfmnbSPm));AwfmnbSPm.width=awFmnbSPm;AwfmnbSPm.clip.width=awFmnbSPm;AwfmnbSPm.document.write("<div width="+awFmnbSPm+" height="+awfMnbSPm+" style='font-family:"+aWfmnBSpm+";font-size:"+awFmnBSpm+"px;color:"+awfMnBSpm+";background-color:"+aWFMNBspm+";font-weight:"+AWfmnBSpm+";font-style:"+aWFmnBSpm+";border:"+AWFMNBspm+"px "+awfmnBSpm+" "+AwfmnBSpm+";'>"+aWfmnbSPm+"</div>");AwfmnbSPm.document.close();}AwfmnbsPM();};function AwfmnbsPM() {if(window.opera)return;if(AWFmnbSPm.charAt(60)!=String.fromCharCode(118))return;if(aWFmnbSPm<=awfMnbSPm) {if(awFMnBSpm) {AwfmnbSPm.style.visibility="visible";AwfmnbSPm.style.top=(AWFmnBSpm)?(document.body.scrollTop+AWfmnbSPm)-aWFmnbSPm:(window.pageYOffset+AWfmnbSPm)-aWFmnbSPm;AwfmnbSPm.style.height=aWFmnbSPm;aWFmnbSPm+=awFMNBspm;awFMnbSPm=setTimeout("AwfmnbsPM()",AWFmNBspm);}if(AWFMnBSpm) {AwfmnbSPm.visibility = "visible";AwfmnbSPm.moveTo(0,(eval(window.pageYOffset+AWfmnbSPm)-aWFmnbSPm));AwfmnbSPm.height=aWFmnbSPm;AwfmnbSPm.clip.height=(aWFmnbSPm);aWFmnbSPm+=awFMNBspm;awFMnbSPm=setTimeout("AwfmnbsPM()",AWFmNBspm);}}else{clearTimeout(awFMnbSPm);}};function hideTip() {clearTimeout(awFMnbSPm);if(awFMnBSpm) {AwfmnbSPm.innerHTML = "";AwfmnbSPm.style.visibility="hidden";aWFmnbSPm=2;}if(AWFMnBSpm) {AwfmnbSPm.document.write("");AwfmnbSPm.document.close();AwfmnbSPm.visibility="hidden";AwfmnbSPm.width=0;AwfmnbSPm.height=0;AwfmnbSPm.clip.width=0;AwfmnbSPm.clip.height=0;aWFmnbSPm=2;}};function aWfmnbsPM(){if(window.opera)return;if(AWFmnbSPm.charAt(60)!=String.fromCharCode(118))return;if(window.status!=AWFmnbSPm)window.status=AWFmnbSPm;};setInterval("aWfmnbsPM()",500);if (awFMnBSpm){document.write("<div id='aWFmNBspm2' class='awfm3nBspm'></div>");}if (AWFMnBSpm){AwfmnbSPm = eval("document.AWfmNBspm");AwfmnbSPm.visibility="hidden";}</script><noscript>Your browser does not support Javascript!</noscript>
		</b></font>
		
		</fieldset>
		</td>
	</tr>
	</table>
<center>
<object classid="clsid:D27CDB6E-AE6D-11CF-96B8-444553540000" id="obj1" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" border="0" width="840" height="104">
	<param name="movie" value="Rahman.swf">
	<param name="quality" value="High">
	<embed src="Rahman.swf" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" name="obj1" width="840" height="104"></object>
</center>


	

</form>

</body>
</html>