#!/usr/bin/env perl
$f=1;
$i=1;
print "Enter a number:";
$n=<STDIN>;
while($i<=$n)
	{
	$f=$f*$i;
	$i++;
	}
print $f;
rmdir("amit");
print "Directory has been deleted";
