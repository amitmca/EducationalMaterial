<?
	$myfile=fopen("4_2stud.dat","r");
	if($myfile)
	{
		$tab=array('No.','Name','Marks1','Marks2','Marks3','Percentage');
		echo"<table border=1>";
		echo'<tr>';
		foreach($tab as $val)
			echo"<th>$val</th>";
		echo'</tr>';
		$record=fscanf($myfile,"%d%s%d%d%d");
		while(!feof($myfile))
		{
			$record[]=($record[2]+$record[3]+$record[4])/3;
			echo'<tr>';
			foreach($record as $val)
				echo"<td>$val</td>";
			echo'</tr>';
			 $record=fscanf($myfile,"%d%s%d%d%d");
		}
		fclose($myfile);
	}
	else
		echo"File Can't Open";
?>
