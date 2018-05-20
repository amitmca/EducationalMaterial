#!/usr/bin/perl

print "Content-type: text/html\n\n";

%data=("n",10,"color","red","f",10.5);
print $data{"n"};
@key=keys(%data);
$l=@key;
print "\nLength of Hash Array is:$l";