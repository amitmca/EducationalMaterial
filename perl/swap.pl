#!/usr/bin/perl -w

	sub swap($a,$b)
	{
	$t=$_[0];
	$_[0]=$_[1];
	$_[1]=$t;
	}
print "Enter First Number==>";
$a=<STDIN>;
chomp $a;	
print "Enter Second Number==>";
$b=<STDIN>;
chomp $b;
print "Before Swapping:$a and $b\n";
&swap($a,$b);
print "After Swapping:$a and $b";
print "\n";
