#!/usr/bin/perl -w

sub isprime($x)
	{
	for($i=2;$i<=$_[0]-1;$i++)
		{
		if($_[0]%$i==0)
			{
			return 0;
			}
		}
	return 1;
	}
print "How many numbers:";
$n=<STDIN>;
print "2";
$count=2;
$number=3;
while($count<=$n)
	{
	if(&isprime($number))
		{
		print "\t$number";
		$count++;
		}
	$number=$number+1;
	}
print "\n";
