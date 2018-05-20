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

for($i=1;$i<=$n;$i++)
     {
     for($j=1;$j<=$n;$j++)
          {
          if($a[$i] lt $a[$j])
              {
              $t=@a[$i];
              @a[$i]=@a[$j];
              @a[$j]=$t;
              }
          }
      }
print "\nSorted Elements are:\n\n";
for($i=0;$i<$n;$i++)
     {
     print $a[$i];
     print "\n";
     }
