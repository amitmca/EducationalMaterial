#!C:\Perl\bin\perl

print "\n\n How many Elements:";
$n=<STDIN>;
chomp $n;

print "\n\nEnter array elemnets:";
for($i=0;$i<$n;$i++)
     {
     print "\nEnter $i element:";
     $a[$i]=<STDIN>;
     chomp $a[$i];
     }
print "\n\nArray Elements are...\n";
for($i=0;$i<$n;$i++)
     {
     print $a[$i];
     print "\n";
     }
$sum=0;
for($i=0;$i<$n;$i++)
     {
     $sum=$sum+@a[$i];
     }
print "\nSum is:$sum\n";