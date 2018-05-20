#!/usr/bin/perl

print "Content-type: text/html\n\n";
open(INFILE,"C:/test.txt");
open(OUTFILE,">C:/test1.txt");

$line=<INFILE>;
while($line ne "")
       {
       print OUTFILE($line);
       $line=<INFILE>;
       }
close(INFILE);
close(OUTFILE);