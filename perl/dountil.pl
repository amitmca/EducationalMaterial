#!/usr/bin/perl

print "Content-type: text/html\n\n";
$a=1;
 do
   {
   print "$a\n";
   $a=$a+1;
   }until($a<=10);