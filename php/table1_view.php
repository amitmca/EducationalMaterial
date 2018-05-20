<?php
// This script and data application were generated by PHPMagic 3.1 on 9/20/2008 at 8:22:12 PM
// Download PHPMagic for free from http://www.websitedatabases.com/

	include(dirname(__FILE__)."/language.php");
	include(dirname(__FILE__)."/lib.php");
	include(dirname(__FILE__)."/table1_dml.php");
	
	$x = new DataList;
	if($HTTP_POST_VARS["Filter_x"] != ""  || $HTTP_POST_VARS['CSV_x'] != "")
	{
		// Query used in filters page and CSV output
		$x->Query = "select table1.field1 as 'name', table1.field2 as 'rno' from table1";
	}
	else
	{
		// Query used in table view
		$x->Query = "select table1.field1 as 'name', table1.field2 as 'rno' from table1";
	}
	
	// handle date sorting correctly
	// end of date sorting handler
	
	$x->DataHeight = 150;
	$x->AllowSelection = 1;
	$x->AllowDelete = 1;
	$x->AllowInsert = 1;
	$x->AllowUpdate = 1;
	$x->AllowFilters = 1;
	$x->AllowSavingFilters = 0;
	$x->AllowSorting = 1;
	$x->AllowNavigation = 1;
	$x->AllowPrinting = 1;
	$x->HideTableView = 0;
	$x->RecordsPerPage = 10;
	$x->QuickSearch = 3;
	$x->QuickSearchText = $Translation["quick search"];
	$x->ScriptFileName = "table1_view.php";
	$x->TableTitle = "form";
	$x->PrimaryKey = "table1.field2";
	$x->ColWidth[] = 150;
	$x->ColWidth[] = 150;
	$x->Template = 'table1_templateTV.html';
	$x->SelectedTemplate = 'table1_templateTVS.html';
	$x->ShowTableHeader = 1;
	$x->ShowRecordSlots = 1;
	$x->HighlightColor = '#EEE1B5';
	$x->Render();
	
	include(dirname(__FILE__)."/header.php");
	echo $x->HTML;
	include(dirname(__FILE__)."/footer.php");
?><br><font size=-2><center><?php echo $Translation["powered by"]; ?> PHPMagic 3.1</center></font>
