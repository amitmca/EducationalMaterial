<?php
	$fname = 'student.dat';
	
	
	$fh = fopen($fname,"r");

?>

<table border=1>
<tr><th>Roll No</th><th>Name</th><th>Marks 1</th><th>Marks 2</th><th>Marks 3</th><th>Percentage</th></tr>

<?php

	while(($rec=fgets($fh,80))!==false)
	
	{

		$record = explode(' ',$rec);
			

		$record[] = ($record[2]+$record[3]+$record[4])/3;
	//echo $record[0];
	
		
		echo "<tr>";

		foreach($record as $val)

			echo "<td>$val</td>";

		echo "</tr>";

	}

	fclose($fh);

?>
</table>
