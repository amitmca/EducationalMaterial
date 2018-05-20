<?php
$conn=pg_connect("dbname=php user=postgres password=");
if($conn)
	echo"Connected";
	else
		echo"Error to connect";

$cname=$_GET['cname'];
echo $cname;

$sql="select student.sid,sname,class from student,comp,stud_comp where student.sid=stud_comp.sid and comp.cno=stud_comp.cno and rank=1 and cname='$cname'";

	$result=pg_query($sql);
			echo "<table border=2 align=center>";
		echo "<th>SID</th><th>Name</th><th>Class</th>";
while($row=pg_fetch_array($result))
	{	
		
		echo "<tr> <td>".$row['sid']."</td>";
		echo "<td>".$row['sname']."</td>";
		echo "<td>".$row['class']."</td></tr>";	
		
	}
echo "</table><br>";	
?>
