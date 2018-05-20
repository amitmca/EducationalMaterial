
print "\n\n How many Elements in Odd Array:";
$n=<STDIN>;
chomp $n;

print "\n\nEnter data for odd array:";
for($i=0;$i<$n;$i++)
     {
     print "\nEnter $i element:";
     $a1[$i]=<STDIN>;
     chomp $a1[$i];
     }


my @sorted = sort {$a <=> $b} @a1;

print "@sorted\n";

$median=$sorted[$n/2];

print "Median is:$median";



