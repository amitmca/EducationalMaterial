print "\n\n How many Elements in Even Array:";
$n1=<STDIN>;
chomp $n1;

print "\n\nEnter data for Even array:";
for($j=0;$j<$n1;$j++)
     {
     print "\nEnter $j element:";
     $c1[$j]=<STDIN>;
     chomp $c1[$j];
     }


my @sorted1 = sort {$c <=> $d} @c1;

print "@sorted1\n";


        $m1=$sorted1[($n1/2)-1];

        $m2=$sorted1[($n1/2)];

        $median1=($m1+$m2)/2;
        
print "Median is:$median1";
