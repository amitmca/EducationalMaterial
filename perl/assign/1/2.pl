#!C:\Perl\bin\perl

print "****** Program For Converting tempretures ******\n";

print "\n\n Enter the temprature in Celcius:";
$c=<STDIN>;
chomp $c;

$f=(9/5)*$c+32;

print "\n  Temprature in Farenhite:$f";

print "\n\n Enter the temprature in Farenhite:";
$f=<STDIN>;
chomp $f;

$c=(5/9)*($f-32);

print "\n  Temprature in Celcius:$c";

