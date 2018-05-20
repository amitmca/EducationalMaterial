#!/usr/bin/perl -w

	sub triangle($n)
	{
	$no=1;
	for($i=1;$i<=$_[0];$i++)
		{
		for($j=1;$j<=$i;$j++)
			{
			print "\t$no";
			$no=$no+1;
			}
		print "\n";
		}
	
	}
print "How many lines:";
$n=<STDIN>;	
&triangle($n);
print "\n";
