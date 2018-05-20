<?php
echo "Client Ip address  <b>".$_SERVER['REMOTE_ADDR']."<br><br>";
echo "Browser Detection /Information :".$_SERVER['HTTP_USER_AGENT']."<br></b>"	;
echo "<br>Page Come from HTTPS?";
	if($_SERVER['HTTPS']!=='on')
			echo "     <br>Ans : NO<br>";
	else
				echo "   Yes<br>";

?>
