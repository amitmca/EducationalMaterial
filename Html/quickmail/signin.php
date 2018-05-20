
<?php
session_start();

$con=mysql_connect("localhost","root","") or die("ERROR:Connection Refused");

$db=mysql_select_db("quickmail") or die("ERROR:Database Connection Refused");

$usr=$_POST['txtusr'];

$pass=$_POST['txtpass'];

$query="select txtname,txtuid,txtpass from register where txtuid='".strtoupper($usr)."' and txtpass='".$pass."' ";

$rs=mysql_query($query);

$row=mysql_fetch_row($rs);

if($row)
	{
	$_SESSION['name']=$row[0];
	$_SESSION['txtuid']=$row[1];
	$_SESSION['txtpass']=$row[2];
	?>
	<script language="JavaScript">
	var d=new Date();
	var h=d.getHours();
	if(h<12)
		{
		alert("Good Morning");
		}
	else if(h>12 && h<17)
		{
		alert("Good Afternoon");
		}
	else
		{
		alert("Good Evening");
		}			
	</script>
	<?php
	echo $_SESSION['name'];	
	}

	
else
	{
	header('Location:invalid.php');	
	}	

?>

