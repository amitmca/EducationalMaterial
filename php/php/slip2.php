<?
	function printTable($db, $sql, $head)
	{
        	$q = $db->query($sql);
 	       	if(DB::isError($q))
        	{
                	die($q->getMessage());
	        }
        	echo '<table border=1>';
	        echo "<tr bgcolor='red'>";
        	foreach($head as $val)
	        {
        	        echo "<td>$val</td>";
	        }
        	echo "</tr>";
	        while($row = $q->fetchRow())
        	{
                	echo '<tr>';
	                foreach($row as $val)
        	        {
                	        echo "<td>$val</td>";
	                }
        	}
	        echo "</table>";
        	$q->free();
	}

	require_once('DB.php');
	$dsn = "pgsql://postgres:n2n@localhost/testdb";
	$db = DB::connect($dsn);
	if(DB::isError($db))
	{
		die($db->getMessage());
	}
	$an =  $_POST['actor'];
	$sql = "SELECT MOVIE.movie_no,movie_name,release_year
		FROM MOVIE,ACTOR,MA
		WHERE MOVIE.movie_no = MA.movie_no AND
		      ACTOR.actor_no = MA.actor_no AND
		      actor_name = '$an'"; 	  	
	$head = array('Movie No','Name','Release Year');
	printTable($db,$sql,$head);

	$mn = $_POST['movie'];
        $sql = "SELECT ACTOR.actor_no,actor_name
                FROM MOVIE,ACTOR,MA
                WHERE MOVIE.movie_no = MA.movie_no AND
                      ACTOR.actor_no = MA.actor_no AND
                      movie_name = '$mn'";
        $head = array('Actor No','Name');
        printTable($db,$sql,$head);
       
	$db->disconnect();
?>

