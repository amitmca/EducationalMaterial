
<?php
       session_start();
       ?>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>You have successfully Logged Out</title>
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
function blinkit(){
intrvl=0;
for(nTimes=0;nTimes<8;nTimes++){
intrvl += 500;
setTimeout("document.bgColor='lightyellow';",intrvl);
intrvl += 500;
setTimeout("document.bgColor='#efffed';",intrvl);
   }
}
// End -->
</SCRIPT>
<style type="text/css">
.t22gr {
	FONT: 22px verdana; COLOR: #77c805
}
</style>
<script language="JavaScript">
<!--
function FP_preloadImgs() {//v1.0
 var d=document,a=arguments; if(!d.FP_imgs) d.FP_imgs=new Array();
 for(var i=0; i<a.length; i++) { d.FP_imgs[i]=new Image; d.FP_imgs[i].src=a[i]; }
}

function FP_swapImg() {//v1.0
 var doc=document,args=arguments,elm,n; doc.$imgSwaps=new Array(); for(n=2; n<args.length;
 n+=2) { elm=FP_getObjectByID(args[n]); if(elm) { doc.$imgSwaps[doc.$imgSwaps.length]=elm;
 elm.$src=elm.src; elm.src=args[n+1]; } }
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
// -->
</script>

</head>

<BODY onLoad="blinkit()" > 
<?php
	   session_destroy();
	  
?>
<table border="0" width="977" height="89">
	<tr>
		<td height="83" width="971" valign="middle" background="images/stylusstudio_02.gif">
		<img border="0" src="images/logosmall_free.gif" width="271" height="60">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<img border="0" src="images/employee.jpg" width="275" height="75"></td>
	</tr>

</table>
<br><br>
<table border="0" width="977" height="100" align="center">
	<tr>
		<td height="119" width="977">
		<fieldset>
		<img src="images/yes_2.gif">
		<center><P class=t22gr>You have successfully Logged Out </P>
		</center>
		<center>
	
		<a href="index.htm">
		<img border="0" id="img1" src="button2.jpg" height="20" width="100" alt="Login Again" fp-style="fp-btn: Simple Circle 3; fp-font-color-normal: #FF0000" fp-title="Login Again" onmouseover="FP_swapImg(1,0,/*id*/'img1',/*url*/'button3.jpg')" onmouseout="FP_swapImg(0,0,/*id*/'img1',/*url*/'button2.jpg')" onmousedown="FP_swapImg(1,0,/*id*/'img1',/*url*/'button4.jpg')" onmouseup="FP_swapImg(0,0,/*id*/'img1',/*url*/'button3.jpg')"></a></center>
		<br>
		
		</fieldset>
		</td>
	</tr>
	<tr>
	<td align="center">
	<br>
	<object classid="clsid:D27CDB6E-AE6D-11CF-96B8-444553540000" id="obj1" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" border="0" width="959" height="240">
		<param name="movie" value="Idea.swf">
		<param name="quality" value="High">
		<embed src="Idea.swf" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" name="obj1" width="959" height="240"></object>
	<br>
	&nbsp;</td>
	</tr>
</table>
<br><br>
<center>&nbsp;</center>

      
</body>

</html>