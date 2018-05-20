<html>
<head>
<title>pg_connect</title>
</head>
<body bgcolor="yellow">
<font color="pink"><table border=1></font>
<tr>
<th><font color="red"> Emp Name </font></th>
<th><font color="red"> Addr </font></th>
</tr>
<?php
$emp_no=$_POST['eno'];
Require_once('DB.php');
$dsn="pgsql://postgres@localhost/amit";
$db=DB::connect($dsn);
if(DB::isError($db))
	{
	die($db->getMessage());
	}
$query="select ename,addr from emp where eno='$emp_no'";
$q=$db->query($query);
if(DB::isError($q))
	{
	die($db->getMessage());
	}
while($q->fetchInto($row))
	{?>
	<tr>
	<td><center><font color="blue"><?=$row[0]?></font></center></td>
	<td><center><font color="blue"><?=$row[1]?></font></center></td>
	<td><center><font color="blue"><?=$row[2]?></font></center></td>
	</tr>
	<?php
	}
?>
