#!/usr/bin/perl

print "Content-type: text/html\n\n";
$filename="D:/Programs/perl/sub.pl";
sysopen(FH,$filename,O_RDONLY);
$line=<FH>;
while($line ne "")
       {
       print $line;
       $line=<FH>;
       }
