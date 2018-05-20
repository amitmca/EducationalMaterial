<?
	$fn = 'slip4.dat';
  	if($fp=fopen($fn,'r'))
  	{
		$head = array('Roll No','Name','Marks1','Marks2','Marks3','Percentage');
		echo '<table border=1>';
		echo '<tr bgcolor=\'red\'>';
		foreach($head as $val)
		{
			echo "<th>$val</th>";
		}
		echo '</tr>';
     		while($rec = fscanf($fp,"%d %s %d %d %d"))
     		{
        		$rec[]= ($rec[2]+$rec[3]+$rec[4])/3;
			echo '<tr>';
        		foreach($rec as $val)
        		{
           			echo "<td>$val</td>";
        		}
        		echo '</tr>';
     		}
     		echo '</table>';
     		fclose($fp);
  	}
  	else
  	{
     		die("$fn not found...");
  	}
?>  	
		
