<?php
$dname=$_GET['dname'];
	$conn=pg_connect("dbname=php user=postgres password=");
	if($conn)
		echo "Conntected";
	else
		echo "Error ........";
		
$sql="select max(salary),min(salary),sum(salary) from emp,dept where emp.d_no=dept.d_no and dname='$dname'";
echo "$sql";
$result=pg_query($sql);
$row=pg_fetch_row($result);
?>
<table border=1>
<tr><th>Maximum</th><th>Minimum</th><th>Sum Salary</th></tr>
<tr><td><?php echo $row[0]?></td>
	<td><?php echo $row[1]?></td>
	<td><?php echo $row[2]?></td></tr></table>
