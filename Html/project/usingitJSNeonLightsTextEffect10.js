/*---------------------------------------------------------------------------

JavaScript NeonLights Text Effect for Web Designers Toolkit
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

var neonMessage="***  Welcome To World Of Projects  ***";	//Message you want to display with special effect.
var textColor="green";			//The original color of the message.
var neonColorBrighter="blue";		//The brighter color the special effect will use.
var neonColorDarker="red";			//The darker color the special effect will use.
var neonFlashLetterBrighter=4;			//The count of the letter that will be displayed by using brighter color.
var neonFlashLetterDarker=3;			//The count of the letter that will be displayed by using darker color.
var neonFlashSpeed=30;				//The speed of the animation in millisecond, lower is faster.
var neonFlashDelay=0;				//How long to wait for each move, lower is faster. 0 is no stopping.

//**************************************************************
//DO NOT CHANGE ANYTHING BELOW.
//**************************************************************

var charPos=0;
if (document.all||document.getElementById){
	document.write('<font color="'+textColor+'">');
	for (i=0;i<neonMessage.length;i++)
		document.write('<span id="NEONLIGHTS'+i+'">'+neonMessage.charAt(i)+'</span>');
	document.write('</font>');
}
else
	document.write(neonMessage);

function neon(){
	if (charPos==0){
		for (i=0;i<neonMessage.length;i++)
			getCharByIndex(i).style.color=textColor;
	}

	getCharByIndex(charPos).style.color=neonColorBrighter;

	if (charPos>neonFlashLetterBrighter-1)
		getCharByIndex(charPos-neonFlashLetterBrighter).style.color=neonColorDarker; 
	if (charPos>(neonFlashLetterBrighter+neonFlashLetterDarker)-1)
		getCharByIndex(charPos-neonFlashLetterBrighter-neonFlashLetterDarker).style.color=textColor;

	if (charPos<neonMessage.length-1)
		charPos++;
	else{
		charPos=0;
		clearInterval(timerNeon);
		setTimeout("doNeon()",neonFlashDelay);
		return;
	}
};

function doNeon(){
	if (document.all||document.getElementById)
		timerNeon=setInterval("neon()",neonFlashSpeed);
};

function getCharByIndex(index){
	var oNeonChar=document.all?eval("document.all.NEONLIGHTS"+index):document.getElementById("NEONLIGHTS"+index);
	return oNeonChar;
};

doNeon();