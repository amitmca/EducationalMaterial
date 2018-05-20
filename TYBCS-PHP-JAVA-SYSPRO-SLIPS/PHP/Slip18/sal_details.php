<?php
	session_start();

	$_SESSION['eno'] = $_POST['eno'];
	$_SESSION['ename'] = $_POST['ename'];
	$_SESSION['addr'] = $_POST['addr'];
?>
<form method='post' action='pay_slip.php'>
<h2>Earnings of Employee:</h2>
<table>
<tr>
	<td><b>Basic:</b></td>
	<td><input type="text" name="basic"></td>
<tr>
<tr>
	<td><b>DA:</b></td>
	<td><input type="text" name="da"></td>
</tr>
<tr>
	<td><b>HRA:</b></td>
	<td><input type="text" name="hra"></td>
</tr>
<tr>
	<td><input type='submit'></td>
	<td><input type='reset'></td>
</tr>
</table>
</form>

