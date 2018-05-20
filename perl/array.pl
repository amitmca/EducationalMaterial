#!/usr/bin/perl


@a=(10,20,30,40);
$sum=0;
$len=@a;
print "Length Of Array is:$len";
for($i=0;$i<$len;$i++)
     {
     $sum=$sum+@a[$i];
     }
print "\nSum is:$sum";