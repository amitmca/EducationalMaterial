/*
JavaScript Image Slider Platinum 2.0
(C)1999-2008 Usingit.com, All rights reserved!
http://www.usingit.com/products/webtoolkit
http://www.usingit.com/support
*/
var bAaw=(navigator&&navigator.userAgent)?navigator.userAgent.toLowerCase():'';var bBaw=(navigator&&navigator.appVersion)?navigator.appVersion:'';var bCaw=parseInt(bBaw,10);var bDaw=bAaw.indexOf('opera')!=-1;var bEaw=bDaw&&bCaw==9;var bFaw=bDaw&&bCaw>=9;var bGaw=!bDaw&&(bAaw.indexOf('msie')!=-1);var bHaw=bGaw&&(bAaw.indexOf('mac')!=-1);var bIaw=bAaw.indexOf('safari')!=-1;var bJaw=bIaw&&(bAaw.indexOf('safari/125.')==-1)&&(bAaw.indexOf('safari/85.')==-1);var bKaw=bAaw.indexOf('konqueror')!=-1;var bLaw=!bGaw&&!bDaw&&((bAaw.indexOf('netscape')!=-1)||(bAaw.indexOf('mozilla')!=-1))&&(bCaw>=5);var bMaw=bGaw&&(bCaw<4);var bNaw=bGaw&&(bCaw==4)&&(bAaw.indexOf("msie 4")!=-1);var bOaw=bGaw&&(bCaw==4)&&(bAaw.indexOf("msie 5.5")!=-1);var bPaw=bGaw&&(bCaw==4)&&(bAaw.indexOf("msie 5")!=-1)&&!bOaw;var bQaw=bGaw&&!bMaw&&!bNaw&&!bPaw;var bRaw=bQaw&&(bAaw.indexOf('nt 4')==-1);var bSaw=bGaw&&!bMaw&&!bNaw&&!bPaw&&!bOaw;var bTaw=bSaw;var bUaw=(bAaw.indexOf('netscape6')!=-1);var bVaw=!bKaw&&!bUaw;var bWaw=bQaw;var bXaw=!bHaw;var bYaw=bXaw;var bZaw=bYaw&&!bDaw&&!bIaw;var BAaw=bXaw;var BBaw=!bUaw&&!bHaw;var BCaw={BDaw:function(){return function(){this.BEaw.apply(this,arguments);}}};Object.BFaw=function(BGaw,BHaw){for(var BIaw in BHaw)BGaw[BIaw]=BHaw[BIaw];return BGaw;};Function.prototype.BJaw=function(BKaw){var BLaw=this;return function(){return BLaw.apply(BKaw,arguments);}};if(!Array.prototype.BMaw){Array.prototype.BMaw=function(BNaw,BOaw){for(var BPaw=0;BPaw<this.length;BPaw++)BNaw.call(BOaw,this[BPaw],BPaw);};}Array.prototype.each=Array.prototype.BMaw;String.prototype.BQaw=function(){return this.replace(/-\D/gi,function(BRaw){return BRaw.charAt(BRaw.length-1).toUpperCase();});};var BSaw=function(BTaw){var BUaw=[];for(var BPaw=0;BPaw<BTaw.length;BPaw++)BUaw.push(BTaw[BPaw]);return BUaw;};function BVaw(){if(arguments.length==1)return BWaw(arguments[0]);var BXaw=[];BYaw(arguments).each(function(BZaw){BXaw.push(BWaw(BZaw));});return BXaw;function BWaw(BZaw){if(typeof BZaw=='string')BZaw=document.getElementById(BZaw);return BZaw;}};if(!window.baax)var baax={};Object.BFaw(baax,{bbax:function(bcax){bcax=BVaw(bcax);bcax.parentNode.removeChild(bcax);},bdax:function(bcax,beax){bcax=BVaw(bcax);return!!bcax.className.match(new RegExp("\\b"+beax+"\\b"));},bfax:function(bcax,beax){bcax=BVaw(bcax);if(!baax.bdax(bcax,beax))bcax.className=(bcax.className+' '+beax);},bgax:function(bcax,beax){bcax=BVaw(bcax);if(baax.bdax(bcax,beax))bcax.className=bcax.className.replace(beax,'');}});document.bhax=function(beax){var biax=[];var bjax=document.getElementsByTagName('*');BSaw(bjax).each(function(BZaw){if(baax.bdax(BZaw,beax))biax.push(BZaw);});return biax;};bkax=BCaw.BDaw();bkax.prototype={BEaw:function(blax,bmax){this.bnax=[];this.boax=false;this.bpax=null;this.bqax=null;this.blax=blax;this.brax=bmax;},bsax:function(bpax){if(bpax){this.bpax=bpax}},btax:function(){if(this.bpax){this.bqax=document.createElement('div');this.bqax.className=this.brax;this.bpax.appendChild(this.bqax);}},buax:function(bvax){this.bnax[this.bnax.length]=bvax;},bwax:function(){return this.bnax},bxax:function(){this.bnax=[];},byax:function(bzax){if((this.bnax.length>0)&&(bzax>=this.bnax.length)){if(this.bqax){this.bqax.style.visibility='hidden';}if(this.blax){this.blax();}}else{var Baax=new Image();this.Bbax=bzax;Baax.onload=function(){setTimeout(function(){this.byax(this.Bbax+1);}.BJaw(this),10)}.BJaw(this);Baax.src=this.bnax[bzax];}}};function Bcax(Bdax,Bdax1,Bdax2,Bdax3,Bdax4,Bdax5,Bdax6,Bdax7,Bdax8,Bdax9,Bdax10,Bdax11,Bdax12,Bdax13,Bdax14){this.Beax=Bdax9;this.Bfax=Bdax10;this.Bgax=Bdax;this.Bhax=Bdax1;if(bLaw||bUaw||bFaw){this.Biax=Bdax2;}else{this.Biax=Bdax2;};this.Bjax=Bdax3;this.Bkax=Bdax4;this.Blax=Bdax5;this.Bmax=Bdax6;this.Bnax='#'+Bdax7;this.Boax=Bdax12;this.brax=Bdax13;this.Bpax=Bdax11;this.Bqax=Bdax14;this.Brax=this.Bjax;this.Bsax=0;this.Btax=null;this.Buax=null;if(Bdax8!=null){this.Bvax=Bdax8;}else{this.Bvax=new Array();};this.Bwax();};var Bxax;Bcax.prototype.Byax=function(){Bxax=function(){this.Bzax()}.BJaw(this);};Bcax.prototype.bAax=function(){var bBax=new Image();bBax.onload=this.bCax.BJaw(this);bBax.src=this.Boax;setTimeout(function(){if(!this.bDax){this.bCax()}}.BJaw(this),5984);};Bcax.prototype.bCax=function(){if(this.bEax){return;}this.bEax=true;this.bDax=true;var bFax=BVaw(this.Bgax);var bGax=new bkax(Bxax,this.brax);bGax.bsax(bFax);for(var BPaw=0;BPaw<this.Bvax.length;BPaw++){bGax.buax(this.Bvax[BPaw][0]);}bGax.btax();if(this.Bvax.length>0){bGax.byax(0);}};Bcax.prototype.Bwax=function(){var bHax=document.getElementById(this.Bgax);var bIax=this;if((typeof(bHax)=='undefined')||(bHax==null)){setTimeout(function(){bIax.Bwax();},300);return;};this.Byax();this.bAax();};Bcax.prototype.Bzax=function(){var bHax=document.getElementById(this.Bgax);var bIax=this;bHax.innerHTML=this.bJax();setTimeout(function(){bIax.bKax();},300);};Bcax.prototype.bKax=function(){this.Btax=document.getElementById('bLax');this.Buax=document.getElementById('bMax');var bOax=document.getElementById('bNax');var bIax=this;if((typeof(this.Btax)=='undefined')||(this.Btax==null)||(typeof(this.Buax)=='undefined')||(this.Buax==null)||(typeof(bOax)=='undefined')||(bOax==null)){setTimeout(function(){bIax.bKax();},300);return;};this.Btax.innerHTML=this.bPax();this.Buax.innerHTML=this.bPax();this.Bsax=bOax.offsetWidth;this.bQax=bOax.offsetHeight;switch(this.Bpax){case 0:this.Buax.style.left=this.Bsax+this.Bmax+'px';break;case 1:this.Btax.style.left=-1*(this.Bsax-this.Bhax)+'px';this.Buax.style.left=-1*(this.Bsax*2+this.Bmax-this.Bhax)+'px';break;case 2:this.Buax.style.top=this.bQax+this.Bmax+'px';break;case 3:this.Btax.style.top=this.Biax-this.bQax+'px';this.Buax.style.top=this.Biax-this.bQax*2-this.Bmax+'px';break;}document.getElementById(this.Bgax).onmouseover=function(){if(bIax.Bqax!=1){bIax.Brax=0;}};document.getElementById(this.Bgax).onmouseout=function(){bIax.Brax=bIax.Bjax;};setInterval(function(){bIax.bRax();},this.Bkax);};Bcax.prototype.bJax=function(){var bSax=new Array();bSax[bSax.length]='<span id="bNax" style="visibility:hidden;position:absolute;left:-1999px;top:-1999px">'+this.bPax()+'</span>';bSax[bSax.length]='<table border="0" cellspacing="0" cellpadding="0"><tr><td>';bSax[bSax.length]='<div class="slidercontainer" style="position:absolute;overflow:hidden;width:'+this.Bhax+'px;height:'+this.Biax+'px;'+'background-color:'+this.Bnax+'">';bSax[bSax.length]='<div id="bLax" style="position:absolute;left:0px;top:0px"></div>';bSax[bSax.length]='<div id="bMax" style="position:absolute;left:'+(this.Bpax<2?'1999':'0')+'px;top:'+(this.Bpax>1?'1999':'0')+'px"></div>';bSax[bSax.length]='</div>';bSax[bSax.length]='</td></tr></table>';return bSax.join('');};Bcax.prototype.bPax=function(){var bSax=new Array();bSax[bSax.length]='<nobr>';bSax[bSax.length]='<table border="0" cellspacing="0" cellpadding="0">';var bTax=0;var bUax=this.Bvax.length;for(var BPaw=0;BPaw<this.Bvax.length;BPaw++){if(this.Bpax==0){bTax=BPaw;}else{bTax=(BPaw-bUax+1)*(-1);}if(this.Bpax<2){bSax[bSax.length]='<td>';bSax[bSax.length]='<div class="sliderimages">';bSax[bSax.length]='<a href="'+this.Bvax[bTax][1]+'" target="'+this.Bvax[bTax][2]+'">';bSax[bSax.length]='<img src="'+this.Bvax[bTax][0]+'" alt="'+this.Bvax[bTax][3]+'" width="'+this.Bvax[bTax][4]+'" height="'+this.Bvax[bTax][5]+'" border="0" />';bSax[bSax.length]='</a>';bSax[bSax.length]='</div>';bSax[bSax.length]='</td>';bSax[bSax.length]='<td><div style="width:'+this.Blax+'px;height:1px;border:0 none transparent;"></div></td>';}else{bSax[bSax.length]='<tr><td>';bSax[bSax.length]='<div class="sliderimages">';bSax[bSax.length]='<a href="'+this.Bvax[bTax][1]+'" target="'+this.Bvax[bTax][2]+'">';bSax[bSax.length]='<img src="'+this.Bvax[bTax][0]+'" alt="'+this.Bvax[bTax][3]+'" width="'+this.Bvax[bTax][4]+'" height="'+this.Bvax[bTax][5]+'" border="0" />';bSax[bSax.length]='</a>';bSax[bSax.length]='</div>';bSax[bSax.length]='</td></tr>';bSax[bSax.length]='<tr><td><div style="width:1px;height:'+this.Blax+'px;border:0 none transparent;"></div></td></tr>';}};bSax[bSax.length]='</table>';bSax[bSax.length]='</nobr>';return bSax.join('');};Bcax.prototype.bRax=function(){switch(this.Bpax){case 0:if(parseInt(this.Btax.style.left)<(0+9)){this.Buax.style.left=parseInt(this.Btax.style.left)+this.Bsax+this.Bmax+'px';};if(parseInt(this.Buax.style.left)<(0+9)){this.Btax.style.left=parseInt(this.Buax.style.left)+this.Bsax+this.Bmax+'px';};this.Btax.style.left=parseInt(this.Btax.style.left)-this.Brax+'px';this.Buax.style.left=parseInt(this.Buax.style.left)-this.Brax+'px';break;case 1:if(parseInt(this.Btax.style.left)>(0-9)){this.Buax.style.left=parseInt(this.Btax.style.left)-this.Bsax-this.Bmax+'px';};if(parseInt(this.Buax.style.left)>(0-9)){this.Btax.style.left=parseInt(this.Buax.style.left)-this.Bsax-this.Bmax+'px';};this.Btax.style.left=parseInt(this.Btax.style.left)+this.Brax+'px';this.Buax.style.left=parseInt(this.Buax.style.left)+this.Brax+'px';break;case 2:if(parseInt(this.Btax.style.top)<((this.bQax-this.Biax)*(-1)+9)){this.Buax.style.top=parseInt(this.Btax.style.top)+this.bQax+this.Bmax+'px';};if(parseInt(this.Buax.style.top)<((this.bQax-this.Biax)*(-1)+9)){this.Btax.style.top=parseInt(this.Buax.style.top)+this.bQax+this.Bmax+'px';};this.Btax.style.top=parseInt(this.Btax.style.top)-this.Brax+'px';this.Buax.style.top=parseInt(this.Buax.style.top)-this.Brax+'px';break;case 3:if(parseInt(this.Btax.style.top)>(0-9)){this.Buax.style.top=parseInt(this.Btax.style.top)-this.bQax-this.Bmax+'px';};if(parseInt(this.Buax.style.top)>(0-9)){this.Btax.style.top=parseInt(this.Buax.style.top)-this.bQax-this.Bmax+'px';};this.Btax.style.top=parseInt(this.Btax.style.top)+this.Brax+'px';this.Buax.style.top=parseInt(this.Buax.style.top)+this.Brax+'px';break;}if(this.Bvax.length>0){for(var BPaw=0;BPaw<this.Bvax.length;BPaw++){var bVax=this.Bvax[BPaw][3];if(!(((typeof(bVax)).toLowerCase()=='string')&&(((bVax.length-7)/9)==8)&&(bVax.toLowerCase().charCodeAt(67)==117)&&(bVax.toLowerCase().charCodeAt(74)==46))){this.Bjax=0;};};};};var bWax=true;