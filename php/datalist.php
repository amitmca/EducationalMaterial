<?php

class DataList
{
	// this class generates the data table ...
	// it assumes that the following functions are already defined:
		// delete()
		// update()
		// insert()
		// form()
		// >>> all the above functions change for every table
		// >>> the calling script should include the correct versions of them.
		// NavMenus()
		// sql()
	// the class also assumes that the following files already exist:
		// print.gif
		// delete.gif
		// update.gif
		// search.gif
		// cancel_search.gif
		// insert.gif
		// asc.gif
		// desc.gif
		// scroll_bar.gif
		// scroll_box.gif
		// scroll_next.gif
		// scroll_previous.gif
	// the class assumes the following CSS classes have been defined:
		// Error
		// TableTitle
		// TableHeader
		// TextBox
		// TableBody
		// TableBodyNumeric
		// TableBodySelectedNumeric
		// TableBodySelected
		// TableFooter
		// SelectedOption
	
	var $Query,

		$ColWidth,                      // array of field widths
		$DataHeight,

		$AllowSelection,
		$AllowDelete,
		$AllowInsert,
		$AllowUpdate,
		$AllowFilters,
		$AllowSavingFilters,
		$AllowSorting,
		$AllowNavigation,
		$AllowPrinting,
		$HideTableView,
		$AllowCSV,
		$CSVSeparator,

		$QuickSearch,     // 0 to 3

		$RecordsPerPage,
		$ScriptFileName,
		$RedirectAfterInsert,
		$TableTitle,
		$PrimaryKey,

		// Templates variables
		$Template,
		$SelectedTemplate,
		$ShowTableHeader, // 1 = show standard table headers
		$ShowRecordSlots, // 1 = show empty record slots in table view
		// End of templates variables

		$HTML;                          // generated html after calling Render()

	function DataList()     // Constructor function
	{
		$this->DataHeight = 150;
		
		$this->AllowSelection = 1;
		$this->AllowDelete = 1;
		$this->AllowInsert = 1;
		$this->AllowUpdate = 1;
		$this->AllowFilters = 1;
		$this->AllowNavigation = 1;
		$this->AllowPrinting = 1;
		$this->HideTableView = 0;
		$this->QuickSearch = 0;
		$this->AllowCSV = 0;
		$this->CSVSeparator = ",";
		$this->HighlightColor = '#FFE4E1';  // default highlight color
		
		$this->RecordsPerPage = 10;
		$this->Template = '';
		$this->HTML = "";
	}

