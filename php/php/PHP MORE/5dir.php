<?
	$dname=$_POST['dname'];
	echo'<table border=1>';
	$head=array('Name','Dir/File','Size');
	echo'<tr>';
	foreach($head as $val)
		echo"<th>$val</th>";
	$dh=opendir($dname);
	while(($entry=readdir($dh))!=false)
	{
		echo'<tr>';
		echo"<td>$entry</td>";
		if(is_dir($entry))
			echo'<td>Dir</td>';
		else
			echo'<td>File</td>';
		echo'<td>'.filesize($entry).'</td>';
	}
?>
