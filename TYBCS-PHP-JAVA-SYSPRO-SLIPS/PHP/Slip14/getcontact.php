<?php
	$fp=fopen('contact.dat','r');
	
	
	?>
	<table border=1><tr><th> Sr.No.</th><th>Name</th><th>Mobile</th><th>Relation</th></tr>
	<?php
	while(($rec=fgets($fp,80))!==false)
	{
		$record=explode(' ',$rec);
		
		//$record[]=($record[2]+$record[3]+$record[4])/3;
		echo "<tr>";
		foreach($record as $val)
			
				echo "<td>$val</td>";
						echo "</tr>";
			
	}
	fclose($fh);
	?>
	</table>
	

