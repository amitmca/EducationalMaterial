<?
	$dn = $_POST['dir'];
	$dh = opendir($dn);
  	$head = array('Name','D/F','Size','r','w','x','Change','Access','Modify','Type');
  	echo '<table>';
  	echo '<tr bgcolor=\'red\'>';
  	foreach($head as $val)
  	{
     		echo "<th>$val</th>";
  	}
  	echo '</tr>';
  	while($de = readdir($dh))
  	{
     		echo '<tr>';	
    		echo "<td>$de</td>";
     		if(is_dir($de))
		{
			echo '<td>D</td>';
		}
     		if(is_file($de))
		{
			echo '<td>F</td>';
		}
     		echo '<td>'.filesize($de).'</td>';
     		if(is_readable($de))
		{
			echo '<td>r</td>';
		}	
     		else
		{
			echo '<td>-</td>';
		}	
     		if(is_writeable($de))
        	{
			echo '<td>w</td>';
		}
     		else
        	{
			echo '<td>-</td>';
		}
     		if(is_executable($de))
		{
        		echo '<td>x</td>';
		}
     		else
        	{
			echo '<td>-</td>';
		}
     		echo '<td>'.date('d-m-y H:i:s',filectime($de)).'</td>';
     		echo '<td>'.date('d-m-y H:i:s',fileatime($de)).'</td>';
     		echo '<td>'.date('d-m-y H:i:s',filemtime($de)).'</td>';
     		echo '<td>'.filetype($de).'</td>';
     		echo '</tr>';
  	}
  	echo '</table>';
  	closedir($dh);
?>
		

     
		
