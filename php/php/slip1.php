<?
	require_once('DB.php');
	$dsn = "pgsql://postgres:n2n@localhost/testdb";
	$db = DB::connect($dsn);
	if(DB::isError($db))
	{
		die($db->getMessage());
	}
	$hn = $_POST['hosp'];
	$sql = "SELECT DOCTOR.doc_no,doc_name,address,city,area
		FROM DOCTOR,HOSPITAL,DOC_HOSP
		WHERE DOCTOR.doc_no = DOC_HOSP.doc_no AND
		      HOSPITAL.hosp_no = DOC_HOSP.hosp_no AND
		      hosp_name = '$hn'"; 	  	
	$q = $db->query($sql);
        if(DB::isError($q))
        {
                die($q->getMessage());
        }
	$head = array('Doctor No','Name','Address','City','Area');
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