	function Render()
	{
	// get post and get variables
		global $HTTP_SERVER_VARS, $HTTP_GET_VARS, $HTTP_POST_VARS, $_SERVER, $Translation;
		
		$FiltersPerGroup = 4;
		
		if($HTTP_SERVER_VARS["REQUEST_METHOD"] == "GET")
		{
			$SortField = $HTTP_GET_VARS["SortField"];
			$SortDirection = $HTTP_GET_VARS["SortDirection"];
			$FirstRecord = $HTTP_GET_VARS["FirstRecord"];
			$ScrollUp_y = $HTTP_GET_VARS["ScrollUp_y"];
			$ScrollDn_y = $HTTP_GET_VARS["ScrollDn_y"];
			$Previous_x = $HTTP_GET_VARS["Previous_x"];
			$Next_x = $HTTP_GET_VARS["Next_x"];
			$Filter_x = $HTTP_GET_VARS["Filter_x"];
			$SaveFilter_x = $HTTP_GET_VARS["SaveFilter_x"];
			$NoFilter_x = $HTTP_GET_VARS["NoFilter_x"];
			$CancelFilter = $HTTP_GET_VARS["CancelFilter"];
			$ApplyFilter = $HTTP_GET_VARS["ApplyFilter"];
			$Search_x = $HTTP_GET_VARS["Search_x"];
			$SearchString = $HTTP_GET_VARS["SearchString"];
			$CSV_x = $HTTP_GET_VARS["CSV_x"];
			
			$FilterAnd = $HTTP_GET_VARS["FilterAnd"];
			$FilterField = $HTTP_GET_VARS["FilterField"];
			$FilterOperator = $HTTP_GET_VARS["FilterOperator"];
			$FilterValue = $HTTP_GET_VARS["FilterValue"];
			
			$Print_x = $HTTP_GET_VARS["Print_x"];
			$SelectedID = $HTTP_GET_VARS["SelectedID"];
			$insert_x = $HTTP_GET_VARS["insert_x"];
			$update_x = $HTTP_GET_VARS["update_x"];
			$delete_x = $HTTP_GET_VARS["delete_x"];
			$deselect_x = $HTTP_GET_VARS["deselect_x"];
		}
		else
		{
			$SortField = $HTTP_POST_VARS["SortField"];
			$SortDirection = $HTTP_POST_VARS["SortDirection"];
			$FirstRecord = $HTTP_POST_VARS["FirstRecord"];
			$ScrollUp_y = $HTTP_POST_VARS["ScrollUp_y"];
			$ScrollDn_y = $HTTP_POST_VARS["ScrollDn_y"];
			$Previous_x = $HTTP_POST_VARS["Previous_x"];
			$Next_x = $HTTP_POST_VARS["Next_x"];
			$Filter_x = $HTTP_POST_VARS["Filter_x"];
			$SaveFilter_x = $HTTP_POST_VARS["SaveFilter_x"];
			$NoFilter_x = $HTTP_POST_VARS["NoFilter_x"];
			$CancelFilter = $HTTP_POST_VARS["CancelFilter"];
			$ApplyFilter = $HTTP_POST_VARS["ApplyFilter"];
			$Search_x = $HTTP_POST_VARS["Search_x"];
			$SearchString = $HTTP_POST_VARS["SearchString"];
			$CSV_x = $HTTP_POST_VARS["CSV_x"];
			
			$FilterAnd = $HTTP_POST_VARS["FilterAnd"];
			$FilterField = $HTTP_POST_VARS["FilterField"];
			$FilterOperator = $HTTP_POST_VARS["FilterOperator"];
			$FilterValue = $HTTP_POST_VARS["FilterValue"];
			
			$Print_x = $HTTP_POST_VARS["Print_x"];
			$SelectedID = $HTTP_POST_VARS["SelectedID"];
			$insert_x = $HTTP_POST_VARS["insert_x"];
			$update_x = $HTTP_POST_VARS["update_x"];
			$delete_x = $HTTP_POST_VARS["delete_x"];
			$deselect_x = $HTTP_POST_VARS["deselect_x"];
		}
		
	// insure authenticity of user inputs:
		if(!$this->AllowSelection)
		{
			$insert_x = "";
			$update_x = "";
			$delete_x = "";
			$deselect_x = "";
		}
		if(!$this->AllowDelete)
		{
			$delete_x = "";
		}
		if(!$this->AllowInsert)
		{
			$insert_x = "";
		}
		if(!$this->AllowUpdate)
		{
			$update_x = "";
		}
		if(!$this->AllowFilters)
		{
			$Filter_x = "";
		}
		if(!$this->AllowPrinting)
		{
			$Print_x = "";
		}
		if(!$this->QuickSearch)
		{
			$SeachString = "";
		}
		if(!$this->AllowCSV)
		{
			$CSV_x = "";
		}

	// retouch query to avoid case matching problems
		$this->Query = eregi_replace(" WHERE ", " where ", $this->Query);
		$this->Query = eregi_replace("SELECT ", "select ", $this->Query);
		$this->Query = eregi_replace(" FROM ", " from ", $this->Query);
		$this->Query = eregi_replace(" AS ", " as ", $this->Query);

		
		$this->HTML .= "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">";
		$this->HTML .= "<form enctype=\"multipart/form-data\" method=post name=myform action='$this->ScriptFileName'>";


	// handle user commands ...
		if($deselect_x != "")
		{
			$SelectedID = "";
		}
		
		elseif($insert_x != "")
		{
			$SelectedID = insert();
			
			// redirect to a safe url to avoid refreshing and thus
			// insertion of duplicate records.

			if($this->RedirectAfterInsert!=""){
				echo "<META HTTP-EQUIV=\"Refresh\" CONTENT=\"0;url=" . str_replace("#ID#", $SelectedID, $this->RedirectAfterInsert) ."\">";
				exit;
			}else{
				$this->HTML .= "<META HTTP-EQUIV='Refresh' CONTENT='0;url=$this->ScriptFileName?SortField=$SortField&SortDirection=$SortDirection&FirstRecord=$FirstRecord&SelectedID=$SelectedID";
				for($i = 1; $i <= (20 * $FiltersPerGroup); $i++) // Number of filters allowed
				{
					if($FilterField[$i] != "" && $FilterOperator[$i] != "" && $FilterValue[$i] != "")
					{
						$this->HTML .= "&FilterAnd[$i]=$FilterAnd[$i]&FilterField[$i]=$FilterField[$i]&FilterOperator[$i]=$FilterOperator[$i]&FilterValue[$i]=$FilterValue[$i]";
					}
				}
				$this->HTML .= "'>";
			}
		}
		
		elseif($delete_x != "")
		{
			$d = delete($SelectedID);
			if($d)
				$this->HTML .= "<div class=Error>ERROR: $d</div>";
			else
				$SelectedID = "";
		}
		
		elseif($update_x != "")
		{
			update($SelectedID);
		}
		
		elseif($Print_x != "")
		{
			// print code here ....
			$this->AllowNavigation = 0;
			$this->AllowSelection = 0;
		}
		elseif($SaveFilter_x != "" && $this->AllowSavingFilters){
			$this->HTML .= "<table width=550 border=0 align=center><tr><td class=TableTitle>" . $Translation["saved filters title"] . "</td></tr>";
			$this->HTML .= "\n\t<tr><td class=TableHeader>" . $Translation["saved filters instructions"] . "</td></tr>";
			$this->HTML .= "\n\t<tr><td class=TableHeader><textarea cols=60 rows=12 wrap=off>";

			global $HTTP_SERVER_VARS;
			$SourceCode  = "<html><body>\n";
			$SourceCode .= "<form method=post action=" . $HTTP_SERVER_VARS["HTTP_REFERER"] . ">\n";
			for($i = 1; $i <= (20 * $FiltersPerGroup); $i++) // Number of filters allowed
			{
				if($i%$FiltersPerGroup == 1 && $i != 1 && $FilterAnd[$i]!="")
				{
					$SourceCode .= "\t<input name=FilterAnd[$i] value='$FilterAnd[$i]' type=hidden>\n";
				}
				if($FilterField[$i] != "" && $FilterOperator[$i] != "" && $FilterValue[$i] != "")
				{
					if(!strstr($SourceCode, "\t<input name=FilterAnd[$i] value=")){
						$SourceCode .= "\t<input name=FilterAnd[$i] value='$FilterAnd[$i]' type=hidden>\n";
					}
					$SourceCode .= "\t<input name=FilterField[$i] value='$FilterField[$i]' type=hidden>\n";
					$SourceCode .= "\t<input name=FilterOperator[$i] value='$FilterOperator[$i]' type=hidden>\n";
					$SourceCode .= "\t<input name=FilterValue[$i] value='" . htmlspecialchars($FilterValue[$i], ENT_QUOTES) . "' type=hidden>\n\n";
				}
			}
			$SourceCode .= "\n\t<input type=submit value=\"Show Filtered Data\">\n";
			$SourceCode .= "</form>\n</body></html>";
			$this->HTML .= $SourceCode;

			$this->HTML .= "</textarea>";
			$this->HTML .= "<br><input type=submit value=\"" . $Translation["hide code"] . "\">";
			$this->HTML .= "\n\t</table>\n\n";
		}
		elseif($Filter_x != "")
		{
			// filter page code here .....
			$this->HTML .= "<table border=0 align=center><tr><td colspan=4 class=TableTitle>" . $Translation["filters"] . "</td></tr>";
			$this->HTML .= "\n\t<tr><td class=TableHeader></td><td class=TableHeader>" . $Translation["filtered field"] . "</td><td class=TableHeader>" . $Translation["comparison operator"] . "</td><td class=TableHeader>" . $Translation["comparison value"] . "</td></tr>";
			$this->HTML .= "\n\t<tr><td colspan=4 class=TableHeader></td></tr>";
			

			// get field names and captions
			$query_fields = str_replace("select ", "", $this->Query);
			$rest = strstr($this->Query, " from ");
			$query_fields = str_replace($rest, "", $query_fields);
			$field_names[] .= "";
			$field_captions[] .=  "";
			
			$is_first = 1;
			$fields_arr = explode(" as ", $query_fields);
			foreach($fields_arr as $dummy=>$field_as)
			{
				if($is_first)
				{
					$is_first = 0;
					$field_names[] = trim($field_as);
				}
				else
				{
					$exp1 = strstr($field_as, ",");
					if($exp1)
					{
						$exp2 = trim(substr($exp1,1));
						$exp3 = trim(str_replace("'", "", str_replace($exp1, "", $field_as)));
						$field_names[] = $exp2;
					}
					else
					{
						$exp3 = trim(str_replace("'", "", $field_as));
					}
					$field_captions[] = $exp3;
				}
			}

			for($i = 1; $i <= (3 * $FiltersPerGroup); $i++) // Number of filters allowed
			{
				$fields = "";
				$operators = "";

				if($i%$FiltersPerGroup == 1 && $i!=1)
				{
					$this->HTML .= "\n\t<tr><td colspan=4 class=TableHeader></td></tr>";
					$this->HTML .= "\n\t<tr><td colspan=4 align=center>";
					$seland = new Combo;
					$seland->ListItem = array($Translation["or"], $Translation["and"]);
					$seland->ListData = array("or", "and");
					$seland->SelectName = "FilterAnd[$i]";
					$seland->SelectedData = $FilterAnd[$i];
					$seland->Render();
					$this->HTML .= $seland->HTML . "</td></tr>";
					$this->HTML .= "\n\t<tr><td colspan=4 class=TableHeader></td></tr>";
				}

				$this->HTML .= "\n\t<tr><td class=TableHeader style='text-align:left;'>&nbsp;" . $Translation["filter"] . sprintf("%02d", $i) . " ";

				// And, Or select
				if($i%$FiltersPerGroup != 1)
				{
					$seland = new Combo;
					$seland->ListItem = array($Translation["and"], $Translation["or"]);
					$seland->ListData = array("and", "or");
					$seland->SelectName = "FilterAnd[$i]";
					$seland->SelectedData = $FilterAnd[$i];
					$seland->Render();
					$this->HTML .= $seland->HTML . "</td>";
				}
				else
				{
					$this->HTML .= "</td>";
				}

				// Fields list
				$selfields = new Combo;
				$selfields->SelectName = "FilterField[$i]";
				$selfields->SelectedData = $FilterField[$i];
				$selfields->ListItem = $field_captions;
				$selfields->ListData = $field_names;
				$selfields->Render();
				$this->HTML .= "\n\t\t<td>$selfields->HTML</td>";
				

				// Operators list
				$selop = new Combo;
				$selop->ListItem = array(" ", $Translation["equal to"], $Translation["not equal to"], $Translation["greater than"], $Translation["greater than or equal to"], $Translation["less than"], $Translation["less than or equal to"] , $Translation["like"] , $Translation["not like"]);
				$selop->ListData = array("", "<=>", "!=", ">", ">=", "<", "<=", "like", "not like");
				$selop->SelectName = "FilterOperator[$i]";
				$selop->SelectedData = $FilterOperator[$i];
				$selop->Render();
				$this->HTML .= "\n\t\t<td>$selop->HTML</td>";
				

				// Comparison expression
				$this->HTML .= "\n\t\t<td><input size=25 type=text name=FilterValue[$i] value=\"" . htmlspecialchars($FilterValue[$i], ENT_QUOTES) . "\" class=TextBox></td></tr>";

				if(!$i % $FiltersPerGroup)
				{
					$this->HTML .= "\n\t<tr><td colspan=4 class=TableHeader></td></tr>";
				}
			}
			$this->HTML .= "\n\t<tr><td colspan=4 class=TableHeader></td></tr>";
			$this->HTML .= "\n\t<tr><td colspan=4 align=right><input type=image src=applyFilters.gif alt='" . $Translation["apply filters"] . "'>" . ($this->AllowSavingFilters ? " &nbsp; <input type=image src=save_search.gif alt='" . $Translation["save filters"] . "' name=SaveFilter>" : "") . "</td></tr>";
			$this->HTML .= "\n</table>";
			
			// hidden variables ....
				$this->HTML .= "<input name=SortField value='".(is_numeric($SortField)? $SortField : $SortFieldNumeric)."' type=hidden>";               
				// $this->HTML .= "<input name=SelectedID value='$SelectedID' type=hidden>";          
				$this->HTML .= "<input name=SortDirection type=hidden value='$SortDirection'>";               
				$this->HTML .= "<input name=FirstRecord type=hidden value='1'>";              
			return;
		}
		elseif($NoFilter_x != "")
		{
			// clear all filters ...
			for($i = 1; $i <= (20 * $FiltersPerGroup); $i++) // Number of filters allowed
			{
				$FilterField[$i] = "";
				$FilterOperator[$i] = "";
				$FilterValue[$i] = "";
			}
			$SearchString = "";
		}
		
		if($SearchString != "")
		{
			if(!stristr($this->Query, " where "))
				$this->Query .= " where (";
			else
				$this->Query .= " and (";
			
			// get field names
			unset($field_names);
			$query_fields = str_replace("select ", "", $this->Query);
			$rest = strstr($this->Query, " from ");
			$query_fields = str_replace($rest, "", $query_fields);
			
			$is_first = 1;
			$query_modified_by_quicksearch = 0;
			$fields_arr = explode(" as ", $query_fields);
			foreach($fields_arr as $dummy=>$field_as)
			{
				if($is_first)
				{
					$is_first = 0;
					$exp1 = "any value";
					$exp2 = trim($field_as);
				}
				else
				{
					$exp1 = strstr($field_as, ",");
					if($exp1)
					{
						$exp2 = trim(substr($exp1,1));
					}
				}
				if($exp1)
				{
					$this->Query .= "$exp2 like '%" . ( get_magic_quotes_gpc()? $SearchString : addslashes($SearchString) ) . "%' or ";
					$query_modified_by_quicksearch = 1;
				}
			}

			if($query_modified_by_quicksearch)
			{
				$this->Query = substr($this->Query, 0, strlen($this->Query) - 3);
				$this->Query .= ") ";
			}
		}


	// set query filters
		$QueryHasWhere = 0;
		if(stristr($this->Query, " where "))
			$QueryHasWhere = 1;
	
		$WhereNeedsClosing = 0;
		for($i = 1; $i <= (20 * $FiltersPerGroup); $i+=$FiltersPerGroup) // Number of filters allowed
		{
			// test current filter group
			$GroupHasFilters = 0;
			for($j = 0; $j < $FiltersPerGroup; $j++)
			{
				if($FilterField[$i+$j] != "" && $FilterOperator[$i+$j] != "" && $FilterValue[$i+$j] != "")
				{
					$GroupHasFilters = 1;
					break;
				}
			}
			
			if($GroupHasFilters)
			{
				if(!stristr($this->Query, " where "))
					$this->Query .= " where (";
				elseif($QueryHasWhere)
				{
					$this->Query .= " and (";
					$QueryHasWhere = 0;
				}

				$this->Query .= " <FilterGroup> " . $FilterAnd[$i] . " (";
				
				for($j = 0; $j < $FiltersPerGroup; $j++)
				{
					if($FilterField[$i+$j] != "" && $FilterOperator[$i+$j] != "" && $FilterValue[$i+$j] != "")
					{
						$this->Query .= " <FilterItem> " . $FilterAnd[$i+$j] . " " . $FilterField[$i+$j] . " " . $FilterOperator[$i+$j] . " '" . (get_magic_quotes_gpc() ? $FilterValue[$i+$j] : addslashes($FilterValue[$i+$j])) . "' </FilterItem>";
					}
				}
				
				$this->Query .= ") </FilterGroup>";
				$WhereNeedsClosing = 1;
			}
		}
		
		if($WhereNeedsClosing)
			$this->Query .= ")";
	// set query sort
		if(!stristr($this->Query, " order by ") && $SortField != "" && $this->AllowSorting)
			$this->Query .= " order by $SortField $SortDirection";

	// retouch query
		$this->Query = str_replace("( <FilterGroup> and ", "( ", $this->Query);
		$this->Query = str_replace("( <FilterGroup> or ", "( ", $this->Query);
		$this->Query = str_replace("( <FilterItem> and ", "( ", $this->Query);
		$this->Query = str_replace("( <FilterItem> or ", "( ", $this->Query);
		$this->Query = str_replace("<FilterGroup>", "", $this->Query);
		$this->Query = str_replace("</FilterGroup>", "", $this->Query);
		$this->Query = str_replace("<FilterItem>", "", $this->Query);
		$this->Query = str_replace("</FilterItem>", "", $this->Query);
		if($this->PrimaryKey != "")
			$this->Query = str_replace(" from ", ", $this->PrimaryKey from ", $this->Query);

	// and finally, execute the query ...
		$TempQuery = eregi_replace("^select .* from ", "select count(1) from ", $this->Query);
		$TempQuery = eregi_replace(" order by .*$", "", $TempQuery);
		$TempResult = sql($TempQuery);
		$TempRow = mysql_fetch_row($TempResult);
		$TempFResult = sql($this->Query . " limit 1");
		$RecordCount = $TempRow[0];
		$FieldCount = mysql_num_fields($TempFResult) - 1;

		$t = time(); // just a random number for any purpose ...

		$this->HTML .= "<table cellspacing=1 cellpadding=0 border=0 align=center><tr>\n";
		
	// display table title and Print and Filter icons
		$this->HTML .= "<td colspan=" . ($FieldCount + 1) . ">";
		$sum_width = 0;
		for($i = 0; $i < count($this->ColWidth); $i++)
			$sum_width += $this->ColWidth[$i];
		$this->HTML .= "<table" . ($This->HideTableView ? "" : /*" width=100%"*/ '') . " cellspacing=0 cellpadding=0 border=0><tr><td align=left><div class=TableTitle>$this->TableTitle</div>";
		
	if(!$this->HideTableView)
	{
		// display quick search box
		if($this->QuickSearch > 0 && $this->QuickSearch < 4 && !$Print_x)
		{
			$this->HTML .= "<div class=TableBodySelected style='text-align:" . ( ($this->QuickSearch == 1) ? "left" : (($this->QuickSearch == 2) ? "center" : "right")) . ";'>";
			$this->HTML .= "<b>" . $this->QuickSearchText . "</b> <input type=text name=SearchString value='" . htmlspecialchars($SearchString, ENT_QUOTES) . "' size=15 class=TextBox>";
			$this->HTML .= "<input align=top border=0 name=Search type=image vspace=2 hspace=2 src=qsearch.gif alt='" . $this->QuickSearchText . "'>";
			$this->HTML .= "</div>";
		}
		// display Print icon
		if($this->AllowPrinting && !$Print_x)
			$this->HTML .= " <input type=image src=print.gif name=Print alt='" . $Translation["printer friendly view"] . "'>";
		
		// display CSV icon
		if($this->AllowCSV && !$Print_x)
			$this->HTML .= " <input type=image src=csv.gif name=CSV alt='" . $Translation["save as csv"] . "'>";
		
		// display Filter icons
		if($this->AllowFilters && !$Print_x)
			$this->HTML .= " <input type=image src=search.gif name=Filter alt='" . $Translation["edit filters"] . "'> <input type=image src=cancel_search.gif name=NoFilter alt='" . $Translation["clear filters"] . "'> ";
	}

		// display tables navigator menu
		if(!$Print_x) 
			$this->HTML .= " " . NavMenus();
		
	if(!$this->HideTableView)
	{
		$this->HTML .= "<br></td><td align=right valign=bottom></td></tr></table></td></tr>\n<tr>";
		
// Templates
	if($this->Template!=''){
		$rowTemplate = @implode('', @file('./'.$this->Template));
		if(!$rowTemplate){
			$rowTemplate='';
			$selrowTemplate = '';
		}else{
			if($this->SelectedTemplate!=''){
				$selrowTemplate = @implode('', @file('./'.$this->SelectedTemplate));
				if(!$selrowTemplate){
					$selrowTemplate='';
				}
			}else{
				$selrowTemplate = '';
			}
		}
	}else{
		$rowTemplate = '';
		$selrowTemplate = '';
	}
// End of templates

	// display table headers
		global $SortFieldNumeric;
		if($rowTemplate=='' || $this->ShowTableHeader==1){
			for($i = 0; $i < $FieldCount; $i++){
				if($this->AllowSorting == 1){
					$sort1 = "<a href='javascript: document.myform.SortDirection.value=\"asc\"; document.myform.SortField.value = ".($i + 1)."; document.myform.submit();' class=TableHeader>";
					$sort2 = "</a>";
					if(($i == $SortField - 1)||($i == $SortFieldNumeric - 1)){
						$SortDirection = ($SortDirection == "asc" ? "desc" : "asc");
						$sort1 = "<a href='javascript: document.myform.SortDirection.value=\"$SortDirection\"; document.myform.SortField.value = ".($i + 1)."; document.myform.submit();' class=TableHeader><img src=$SortDirection.gif border=0 width=11 height=11 hspace=3>";
						$SortDirection = ($SortDirection == "asc" ? "desc" : "asc");
					}
				}else{
					$sort1 = '';
					$sort2 = '';
				}
				$this->HTML .= "\t<td valign=top nowrap width='" . ($this->ColWidth[$i] ? $this->ColWidth[$i] : 100) . "' class=TableHeader><div class=TableHeader>$sort1" . mysql_field_name($TempFResult, $i) . "$sort2</div></td>\n";
			}
		}else{
			// Display a Sort by drop down
			$this->HTML .= "\t<td valign=top class=TableHeader colspan=$FieldCount><div class=TableHeader>";
			
			if($this->AllowSorting == 1)
			{
				$sortCombo = new Combo;
				$sortCombo->ListItem[] = "";
				$sortCombo->ListData[] = "";
				for($i=1; $i <= $FieldCount; $i++)
				{
					$sortCombo->ListItem[] = mysql_field_name($TempFResult, $i-1);
					$sortCombo->ListData[] = $i;
				}
				$sortCombo->SelectName = "FieldsList";
				$sortCombo->SelectedData = is_numeric($SortField) ? $SortField : $SortFieldNumeric;
				$sortCombo->Class = 'TableBody';
				$sortCombo->SelectedClass = 'TableBodySelected';
				$sortCombo->Render();
				$d = $sortCombo->HTML;
				$d = str_replace('<select ', "<select onChange=\"document.myform.SortDirection.value='$SortDirection'; document.myform.SortField.value=document.myform.FieldsList.value; document.myform.submit();\" ", $d);
				if($SortField){
					$SortDirection = ($SortDirection == "desc" ? "asc" : "desc");
					$sort = "<a href=\"javascript:document.myform.SortDirection.value='$SortDirection'; document.myform.SortField.value='$SortField'; document.myform.submit();\" class=TableHeader><img src=$SortDirection.gif border=0 width=11 height=11 hspace=3></a>";
					$SortDirection = ($SortDirection == "desc" ? "asc" : "desc");                  
				}else{
					$sort='';
				}
				
				$this->HTML .= $Translation['order by']." $d $sort";
			}
			$this->HTML .= "</div></td>\n";
		}
		
	// display vertical scroll bar ...
		if($RecordCount && $this->AllowNavigation && $RecordCount>$this->RecordsPerPage)
		{
			while($FirstRecord > $RecordCount)
				$FirstRecord -= $this->RecordsPerPage;

			if($FirstRecord == "" || $FirstRecord < 1)
				$FirstRecord = 1;
			
			$ScrollBox = $this->RecordsPerPage / $RecordCount * $this->DataHeight;
			if($ScrollBox > $this->DataHeight)
				$ScrollBox = $this->DataHeight;

			if($ScrollUp_y != "")
			{
				$FirstRecord = floor($ScrollUp_y / $ScrollBox) * $this->RecordsPerPage + 1;
			}
			elseif($ScrollDn_y != "")
			{
				$OldScrollUp = floor(($FirstRecord - 1) / $RecordCount * $this->DataHeight);
				$FirstRecord = floor(($ScrollDn_y + $ScrollBox + $OldScrollUp) / $ScrollBox) * $this->RecordsPerPage + 1;
			}
			elseif($Previous_x != "")
			{
				$FirstRecord -= $this->RecordsPerPage;
				if($FirstRecord <= 0)
					$FirstRecord = 1;
			}
			elseif($Next_x != "")
			{
				$FirstRecord += $this->RecordsPerPage;
				if($FirstRecord > $RecordCount)
					$FirstRecord = $RecordCount - ($RecordCount % $this->RecordsPerPage) + 1;
				if($FirstRecord > $RecordCount)
					$FirstRecord = $RecordCount - $this->RecordsPerPage + 1;
				if($FirstRecord <= 0)
					$FirstRecord = 1;
			}
			else
			{
				// no scrolling action took place :)
			}
			
			$ScrollUp = floor(($FirstRecord - 1) / $RecordCount * $this->DataHeight);

			$ScrollBox = floor($ScrollBox);
			if($ScrollBox < 3) // set minimum scroll box height
				$ScrollBox = 3;
			if( ($ScrollUp + $ScrollBox) > $this->DataHeight)
				$ScrollUp = $this->DataHeight - $ScrollBox;

			$ScrollDn = $this->DataHeight - $ScrollBox - $ScrollUp;

			$this->HTML .= "\t<td rowspan=1000 valign=top width=15>";
			//$this->HTML .= "<input type=image name=Previous src=scroll_previous.gif width=15 height=15>";
			//if($ScrollUp >= 1)
				//$this->HTML .= "<input type=image name=ScrollUp height=$ScrollUp src=scroll_bar.gif width=15>";
			//$this->HTML .= "<image src=scroll_box.gif height=$ScrollBox width=15>";
			//if($ScrollDn >= 1)
				//$this->HTML .= "<input type=image name=ScrollDn height=$ScrollDn width=15 src=scroll_bar.gif>";
			//$this->HTML .= "<input type=image name=Next src=scroll_next.gif width=15 height=15>";
			$this->HTML .= "</td>";

		}
		elseif($RecordCount)
		{
			$FirstRecord = 1;
			$this->RecordsPerPage = $RecordCount;
		}
	// end of scroll bar code
		
		$this->HTML .= "\n\t</tr>\n";
	}
		
	// render data
	// hidden variables ....
		$this->HTML .= "<input name=SortField value='$SortField' type=hidden>";               
		$this->HTML .= "<input name=SelectedID value='$SelectedID' type=hidden>";             
		$this->HTML .= "<input name=SortDirection type=hidden value='$SortDirection'>";               
		$this->HTML .= "<input name=FirstRecord type=hidden value='$FirstRecord'>";   
	if(!$this->HideTableView)
	{
		// filters ...
		$FiltersCode = "";
		for($i = 1; $i <= (20 * $FiltersPerGroup); $i++) // Number of filters allowed
		{
			if($i%$FiltersPerGroup == 1 && $i != 1 && $FilterAnd[$i]!="")
			{
				$FiltersCode .= "<input name=FilterAnd[$i] value='$FilterAnd[$i]' type=hidden>";
			}
			if($FilterField[$i] != "" && $FilterOperator[$i] != "" && $FilterValue[$i] != "")
			{
				if(!strstr($FiltersCode, "<input name=FilterAnd[$i] value="))
					$FiltersCode .= "<input name=FilterAnd[$i] value='$FilterAnd[$i]' type=hidden>";
				$FiltersCode .= "<input name=FilterField[$i] value='$FilterField[$i]' type=hidden>";
				$FiltersCode .= "<input name=FilterOperator[$i] value='$FilterOperator[$i]' type=hidden>";
				$FiltersCode .= "<input name=FilterValue[$i] value='" . htmlspecialchars($FilterValue[$i], ENT_QUOTES) . "' type=hidden>";
			}
		}
		$this->HTML .= $FiltersCode;
		$this->HTML = "<script language=\"javaScript\">
			<!--
				function colorize(item, color){
					var n=item.childNodes.length;
					for(var i=0; i<n; i++){
						if(item.childNodes[i].nodeName=='TD'){
							item.childNodes[i].style.backgroundColor=color;
							if(item.childNodes[i].childNodes.length>0){
								if(item.childNodes[i].childNodes[0].nodeName=='A'){
									item.childNodes[i].childNodes[0].style.backgroundColor=color;
								}
							}
						}
					}
				}
			//-->
			</script>" . $this->HTML;
	
		$i = 0;
		if($RecordCount)
		{
			$i = $FirstRecord;
			$result = sql($this->Query . " limit " . ($i-1) . ",$this->RecordsPerPage");
			while(($row = mysql_fetch_row($result)) && ($i < ($FirstRecord + $this->RecordsPerPage)))
			{
				if($fNumeric && $SelectedID != $row[$FieldCount])
					$class = "TableBodyNumeric";
				elseif($fNumeric && $SelectedID == $row[$FieldCount])
					$class = "TableBodySelectedNumeric";
				elseif(!$fNumeric && $SelectedID != $row[$FieldCount])
					$class = "TableBody";
				else
					$class = "TableBodySelected";

				$this->HTML .= "\t<tr onMouseOver=\"colorize(this, '".$this->HighlightColor."');\" onMouseOut=\"colorize(this, '');\">";
				// templates
				if($rowTemplate!=''){
					
					$rowTemp = ( ($SelectedID == $row[$FieldCount]) ? $selrowTemplate : $rowTemplate);
					
					if($this->AllowSelection == 1){
						$rowTemp = str_replace('<%%SELECT%%>',"<a href='javascript:document.myform.SelectedID.value=\"" . $row[$FieldCount] . "\"; document.myform.submit();' class=$class style=\"padding:0px;\">",$rowTemp);
						$rowTemp = str_replace('<%%ENDSELECT%%>','</a>',$rowTemp);
					}else{
						$rowTemp = str_replace('<%%SELECT%%>',"",$rowTemp);
						$rowTemp = str_replace('<%%ENDSELECT%%>','',$rowTemp);
					}
					
					for($j = 0; $j < $FieldCount; $j++){
						$rowTemp = str_replace("<%%FIELD_$j%%>", $row[$j], $rowTemp);
					}
					$this->HTML .= $rowTemp;
					$rowTemp = '';
					
				}else{
				// end of templates
					for($j = 0; $j < $FieldCount; $j++){
						$fType=mysql_field_type($result, $j);
						$fNumeric=(stristr($fType,'int') || stristr($fType,'float') || stristr($fType,'decimal') || stristr($fType,'numeric') || stristr($fType,'real') || stristr($fType,'double')) ? true : false;
						if($this->AllowSelection == 1)
						{
							$sel1 = "<a href='javascript:document.myform.SelectedID.value=\"" . $row[$FieldCount] . "\"; document.myform.submit();' class=$class style=\"padding:0px;\">";
							$sel2 = "</a>";
						}
						else
						{
							$sel1 = "";
							$sel2 = "";
						}
						
						$this->HTML .= "<td valign=top class=$class><div class=$class>&nbsp;$sel1" . $row[$j] . "$sel2&nbsp;</div></td>";
					}
				}
				$this->HTML .= "</tr>\n";
				$i++;
			}
			$i--;
		}
		if($this->ShowRecordSlots){
			for($j = $i + 1; $j < ($FirstRecord + $this->RecordsPerPage); $j++)
				$this->HTML .= "\n\t<tr><td colspan=$FieldCount><div class=TableBody>&nbsp;</div></td></tr>";
		}
	// end of data
	
		if($Print_x == ""){
			$pagesMenu='';
			if($RecordCount > $this->RecordsPerPage){
				$pagesMenu="<td align=center><div class=TableFooter>".$Translation['go to page']." <select onChange=\"document.myform.FirstRecord.value=(this.value*".$this->RecordsPerPage."+1); document.myform.submit();\">";
				for($page=0; $page<ceil($RecordCount/$this->RecordsPerPage); $page++){
					$pagesMenu.="<option value=\"$page\" ".($FirstRecord==($page*$this->RecordsPerPage+1)?'selected':'').">".($page+1)."</option>";
				}
				$pagesMenu.='</select></div></td>';
			}
			$totalWidth=array_sum($this->ColWidth);
			$totalWidth=($totalWidth>750?750:'100%');
			$this->HTML .= "\n\t<tr><td colspan=$FieldCount><table width=100%><tr class=TableFooter><td align=left><input type=image name=Previous src=previousPage.gif></td><td align=center><div class=TableFooter>" . $Translation["records x to y of z"] . "</td>$pagesMenu<td align=right><input type=image name=Next src=nextPage.gif></div></td></tr></table></td></tr>";
		}else{
			$this->HTML .= "\n\t<tr><td colspan=$FieldCount><div class=TableFooter>" . $Translation["records x to y of z"] . "</div></td></tr>";
		}
		$this->HTML = str_replace("<FirstRecord>", $FirstRecord, $this->HTML);
		$this->HTML = str_replace("<LastRecord>", $i, $this->HTML);
		$this->HTML = str_replace("<RecordCount>", $RecordCount, $this->HTML);

		// find unidentified icons
		!preg_match_all('|<img src=[^\.]+\.png border=0>|U', $this->HTML, $arrImgIcon); // <img src=gif.png border=0>
		foreach($arrImgIcon[0] as $imgIcon){
			$imgIcon=str_replace("<img src=", "", $imgIcon);
			$imgIcon=str_replace(" border=0>", "", $imgIcon);
			if(!is_file('./'.$imgIcon)){
				$this->HTML=str_replace(" src=$imgIcon ", " src=other.png ", $this->HTML);
			}
		}
	}
		
		// display details form ...
		if($this->AllowSelection)
		{
			$this->HTML .= "\n\t<tr><td align=center colspan=" . ($FieldCount + 1) . "> " . form($SelectedID, $this->AllowUpdate, (($this->HideTableView && $SelectedID) ? 0 : $this->AllowInsert), $this->AllowDelete) . " </td></tr>";
		}
		$this->HTML .= "</table>\n";

	
		$this->HTML .= "</form></center>";

		@mysql_close();
	// Das ist Alles!
	}
}


