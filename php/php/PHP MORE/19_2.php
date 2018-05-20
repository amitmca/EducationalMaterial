<?
	session_start();
	$_SESSION['cname']=$_POST['cname'];
	$_SESSION['cadd']=$_POST['cadd'];
	$_SESSION['phno']=$_POST['phno'];
?>
<form method='POST' action='19_3.php'>
<pre><h3>
Enter the item name :<input type='text' name='iname'>
                                                                                                    
Enter the Quantity  :<input type='text' name='qty'>
                                                                                                    
Enter the item rate :<input type='text' name='rate'>
                                                                                                    
<input type='submit' name='submit'>    <input type='reset'>
</h3></pre>
</form>

