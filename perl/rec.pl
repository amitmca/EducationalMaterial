#!/usr/bin/perl -w

	sub recursion($n)
	{
	if($_[0]==0 || $_[0]==1)
		{
		return	1;
		}
	else
		{
		return($_[0]*recursion($_[0]-1));
		}
	}
print "Enter A number:";
$n=<STDIN>;	
$ans=&recursion($n);
print "Factorial is:$ans";
print "\n";
