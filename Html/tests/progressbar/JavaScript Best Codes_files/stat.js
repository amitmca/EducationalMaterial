
var _pdn="auto",_pbd=document,_ptcp="/",x="",xx="",xxt="",_pdt,_pdh,_pdl=_pbd.location,_pss=0,_psu=0,_pdo="",_pr="-",_pfno=0,_pc="",_psep="-",_prnd;
var _pOsr=new Array();
var _pOkw=new Array();
_pOsr[0]="google";	_pOkw[0]="q";
_pOsr[1]="yahoo";	_pOkw[1]="p";
_pOsr[2]="msn";		_pOkw[2]="q";
_pOsr[3]="aol";		_pOkw[3]="query";
_pOsr[4]="aol";		_pOkw[4]="encquery";
_pOsr[5]="lycos";	_pOkw[5]="query";
_pOsr[6]="ask";		_pOkw[6]="q";
_pOsr[7]="altavista";	_pOkw[7]="q";
_pOsr[8]="search";	_pOkw[8]="q";
_pOsr[9]="netscape";	_pOkw[9]="s";
_pOsr[10]="cnn";	_pOkw[10]="query";
_pOsr[11]="looksmart";	_pOkw[11]="qt";
_pOsr[12]="about";	_pOkw[12]="terms";
_pOsr[13]="mamma";	_pOkw[13]="query";
_pOsr[14]="alltheweb";	_pOkw[14]="q";
_pOsr[15]="gigablast";	_pOkw[15]="q";
_pOsr[16]="voila";	_pOkw[16]="kw";
_pOsr[17]="virgilio";	_pOkw[17]="qs";
_pOsr[18]="live";	_pOkw[18]="q";
_pOsr[19]="baidu";	_pOkw[19]="wd";
_pOsr[20]="alice";	_pOkw[20]="qs";
_pOsr[21]="seznam";	_pOkw[21]="w";
_pOsr[22]="yandex";	_pOkw[22]="text";
_pOsr[23]="najdi";	_pOkw[23]="q";
_pOsr[24]="dahio";	_pOkw[24]="query";
var _pOno=new Array();
_pOno[0]="persianstat";
var _pRno=new Array();
_pRno[0]=".persianstat.com";
function persianstat(id,op)
{
    _pdh=_pDomain()
    if (!_pVG(id)) return;
    var s="http://service.persianstat.com/Stats.aspx?psid="+id+"&psop="+op;
    var dc=_pbd.cookie,a,b,lb,_w= "16",_h="16";
    if(op==4){_w="0";_h="0";}
    _pdt=new Date();
    x=new Date(_pdt.getTime()+(60000));
    xx=new Date(_pdt.getTime()+(1800000));
    xxt=new Date(_pdt.getTime()+(5000));
    _prnd=Math.round(Math.random()*2147483647);
    x=" expires="+x.toGMTString()+";";
    xx=" expires="+xx.toGMTString()+";";
    xxt=" expires="+xxt.toGMTString()+";";
    a=dc.indexOf("___ptma="+_pdh);
    b=dc.indexOf("___ptmb="+_pdh);
    lb=dc.indexOf("___ptmc="+_pdh);
    if (_pdn && _pdn!="") { _pdo=" domain="+_pdn+";"; }
    _pss=a>=0?1:0;
    _pbd.cookie="___ptma="+_pdh+"; path="+_ptcp+";"+x+_pdo;
    _psu=b>=0?1:0;
    _pbd.cookie="___ptmb="+_pdh+"; path="+_ptcp+";"+xx+_pdo;
    _pbd.cookie="___ptmc="+_pdh+"; path="+_ptcp+";"+xxt+_pdo;
    if(lb>=0) return;
    _pr=_pbd.referrer;
    _pc=_pOrg();
    if (_pc=="-" || _pc=="") _pc=_pRef();
    if (_pc=="-" || _pc=="") _pc="pscn=direct&pscr=-&psct=-&psep=-";
    s+="&"+_pc;
    s+="&psuq="+_psu+"&psuu="+_pss;
    s+="&psrd="+_prnd;
    s+=_pInfo();
    
    _pbd.write('<iframe src="'+s+'" height="'+_h+'" width="'+_w+'" scrolling="no" marginwidth="0" allowtransparency="true" frameborder="no" marginheight="0" name="PersianStat"></iframe>');
}
function _pInfo() {
 var p,i=0,s="",pg=_pdl.pathname;
 if (!_pr || _pr=="") { _pr="-"; }
 s+=_pBInfo();
 if (_pbd.title && _pbd.title!="") s+="&pstl="+_pES(_pbd.title);
 if (_pdl.hostname && _pdl.hostname!="") s+="&pshn="+_pES(_pdl.hostname);
 s+="&pspt="+_pES(pg);
 if ((i=_pr.indexOf("://"))>0)
 _pr=_pr.substring(i+3,_pr.length);
 s+="&psrf="+_pES(_pr);
 return s;
}
function _pVG(id) {
 if((_pdn.indexOf("www.persianstat.") == 0 || _pdn.indexOf(".persianstat.") == 0 || _pdn.indexOf("persianstat.") == 0) && _ptcp=='/'){ return false;}
 try{if(_pbd.lastChild.innerHTML.indexOf("persianstat("+id,_pbd.lastChild.innerHTML.indexOf("persianstat("+id)+1)>-1) return false;} catch(e){}
 return true;
}
function _pDomain() {
 if (!_pdn || _pdn=="" || _pdn=="none") { _pdn=""; return 1; }
 if (_pdn=="auto") {
  var d=_pbd.domain;
  if (d.substring(0,4)=="www."){ d=d.substring(4,d.length);}
  _pdn=d;
 }
 return _pHash(_pdn+_pdl.pathname+_pdl.search);
}
function _pHash(d) {
 if (!d || d=="") return 1;
 var h=0,g=0;
 for (var i=d.length-1;i>=0;i--) {
  var c=parseInt(d.charCodeAt(i));
  h=((h << 6) & 0xfffffff) + c + (c << 14);
  if ((g=h & 0xfe00000)!=0) h=(h ^ (g >> 21));
 }
 return h;
}
function _pGC(l,n,s) {
 if (!l || l=="" || !n || n=="" || !s || s=="") return "-";
 var i,i2,i3,c="-";
 i=l.indexOf(n);
 i3=n.indexOf("=")+1;
 if (i > -1) {
  i2=l.indexOf(s,i); if (i2 < 0) { i2=l.length; }
  c=l.substring((i+i3),i2);
 }
 return c;
}
function _pBInfo() {
 var sr="-",sc="-",ul="-",cs="-",je=1,pi=0;
 var n=navigator;
 var b=1;
 var ver=n.appVersion;
 var verIE=parseInt(ver.substring(ver.indexOf("MSIE")+5,ver.indexOf("MSIE")+6));
 if(verIE>0)ver=verIE;
 else ver=parseInt(ver);
 if (self.screen) {
  sr=screen.width+"x"+screen.height;
  sc=screen.colorDepth;
 } else if (self.java) {
  var j=java.awt.Toolkit.getDefaultToolkit();
  var s=j.getScreenSize();
  sr=s.width+"x"+s.height;
 }
 if (n.language) { ul=n.language.toLowerCase(); }
 else if (n.browserLanguage) { ul=n.browserLanguage.toLowerCase(); }
 je=n.javaEnabled()?1:0;
 if (_pbd.characterSet) cs=_pES(_pbd.characterSet);
 else if (_pbd.charset) cs=_pES(_pbd.charset);
 if((n.appName=="Netscape"&&ver>=3))
 {
  var p=new Array("Shockwave Flash","Shockwave for Director","RealPlayer","QuickTime","VivoActive","LiveAudio","VRML","Dynamic HTML Binding","Windows Media Services");
  var np=n.plugins;
  for(var x=0;x<p.length;x++)
  {
	for(var i=0;i<np.length;i++)
	 if(np[i].name.indexOf(p[x])>=0)pi|=b;
	b*=2;
  }
 }
 if(verIE>=5&&n.appVersion.indexOf('Win')>=0&&n.userAgent.indexOf('Opera')<0)
 {
  if(!_pbd.body)_pbd.write('<body>');
  var db=_pbd.body;
  var p=new Array("D27CDB6E-AE6D-11CF-96B8-444553540000","2A202491-F00D-11CF-87CC-0020AFEECF20","23064720-C4F8-11D1-994D-00C04F98BBC9","","","","90A7533D-88FE-11D0-9DBE-0000C0411FC3","9381D8F2-0288-11D0-9501-00AA00B911A5","22D6F312-B0F6-11D0-94AB-0080C74C7E95");
  db.addBehavior("#default#clientcaps");
   for(var i=0;i<p.length;i++)
   {
	if(p[i])
	 if(db.isComponentInstalled("{"+p[i]+"}","componentid"))pi|=b;
	b*=2;
   }
 }		
 return "&pscs="+cs+"&pswh="+sr+"&pssc="+sc+"&psul="+ul+"&psje="+je+"&pspl="+pi;
}
function _pRef() {
 if (_pr=="0" || _pr=="" || _pr=="-") return "";
 var i=0,h,k,n,e="0",p;
 if ((i=_pr.indexOf("://"))<0) return "";
 h=_pr.substring(i+3,_pr.length);
 p=h.indexOf(_pdn);
 if ((p>=0) && (p<=8)) { e="1"; }
 if (h.indexOf("/") > -1) {
  k=h.substring(h.indexOf("/"),h.length);
  if (k.indexOf("?") > -1) k=k.substring(0,k.indexOf("?"));
  h=h.substring(0,h.indexOf("/"));
 }
 h=h.toLowerCase();
 n=h;
 if ((i=n.indexOf(":")) > -1) n=n.substring(0,i);
 for (var ii=0;ii<_pRno.length;ii++) {
  if ((i=n.indexOf(_pRno[ii].toLowerCase())) > -1 && n.length==(i+_pRno[ii].length)) { _pfno=1; break; }
 }
 if (h.indexOf("www.")==0) h=h.substring(4,h.length);
 return "pscn=referral&pscr="+_pEC(h)+"&"+"psct="+_pEC(k)+"&psep="+e;
}
function _pOrg(t) 
{
 if (_pr=="0" || _pr=="" || _pr=="-") return "";
 var i=0,h,k;
 if ((i=_pr.indexOf("://")) < 0) return "";
 h=_pr.substring(i+3,_pr.length);
 if (h.indexOf("/") > -1) {
  h=h.substring(0,h.indexOf("/"));
 }
 for (var ii=0;ii<_pOsr.length;ii++) {
  if (h.toLowerCase().indexOf(_pOsr[ii].toLowerCase()) > -1) {
   if ((i=_pr.indexOf("?"+_pOkw[ii]+"=")) > -1 || (i=_pr.indexOf("&"+_pOkw[ii]+"=")) > -1) {
    k=_pr.substring(i+_pOkw[ii].length+2,_pr.length);
    if ((i=k.indexOf("&")) > -1) k=k.substring(0,i);
    for (var yy=0;yy<_pOno.length;yy++) {
     if (_pOno[yy].toLowerCase()==k.toLowerCase()) { _pfno=1; break; }
    }
    if (t) return _pEC(k);
    else return "pscn=organic&pscr="+_pEC(_pOsr[ii])+"&"+"psct="+_pEC(k)+"&psep=0";
   }
  }
 }
 return "";
}
function _pEC(s) {
  var n="";
  if (!s || s=="") return "";
  for (var i=0;i<s.length;i++) {if (s.charAt(i)==" ") n+="+"; else n+=s.charAt(i);}
  return n;
}
function _pES(s,u) {
 if (typeof(encodeURIComponent) == 'function') {
  if (u) return encodeURI(s);
  else return encodeURIComponent(s);
 } else {
  return escape(s);
 }
}