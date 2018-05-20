<?
	require_once('DB.php');

	$dsn = "pgsql://postgres:n2n@localhost/testdb";
	$db = DB::connect($dsn);
	if(DB::isError($db))
	{
		die($db->getMessage());
	}
	$sal= $_POST['sal'];
	$sql = "SELECT emp_no,emp_name,basic_sal
		FROM EMP
		WHERE basic_sal > $sal"; 	  	
	$q = $db->query($sql);
        if(DB::isError($q))
        {
                die($q->getMessage());
        }
	$head = array('Emp No','Name','Basic Salary');
	echo '<table border=1>';
	echo "<tr bgcolor='red'>";
	foreach($head as $val)
	{
		echo "<th>$val</th>";
	}
	echo "</tr>";
	while($row = $q->fetchRow())
	{
		echo '<tr>';
		foreach($row as $val)
		{
			echo "<td>$val</td>";
		}
	}
	echo "</table>";
	$q->free();
	$db->disconnect();
?>

