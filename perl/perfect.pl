#!/usr/bin/perl -w

sub perfect()
	{
	print "Enter a number:";
	$n=<STDIN>;
	chomp $n;
	$sum=0;
	for($i=1;$i<$n;$i++)
		{
		if($n%$i==0)
			{
			$sum=$sum+$i;
			}
		}
	if($sum==$n)
		{
		print "$n is Perfect";
		}
	else
		{
		print "$n is not Perfect";
		}
	print "\n";
	}
&perfect();