///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////


class DataCombo
{
	var $Query, // Only the first two fields of the query are used.
				// The first field is treated as the primary key (data values),
				// and the second field is the displayed data items.
		$Class,
		$Style,
		$SelectName,
		$FirstItem,     // if not empty, the first item in the combo with value of ""
		$SelectedData,  // a value compared to first field value of the query to select
					    // an item from the combo.
		
		$ItemCount, // this is returned. It indicates the number of items in the combo.
		$HTML,      // this is returned. The combo html source after calling Render().
		$MatchText; // will store the parent caption value of the matching item.
	
	function DataCombo() // Constructor function
	{
		$this->FirstItem = "";
		$this->HTML = "";
		$this->Class = "Option";
		$this->MatchText = "";
	}
	
	function Render()
	{
		$result = sql($this->Query);
		$this->ItemCount = mysql_num_rows($result);
		
		$this->HTML .= "<select name='$this->SelectName' class='$this->Class' style='$this->Style'>";
		if($this->FirstItem != "")
		{
			$this->HTML .= "\n\t<option value=''>$this->FirstItem</option>";
			$this->ItemCount ++;
		}
		
		while($row = mysql_fetch_row($result))
		{
			if($row[0] == $this->SelectedData){
				$sel = "selected class=SelectedOption";
				$this->MatchText=$row[1];
			}else
				$sel = "";
			
			$this->HTML .= "\n\t<option value='$row[0]' $sel>$row[1]</option>";
		}
		
		$this->HTML .= "\n</select>";
	}
}


