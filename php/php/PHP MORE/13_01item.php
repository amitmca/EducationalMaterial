<?
		 $head=array('No.','Name','Qty','Rate','Total');
                echo'<table border=1><tr>';
                foreach($head as $val)
                        echo"<th>$val</th>";
                echo'</tr>';
                for($j=0;$j<5;$j++)
                                                                                        
                {
                        $tot=$_POST['rate'][$j]*$_POST['qty'][$j];
                      	$t+=$tot;
			$ino=$_POST['ino'][$j];
			$iname=$_POST['iname'][$j];
			$qty=$_POST['qty'][$j];
			$rate=$_POST['rate'][$j];
			echo'<tr>';
                        echo"<td>$ino</td>";
                        echo"<td>$iname</td>";
                        echo"<td>$qty</td>";
                        echo"<td>$rate</td>";
                        echo"<td>$tot</td>";
                      echo"</tr>";
                                                                                                  
                }
		echo"<tr><td><td><td></td><td>TOTAL</td><td>$t</td></tr>";
			                    
?>		
