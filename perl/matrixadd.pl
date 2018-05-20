#!/usr/bin/perl -w

print "Number Of Rows and Columns in First Matrix==>";
$r1=<STDIN>;
chomp $r1;	
$c1=<STDIN>;
chomp $c1;

print "Number Of Rows and Columns in Second Matrix==>";
$r2=<STDIN>;
chomp $r2;	
$c2=<STDIN>;
chomp $c2;

for($i=0;$i<$r1;$i++)
	{
	for($j=0;$j<$c1;$j++)
		{
		@a[$i][$j]=<STDIN>;
		#chomp @a;
		}
	}

print "ok\n";