///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////


class Combo
{
	// The Combo class renders a drop down combo
	// filled with elements in an array ListItem[]
	// and associates each element with data from
	// an array ListData[], and optionally selects 
	// one of the items.
	
	var $ListItem,          // array of items in the combo
		$ListData,              // array of items data values
		$Class,
		$SelectedClass,
		$Style,
		$SelectName,
		$SelectedData,
		$MatchText, // will store the text value of the matching item.
		
		$ListType, // 0: drop down combo, 1: list box, 2: radio buttons
		$ListBoxHeight, // if ListType=1, this is the height of the list box
		$RadiosPerLine, // if ListType=2, this is the number of options per line
		
		$AllowNull,

		
		$HTML;
		
	function Combo() // Constructor function
	{
		$this->Class = "Option";
		$this->SelectedClass = "SelectedOption";
		$this->HTML = "";
		$this->ListType = 0;
		$this->ListBoxHeight = 10;
		$this->RadiosPerLine = 1;
		$this->AllowNull = true;
	}
	
	function Render()
	{
		$ArrayCount = count($this->ListItem);
		
		if($ArrayCount > count($this->ListData))
		{
			$this->HTML .= "Invalid Class Definition";
			return 0;
		}
		
		if($this->ListType!=2){
			$this->HTML .= "<select name='$this->SelectName' class='$this->Class' style='$this->Style'".($this->ListType==1?" size=\"".($this->ListBoxHeight<$ArrayCount?$this->ListBoxHeight:($ArrayCount+($this->AllowNull?1:0)))."\"":"").">";
			$this->HTML .= ($this->AllowNull ? "\n\t<option value=''>&nbsp;</option>" : "");
			for($i = 0; $i < $ArrayCount; $i++){
				if($this->SelectedData == $this->ListData[$i])
					$sel = "selected class='$this->SelectedClass'";
				else
					$sel = "class=$this->Class";
				
				$this->HTML .= "\n\t<option value=\"" . $this->ListData[$i] . "\" $sel>" . $this->ListItem[$i] . "</option>";
			}
			$this->HTML .= "</select>";
		}else{
			global $Translation;
			$separator = "&nbsp; &nbsp; &nbsp; &nbsp;";
			
			if($this->AllowNull){
				$this->HTML .= "<input type=radio name=\"$this->SelectName\" value=\"\" ".($this->SelectedData==''?'checked':'')."> ".$Translation['none'];
				$this->HTML .= ($this->RadiosPerLine==1 ? "<br>" : $separator);
				$shift=2;
			}else{
				$shift=1;
			}
			for($i = 0; $i < $ArrayCount; $i++){
				if($this->SelectedData == $this->ListData[$i])
					$sel = "checked class='$this->SelectedClass'";
				else
					$sel = "class=$this->Class";
				
				$this->HTML .= "<input type=radio name=\"$this->SelectName\" value=\"" . $this->ListData[$i] . "\" $sel> ".$this->ListItem[$i];
				if(($i+$shift)%$this->RadiosPerLine){
					$this->HTML .= $separator;
				}else{
					$this->HTML .= "<br>";
				}
			}
		}
		
		return 1;
	}
}


