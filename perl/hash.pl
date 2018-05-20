#!/usr/bin/perl

print "content-type:text/html\n\n";
%data=("n",10);

$data{"color"}="Red";
print "\n";
#delete($data{"n"});
$data{"color"}="Blue";
#print %data;
@keysa=keys(%data);
$l=@keysa;
for($i=0;$i<$l;$i++)
     {
     print "@keysa\n";
     }
@valuesa=values(%data);
$l1=@valuesa;
for($i=0;$i<$l1;$i++)
     {
     print "@valuesa\n";
     }