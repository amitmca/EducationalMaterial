
/*
 Milonic DHTML Menu
 Written by Andy Woolley
 Copyright 2002 (c) Milonic Solutions. All Rights Reserved.
 Plase vist http://www.milonic.co.uk/menu or e-mail menu3@milonic.com
 You may use this menu on your web site free of charge as long as you place prominent links to http://www.milonic.co.uk/menu and
 your inform us of your intentions with your URL AND ALL copyright notices remain in place in all files including your home page
 Comercial support contracts are available on request if you cannot comply with the above rules.

 Please note that major changes to this file have been made and is not compatible with earlier versions..

 You no longer need to number your menus as in previous versions.
 The new menu structure allows you to name the menu instead. This means that you can remove menus and not break the system.
 The structure should also be much easier to modify, add & remove menus and menu items.

 If you are having difficulty with the menu please read the FAQ at http://www.milonic.co.uk/menu/faq.php before contacting us.

 Please note that the above text CAN be erased if you wish as long as copyright notices remain in place.
*/

//The following line is critical for menu operation, and MUST APPEAR ONLY ONCE.
menunum=0;menus=new Array();_d=document;function addmenu(){menunum++;menus[menunum]=menu;}function dumpmenus(){mt="<script language=JavaScript>";for(a=1;a<menus.length;a++){mt+=" menu"+a+"=menus["+a+"];"}mt+="<\/script>";_d.write(mt)}
//Please leave the above line intact. The above also needs to be enabled if it not already enabled unless you have more than one _array.js file


////////////////////////////////////
// Editable properties START here //
////////////////////////////////////

timegap=500                   // The time delay for menus to remain visible
followspeed=50                 // Follow Scrolling speed
followrate=1                 // Follow Scrolling Rate
suboffset_top=10              // Sub menu offset Top position
suboffset_left=10             // Sub menu offset Left position



VCStyle=[                 
"000000", 		// Mouse Off Font Color
"FBFADB", 		// Mouse Off Background Color (use zero for transparent in Netscape 6)
"000000", 		// Mouse On Font Color
"A4A4C1", 		// Mouse On Background Color
"8A867A", 		// Menu Border Color
"12", 			// Font Size (default is px but you can specify mm, pt or a percentage)
"normal", 		// Font Style (italic or normal)
"normal", 		// Font Weight (bold or normal)
"Tahoma,Helvetica,Verdana", // Font Name
3, 			// Menu Item Padding or spacing
"http://visualcase.com/menuarrow.gif", 	// Sub Menu Image (Leave this blank if not needed)
0, 			// 3D Border & Separator bar
, 			// 3D High Color
, 			// 3D Low Color
, 			// Current Page Item Font Color (leave this blank to disable)
, 			// Current Page Item Background Color (leave this blank to disable)
, 			// Top Bar image (Leave this blank to disable)
, 			// Menu Header Font Color (Leave blank if headers are not needed)
, 			// Menu Header Background Color (Leave blank if headers are not needed)
, 			// Menu Item Separator Color
]