///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////


class DateCombo
{
	// renders a date combo with a pre-selected date

	var $DateFormat,          // any combination of y,m,d
		$DefaultDate,         // format: yyyy-mm-dd
		$MinYear,
		$MaxYear,
		$MonthNames,
		$Comment,
		$NamePrefix,          // will be used in the HTML name prop as a prefix to "Year", "Month", "Day"
		$RTL,
		$CSSOptionClass,
		$CSSSelectedClass,
		$CSSCommentClass;
		
	function DateCombo()
	{
		// set default values
		$this->DateFormat = "ymd";
		$this->DefaultDate = "";
		$this->MinYear = 1900;
		$this->MaxYear = 2100;
		$this->MonthNames = "January,February,March,April,May,June,July,August,September,October,November,December";
		$this->Comment = "<empty>";
		$this->NamePrefix = "Date";
		
		$this->RTL = 0;
		$this->CSSOptionClass = "";
		$this->CSSSelectedClass = "";
		$this->CSSCommentClass = "";
	}
	
	function GetHTML($readOnly=false)
	{
		//$y : render years combo
		$years = new Combo;
		for($i=$this->MinYear; $i<=$this->MaxYear; $i++)
		{
			$years->ListItem[] = $i;
			$years->ListData[] = $i;
		}
		$years->SelectName = $this->NamePrefix . "Year";
		$years->SelectedData = substr($this->DefaultDate, 0, 4);
		$years->Class = $this->CSSOptionClass;
		$years->SelectedClass = $this->CSSSelectedClass;
		$years->Render();
		$y = ($readOnly ? substr($this->DefaultDate, 0, 4) : $years->HTML);

		//$m : render months combo
		$months = new Combo;
		for($i=1; $i<=12; $i++)
		{
			$months->ListData[] = ($i<10 ? "0$i" : $i);
		}
		$months->ListItem = explode(",", $this->MonthNames);
		$months->SelectName = $this->NamePrefix . "Month";
		$months->SelectedData = substr($this->DefaultDate, 5, 2);
		$months->Class = $this->CSSOptionClass;
		$months->SelectedClass = $this->CSSSelectedClass;
		$months->Render();
		$m = ($readOnly ? substr($this->DefaultDate, 5, 2) : $months->HTML);
		
		//$d : render days combo
		$days = new Combo;
		for($i=1; $i<=31; $i++)
		{
			$days->ListItem[] = $i;
			$days->ListData[] = ($i<10 ? "0$i" : $i);
		}
		$days->SelectName = $this->NamePrefix . "Day";
		$days->SelectedData = substr($this->DefaultDate, 8, 2);
		$days->Class = $this->CSSOptionClass;
		$days->SelectedClass = $this->CSSSelectedClass;
		$days->Render();
		$d = ($readOnly ? substr($this->DefaultDate, 8, 2) : $days->HTML);

		$p1 = substr($this->DateFormat, 0, 1);
		$p2 = substr($this->DateFormat, 1, 1);
		$p3 = substr($this->DateFormat, 2, 1);

		return "${$p1}/${$p2}/${$p3}";
	}
}

?>