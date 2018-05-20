   <?php
			
	$pid=$_POST['txtpid'];
		
	echo $pid;
						
	$con=mysql_connect("localhost","root","") or die("ERROR:Connection Refused");

	$db=mysql_select_db("amit") or die("ERROR:Database Connection Refused");

	$query="select txtpass from register where txtpid=$pid";
			
	$rs=mysql_query($query) or die("ERROR:Query Not Executed");

	while($row=mysql_fetch_array($rs))
		{
		echo $row["txtpass"];
	}
    ?>