<?php
$op=$_GET['op'];
$fname=$_GET['fname'];

switch($op)
{
	case 1:echo "File Type::".filetype($fname)."<br>";
				break;
			
	case 2:if(unlink($fname))
				echo "File Deleted Sucessfully<br>";
			else
				echo "Fail to Delete file<br>";
				
}
?>
