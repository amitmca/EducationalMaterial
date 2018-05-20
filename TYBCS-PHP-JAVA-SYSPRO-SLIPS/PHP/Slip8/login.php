<?php
	session_start();
		if(isset($_SESSION['count']))
			{
				$count=$_SESSION['count'];
			}
			else
			{
				$count=0;
			}
				$count++;
			$_SESSION['count']=$count;
		
			echo $count."<br>";
			$user=$_POST['user'];
			$pass=$_POST['pass'];
			if(isset($user) && isset($pass) && $count<=3 && $user==$pass)
			{
			$_SESSION['count']=0;
				$ok=true;
				echo "<h3>Welcome Login Sucessfully</h3>";
				
			}
			if($count>3)
			{
				echo "3 attempts are over";
			}
			
			if(!$ok && $count<=3)
			{
?>
			<form method="POST" action="login.php">
			User Name::<input type=text name=user><br>
			Password::<input type =password name=pass><br>
			<input type=submit value=ok><input type=reset value=Reset> 
			</form>			
			<?}?>