addmenu(menu=[
"MainMenu",		            // Menu Name - This is needed in order for this menu to be called
160,                          // Menu Top - The Top position of this menu in pixels
10,                           // Menu Left - The Left position of this menu in pixels
140,                          // Menu Width - Menus width in pixels
1,                            // Menu Border Width
,                             // Screen Position - here you can use "center;left;right;middle;top;bottom" or a combination of "center:middle"
VCStyle,                   // Properties Array - this array is declared higher up as you can see above
1,                            // Always Visible - allows this menu item to be visible at all time (1=on or 0=off)
,                             // Alignment - sets this menu elements text alignment, values valid here are: left, right or center
"fade(duration=0.4);Shadow(color=CFCFDE, Direction=135, Strength=3)",// Filter - Text variable for setting transitional effects on menu activation - see above for more info
1,                            // Follow Scrolling Top Position - Tells this menu to follow the user down the screen on scroll placing the menu at the value specified.
0,                            // Horizontal Menu - Tells this menu to display horizontaly instead of top to bottom style (1=on or 0=off)
0,                            // Keep Alive - Keeps the menu visible until the user moves over another menu or clicks elsewhere on the page (1=on or 0=off)
,                             // Position of TOP sub image left:center:right
,                             // Set the Overall Width of Horizontal Menu to specified width or 100% and height to a specified amount
0,                            // Right To Left - Used in Hebrew for example. (1=on or 0=off)
0,                            // Open the Menus OnClick - leave blank for OnMouseover (1=on or 0=off)
,                             // ID of the div you want to hide on MouseOver (useful for hiding form elements)
,                             // Background image for menu Color must be set to transparent for this to work
0,                            // Scrollable Menu
,                             // Miscellaneous Menu Properties
,"Home","http://visualcase.com/index.htm",,,1
,"Visual Case","show-menu=VisualCaseMenu",,,1
,"Tutorials","show-menu=TutorialMenu",,,1
,"Tour","show-menu=TourMenu",,,1
,"Pricing & Licensing","http://visualcase.com/vc_pricing.htm",,,1
,"Purchase","http://download.VisualCase.com/Purchase/PurchaseMethod.aspx",,,1
,"Download","http://download.VisualCase.com/logon.aspx",,,1
,"Support","show-menu=SupportMenu",,,1
,"Contact Us","http://visualcase.com/vc_contact.htm",,,1
])


addmenu(menu=[
"VisualCaseMenu",
,
,
130,
1,
,
VCStyle,
0,
,
"fade(duration=0.4);Shadow(color=CFCFDE, Direction=135, Strength=3)",
0,
0,
0,
,
,
0,
0,
,
,
0,
,
,"Features at a Glance","http://visualcase.com/visualcase/features.htm",,,1
,"Screenshots","http://visualcase.com/screenshots.htm",,,1
,"Version History","http://visualcase.com/visualcase/whatsnew.htm",,,1
,"Press","http://visualcase.com/press/press.htm",,,1
])

addmenu(menu=[
"TutorialMenu",
,
,
140,
1,
,
VCStyle,
0,
,
"fade(duration=0.4);Shadow(color=CFCFDE, Direction=135, Strength=3)",
0,
0,
0,
,
,
0,
0,
,
,
0,
,
,"Tutorials Index", "http://visualcase.com/tutorials/tutorials.htm",,,0
,"UML Tutorial", "http://visualcase.com/tutorials/uml-tutorial.htm",,,0
,"Database Design","http://visualcase.com/tutorials/database-design-tutorial.htm",,,0
,"Database Engineering","http://visualcase.com/tutorials/database-engineer-tutorial.htm",,,0
,"Supported Databases","http://visualcase.com/tutorials/databases/databases.htm",,,0
,"Flow Charting","http://visualcase.com/tutorials/flow-chart.htm",,,0
,"Data Flow Diagramming","http://visualcase.com/tutorials/data-flow-diagram.htm",,,0
])

addmenu(menu=[
"TourMenu",
,
,
130,
1,
,
VCStyle,
0,
,
"fade(duration=0.4);Shadow(color=CFCFDE, Direction=135, Strength=3)",
0,
0,
0,
,
,
0,
0,
,
,
0,
,
,"Tours Index", "http://visualcase.com/tour/introduction.htm",,,0
,"Diagramming","http://visualcase.com/tour/diagramming/diagram.asp",,,0
,"UML","http://visualcase.com/tour/uml/use_case.asp",,,0
,"Database Design","http://visualcase.com/tour/database/table.asp",,,0
,"Database Engineering","http://visualcase.com/tour/engineer/engineer.asp",,,0
,"Dynamic Viewer","http://visualcase.com/tour/dynamic_viewer/dynamic_viewer.asp",,,0
])

addmenu(menu=[
"SupportMenu",
,
,
130,
1,
,
VCStyle,
0,
,
"fade(duration=0.4);Shadow(color=CFCFDE, Direction=135, Strength=3)",
0,
0,
0,
,
,
0,
0,
,
,
0,
,
,"FAQ","http://visualcase.com/support/faq.asp",,,1
,"Online Help","http://visualcase.com/kbase/visual_case.htm",,,1
,"Updates","http://visualcase.com/support/updates.htm",,,1
])


dumpmenus();
	