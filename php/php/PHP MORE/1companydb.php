<?
	require_once('DB.php');
	$db = db::connect("pgsql://postgres:redhat@localhost/mydb");
	if(DB::isError($db))
	{
		echo"db not connect";
		die($db->getMessage());
	}
	$sql="select * from company";
	$q=$db->query($sql);
	if(DB::isError($q))
	{
		die($db->getMessage());
	}
	echo'<table border=1>';	
	echo'<tr><th>Com_No</th>';
	echo'<th>Com_Name</th>';
	echo'<th>Com_addr</th></tr>';
	while($q->fetchInto($row))
	{
		echo"<tr><td>$row[0]</td>";
	        echo"<td>$row[1]</td>";
        	echo"<td>$row[2]</td></tr>";
	}
?>
