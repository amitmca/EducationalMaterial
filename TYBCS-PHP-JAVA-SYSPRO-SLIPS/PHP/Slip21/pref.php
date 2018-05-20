<?php
	$msg = $_POST['msg'];
	$style = $_POST['style'];
	$size = $_POST['size'];
	$fc = $_POST['fcolor'];
	$bc = $_POST['bcolor'];

	setcookie('msg',$msg);
	setcookie('style',$style);
	setcookie('size',$size);
	setcookie('fcolor',$fc);
	setcookie('bcolor',$bc);
?>
<table border=1>
<tr>
<td><b>Message:</b></td><td><?php echo $msg?></td>
</tr>
<tr>
<td><b>Style:</b></td><td><?php echo $style?></td>
</tr>
<tr>
<td><b>Size:</b></td><td><?php echo $size?></td>
</tr>
<tr>
<td><b>Foreground Color:</b></td><td><?php echo $fc?></td>
</tr>
<tr>
<td><b>Background Color:</b></td><td><?php echo $bc?></td>
</tr>
</table><br>
<a href='set_pref.php'>Set</a>




