<?php
	$hname=$_GET['hname'];
	$conn=pg_connect("dbname=php user=postgres password=");
	if($conn)
		echo"Connected";
	else
		echo "Error............";
		
$sql="select doctor.dno,dname,doctor.city,addr from doctor,hospital where  doctor.hno=hospital.hno and hname='$hname'";
$result=pg_query($sql);
?>
<table border=1 align=center>
<tr><th>Doctor No</th><th>Doctor Name</th><th>City</th><th>Address</th></tr>
<?php 
	while($row=pg_fetch_row($result))
	{
?>
<tr><td><?php echo $row[0]?></td>
	 <td><?php echo $row[1]?></td>
	 <td><?php echo $row[2]?></td>
	 <td><?php echo $row[3]?></td></tr>
	 <?php }?>
