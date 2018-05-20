<?
	require_once('DB.php');
	$dsn = "pgsql://postgres:n2n@localhost/testdb";
	$db = DB::connect($dsn);
	if(DB::isError($db))
	{
		die($db->getMessage());
	}
	if($_POST['op']=='add')
	{
		$ino = $_POST['ino'];
		$iname = $_POST['iname'];
		$qty = $_POST['qty'];
	
		$sql = "INSERT INTO ITEM VALUES($ino,'$iname',$qty)"; 	  	
		$q = $db->query($sql);
        	if(DB::isError($q))
        	{
                	die($q->getMessage());
        	}
		echo "Record Inserted Successfully...<br>";
	}
	elseif($_POST['op']=='search')
	{
		$in = $_POST['iname'];
		$sql = "SELECT item_no,item_name,qty FROM ITEM WHERE item_name='$in'";
		$q = $db->query($sql);
               	if(DB::isError($q))
                {
                        die($q->getMessage());
                }
		$row = $q->fetchRow();
                echo "Item No: $row[0]<br>Item Name: $row[1]<br>Qty: $row[2]<br>";
		$q->free();
	}
	echo "<a href='slip3.html'>Go Back</a>";
	$db->disconnect();
?>

