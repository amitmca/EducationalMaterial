/*---------------------------------------------------------------------------

JavaScript WipeOut Text Effect for Web Designers Toolkit
(C)1999-2004 USINGIT.COM, All Rights Reserved.
To get more ideas, solutions, free and professional scripts, visit:
http://www.usingit.com/
http://www.usingit.com/products/webtoolkit
email: support@usingit.com

This script can be used freely for commercial and non-commercial sites only if 
you don't alert the copyright info here! 

-----------------------------------------------------------------------------*/

//**************************************************************
//Set the parameters below to make this script to fit your need.
//**************************************************************

var fgColor="#272727"; //The foreground color of the text
var bgColor="#999999"; //The background color of the text
var aniSpeed=100; //The speed of the animation in millisecond, lower is faster.
var aniDelay=25; //How long to wait for each wipe, lower is faster. 0 is no stopping.

var FontName="Arial"; //The family name of the font. Such as Ms Sans Serif,Georgia,Helvetica,Arial;
var FontSize=11; //Font size of the text
var FontWeight="bold"; //Bold or Normal
var FontStyle="normal"; //Italic or Normal
var onLoadEventHandler=""; //The names of the other functions that you need to call in body's onload event.
                           //This script will override the onload event handler of this web page and some 
                           //other scripts may not work if they also need to use onLoad event handler. Put
                           //those scripts's onload event handler here will solve this problem.
                           //for example, set it to "document.bgColor='red';" will change the background
                           //color of the document to red.

//**************************************************************
//DO NOT CHANGE ANYTHING BELOW.
//**************************************************************

var DOM=document.getElementById;
var wipeText;
var wipeCount=0;
window.onload=onLoad_WipeOut;
if(onLoadEventHandler!=""){eval(onLoadEventHandler);}


function onLoad_WipeOut(){
	if(DOM){
		var loWiper=document.getElementById("WIPEOUTTEXT");
		wipeText=loWiper.firstChild.nodeValue;
		while(loWiper.childNodes.length){loWiper.removeChild(loWiper.childNodes[0]);}
		for(var i=0;i<wipeText.length;i++){
			var lobj=document.createElement("span");
			lobj.setAttribute("id","WIPECHAR"+i);
			lobj.appendChild(document.createTextNode(wipeText.charAt(i)));
			lobj.style.fontFamily=FontName;
			lobj.style.fontSize=FontSize;
			lobj.style.fontWeight=FontWeight;
			lobj.style.fontStyle=FontStyle;
			lobj.style.color=bgColor;
			loWiper.appendChild(lobj);
		}
		setInterval("doAni()",aniSpeed);
	}
};

function doAni(){
	if(wipeCount==0)	{
		for(var i=0;i<wipeText.length;i++){
			document.getElementById("WIPECHAR"+i).style.color=bgColor;
		}
	}
	else{
		if(wipeCount<=wipeText.length){
			document.getElementById("WIPECHAR"+(wipeCount-1)).style.color=fgColor;
		}
	}
	wipeCount=(wipeCount+1)%(wipeText.length+aniDelay);
};
