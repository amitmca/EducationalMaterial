<html>
<head>
<title>List Of Registered Students</title>
</head>
<body bgcolor="pink">
<font color="pink"><center><table border=1 cellspacing="3" cellpadding="5"></center></font>
<br><br>
<tr>
<th><font color="red" size=03> Roll Number </font></th>
<th><font color="red" size=03> First Name </font></th>
<th><font color="red" size=03> Last Name </font></th>
<th><font color="red" size=03> Class  </font></th>
<th><font color="red" size=03> Year  </font></th>
<th><font color="red" size=03> Exam Id  </font></th>
</tr>
<?php
Require_once('DB.php');
$dsn="pgsql://postgres@localhost/website";
$db=DB::connect($dsn);
if(DB::isError($db))
	{
	die($db->getMessage());
	}
$query="select rno,fname,lname,class,class1 from stud_acc order by rno asc";
$q=$db->query($query);
if(DB::isError($q))
	{
	die($db->getMessage());
	}
$query1="select examid from admin order by examid asc";
$q1=$db->query($query1);
if(DB::isError($q1))
	{
	die($db->getMessage());
	}
while($q->fetchInto($row) && $q1->fetchInto($row1))
	{?>
	<tr>
	<td><center><font color="blue" size=04><?=$row[0]?></font></center></td>
	<td><center><font color="blue" size=04><?=$row[1]?></font></center></td>
	<td><center><font color="blue" size=04><?=$row[2]?></font></center></td>
	<td><center><font color="blue" size=04><?=$row[3]?></font></center></td>
	<td><center><font color="blue" size=04><?=$row[4]?></font></center></td>
	<td><center><font color="blue" size=04><?=$row1[0]?></font></center></td>
	</tr>
	<?php
	}
?>
<center><a href="login.php"><img src="prev.gif"></a></center>
