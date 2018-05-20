<?php

$db=$_SERVER['DOCUMENT_ROOT']."/oracle";

$handle=sqlite_open($db);

if($handle)
	{
	echo "<b>Successfully Connected To the database<br><br>";
	}	
else
	{
	echo "Connection to the database failed";
	}

$query="select * from emp";

$rs=sqlite_query($handle,$query);

$numrows=sqlite_num_rows($rs);

if($numrows > 0)
	{
	while($row=sqlite_fetch_array($rs))
		{
		echo "<br>";
		echo "Emp No = ";
		echo $row[0];		


		echo "<br>";
		echo "Emp Name =";
		echo $row[1];

		}
	}
 
?>