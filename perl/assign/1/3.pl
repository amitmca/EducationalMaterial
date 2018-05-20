#!C:\Perl\bin\perl

print "****** Program for using function ******";

sub hello()
	{
	print "\nHello";
	}
sub world()
	{	
	&hello();
	print "  World";
	}
&world();
