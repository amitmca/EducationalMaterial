
print "\n\n How many Elements:";
$n=<STDIN>;
chomp $n;

print "\n\nEnter data:";
for($i=0;$i<$n;$i++)
     {
     print "\nEnter $i element:";
     $a1[$i]=<STDIN>;
     chomp $a1[$i];
     }


my @sorted = sort {$a <=> $b} @a1;

print "@sorted\n";

if($n%2==1)
        {
        $median=$sorted[$n/2];
        }
else
        {
        $m1=$sorted[($n/2)-1];

        $m2=$sorted[($n/2)];

        $median=($m1+$m2)/2;
        }
print "Median is:$median";

$sum=0;

for($i=0;$i<$n;$i++)
        {
        $sum=$sum+@sorted[$i];
        }
$mean=$sum/$n;
print "\nMean :$mean";
