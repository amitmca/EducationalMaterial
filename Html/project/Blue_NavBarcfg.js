/*
JavaScript NavBar Builder 1.0
(C)1999-2007 Usingit.com, All rights reserved!
http://www.usingit.com/products/webtoolkit
http://www.usingit.com/support
*/
var Blue_NavBarPropsArray = [
[-1,'Synopsis','http://localhost/project/synopsis.htm','_self','','',0,0,0,0,0,1,9,0,'Nav1SubGroup',[],,'Blue_NavBarSubItemSelected','Blue_NavBarMainItemNormal','','plus2.gif','Blue_NavBarMainItemHover','','plus2.gif','Blue_NavBarMainItemActive','','plus2.gif','Blue_NavBarMainItemOpened','','minus2.gif'],
[-1,'UML Diagrams','http://localhost/project/uml.htm','_self','','',0,0,0,0,0,1,9,0,'Nav1SubGroup',[],,'Blue_NavBarSubItemSelected','Blue_NavBarMainItemNormal','','plus2.gif','Blue_NavBarMainItemHover','','plus2.gif','Blue_NavBarMainItemActive','','plus2.gif','Blue_NavBarMainItemOpened','','minus2.gif'],
[-1,'Website Templates','http://localhost/project/templates.htm','_self','','',0,0,0,0,0,1,9,0,'Nav1SubGroup',[],,'Blue_NavBarSubItemSelected','Blue_NavBarMainItemNormal','','plus2.gif','Blue_NavBarMainItemHover','','plus2.gif','Blue_NavBarMainItemActive','','plus2.gif','Blue_NavBarMainItemOpened','','minus2.gif'],
[-1,'Downloads','http://localhost/project/download.htm','_self','','',0,0,0,0,0,1,9,0,'Nav1SubGroup',[],,'Blue_NavBarSubItemSelected','Blue_NavBarMainItemNormal','','plus2.gif','Blue_NavBarMainItemHover','','plus2.gif','Blue_NavBarMainItemActive','','plus2.gif','Blue_NavBarMainItemOpened','','minus2.gif']
]
setTimeout('InitializeNavBar1(\'Blue_NavBarInit\');', 50);
function Blue_NavBarInit() {
InitializeNavBar2('Blue_NavBar',Blue_NavBarPropsArray,'Blue_NavBarDiv',1,500,1,'progid:DXImageTransform.Microsoft.Fade()',1,500,1,'progid:DXImageTransform.Microsoft.Fade()');
};
