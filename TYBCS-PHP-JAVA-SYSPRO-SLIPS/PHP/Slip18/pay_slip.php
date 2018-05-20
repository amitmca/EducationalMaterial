<?php
	session_start();

	$tot = $_POST['basic']+$_POST['da']+$_POST['hra'];
?>
<table border=1>
<tr>
	<td><b>Emp No:</b></td>
	<td><?php echo $_SESSION['eno']?></td>
</tr>
<tr>
	<td><b>Name:</b></td>
	<td><?php echo $_SESSION['ename']?></td>
</tr>
<tr>
	<td><b>Address:</b></td>
	<td><?php echo $_SESSION['addr']?></td>
</tr>
<tr>
	<td><b>Basic:</b></td>
	<td><?php echo $_POST['basic']?></td>
</tr>
<tr>
	<td><b>DA:</b></td>
	<td><?php echo $_POST['da']?></td>
</tr>
<tr>
	<td><b>HRA:</b></td>
	<td><?php echo $_POST['hra']?></td>
</tr>
<tr>
	<td><b>Total:</b></td>
	<td><?php echo $tot?></td>
</tr>
