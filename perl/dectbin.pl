#!/usr/bin/perl -w

	sub dtb($n)
	{
	$i=0;

	while($_[0]>0)
		{
		@$r($i)=$dec%2;
		$i++;
		$dec=$dec/2;
		}
	for($j=$i-1;$j>=0;$j--)
		{
		print "@$r($j)";
		}
	}
print "Enter a Decimal number:";
$n=<STDIN>;	
&dtb($n);
print "\n";
