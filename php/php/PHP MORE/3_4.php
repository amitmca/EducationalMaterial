<?
	require_once('DB.php');
        $db = db::connect("pgsql://postgres:redhat@localhost/mydb");
        if(DB::isError($db))
        {
                die($db->getMessage());
        }
	if($_POST['ino'])
	{
		$ino=$_POST['ino'];
                $iname=$_POST['iname'];
		$qty=$_POST['qty'];
		$rate=$_POST['rate'];
		$mstk=$_POST['mstk'];
		
		$sql="insert into item values
		($ino,'$iname',$qty,$rate,$mstk)";
	        $q=$db->query($sql);
        	if(DB::isError($q))
        	{
                	die('<h1>'.$q->getmessage());
        	}
		else
			echo"<h1>Item is inserted successfully";
	}
	else
	{
                $in=$_POST['iname'];
                $sql="select * from item where item.i_name='$in'";
                $q=$db->query($sql);
                if(DB::isError($q))
                {
                        die('<h1>'.$q->getmessage());
                }
                if($q->fetchrow())
		{
                	echo"<h1>Item is Found";
		}
		else
		{
			echo"<h1>Item Not found";
		}

	}
	
?>
