#!C:\Perl\bin\perl 

print "Enter First String:";
$str1=<STDIN>;
chomp $str1;

print "Enter Second String:";
$str2=<STDIN>;
chomp $str2;

if($str1 eq $str2)
	{	
	print "Strings are equal";
	}
else
	{	
	print "Strings are not equal";
	}