<?php
//--This statement is compulsory to use session variables and initialize it. 
		session_start();  
		session_register("Time");
//--This code is to set value for session variable Time only once.
		if(!isset($_SESSION["Time"])):
			$_SESSION["Time"]=mktime();
		endif;
//-------------------------------------------------------------------------------------------
//This code is for redirect to Timeout.html after 10 seconds when the refresh button is press

		if((mktime() - $_SESSION["Time"])>10):
			session_unset();
			header("Location : Timeout.html");
		endif;
//-------------------------------------------------------------------------------------------
?> 
<form name="form1" method="post" action="9_3session.php">
  <table width="75%" border="1" align="center">
			<tr> 
			  <td>Name</td>
			  <td> 
				<input type="text" name="Name">
			  </td>
			</tr>
			<tr> 
			  <td>City</td>
			  <td> 
				<input type="text" name="City">
			  </td>
			</tr>
			<tr> 
			  <td>Phone Number</td>
			  <td> 
				<input type="text" name="PhoneNumber">
			  </td>
			</tr>
			<tr> 
			  <td colspan="2"> 
				<div align="center">
				  <input type="submit" name="Submit" value="Submit">
				</div>
			  </td>
			</tr>
		  </table>
		</form>
