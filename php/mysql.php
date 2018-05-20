<?php
$conn=mysql_connect("localhost","root","123456") or die("Error");

$db=mysql_select_db("amit") or die("Database selection failed");

$query2="update emp set ename='amjit' where eno=10";

$rs2=mysql_query($query2) or die("Updation Failed");

echo "\nUpdated Successfully\n";

$query1="insert into emp values(40,'sarang')";

$rs1=mysql_query($query1) or die("Insertion Failed");

echo "\nInserted Successfully\n";

$query3="delete from emp where eno=10";

$rs3=mysql_query($query3) or die("Deletion Failed");

echo "\nDeleted Successfully\n";

$query="select * from emp";

$rs=mysql_query($query) or die("Query not executed");

while($row=mysql_fetch_array($rs))
	{
	echo $row["eno"]."\t".$row["ename"]."\n";
	}
?>

