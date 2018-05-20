

	sub fibonacci($n)
	{
	$a=0;
	$b=1;
	for($i=1;$i<=$_[0];$i++)
		{
		$c=$a+$b;
		print "\t$b";
		$a=$b;
		$b=$c;	
		}
	}
print "How many terms:";
$n=<STDIN>;	
&fibonacci($n);
print "\n";
