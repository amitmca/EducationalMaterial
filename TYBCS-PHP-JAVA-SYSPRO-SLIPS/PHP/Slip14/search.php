<?php
$persons=array('Ram','Sham','Gita','Seeta');
$search=$_GET['search'];
$op=$_GET['op'];


switch($op)
{
	case 1:if(in_array($search,$persons))
			echo  "$search is present in array";
			else
			echo  "$search is  not present in array";
			break;
	case 2:if(array_search($search,$persons))
			echo  "$search is present in array";
			else
			echo  "$search is  not present in array";
			break;
}

?>
