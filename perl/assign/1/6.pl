#!C:\Perl\bin\perl

$a=10;
print "\nEnter a number:";
$b=<STDIN>;
chomp $b;
if($a==$b)
        {
        print "Success";
        }
else
        {
        print "Error";
        }