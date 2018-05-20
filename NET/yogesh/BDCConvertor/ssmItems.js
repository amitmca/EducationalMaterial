<!--
/*
Configure menu styles below
NOTE: To edit the link colors, go to the STYLE tags and edit the ssm2Items colors
*/
YOffset=150; // no quotes!!
XOffset=0;
staticYOffset=30; // no quotes!!
slideSpeed=20 // no quotes!!
waitTime=100; // no quotes!! this sets the time the menu stays out for after the mouse goes off it.
menuBGColor="black";
menuIsStatic="yes"; //this sets whether menu should stay static on the screen
menuWidth=150; // Must be a multiple of 10! no quotes!!
menuCols=2;
hdrFontFamily="verdana";
hdrFontSize="2";
hdrFontColor="white";
hdrBGColor="#0f62a6";
hdrAlign="left";
hdrVAlign="center";
hdrHeight="15";
linkFontFamily="Verdana";
linkFontSize="2";
linkBGColor="white";
linkOverBGColor="#cddefc";
linkTarget="_top";
linkAlign="Left";
barBGColor="#1C84C5";
barFontFamily="Verdana";
barFontSize="2";
barFontColor="white";
barVAlign="center";
barWidth=20; // no quotes!!
barText="Genius BDC Converter"; // <IMG> tag supported. Put exact html for an image to show.

///////////////////////////

// ssmItems[...]=[name, link, target, colspan, endrow?] - leave 'link' and 'target' blank to make a header
ssmItems[0]=["User Management"] //create header
ssmItems[1]=["Home", "HomePageBCD.aspx", ""]
ssmItems[2]=["Create User", "createuser.aspx",""]
ssmItems[3]=["Create Group", "CreateGroup.aspx", ""]
ssmItems[4]=["User Group", "UserGroup.aspx", ""]
ssmItems[5]=["User Permission / Delete User", "UserPermission.aspx", ""]
ssmItems[6]=["Group Permission / Delete Group", "GroupPermission.aspx", ""]

ssmItems[7]=["BDC Converter", "", ""] //create header
ssmItems[8]=["BDC Converter", "Convert.aspx", ""]

//ssmItems[9]=["Customize", "", ""]
//ssmItems[10]=["Activity", "", ""]
//ssmItems[7]=["FAQ", "", "", 1, "no"] //create two column row
//ssmItems[8]=["Email", "", "",1]

buildMenu();

//-->