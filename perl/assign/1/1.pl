#!C:\Perl\bin\perl

print "\n******Program For Student Information******";
print "\nEnter Student Number:";
$no=<STDIN>;
chomp $no;

print "\nEnter Student Name:";
$name=<STDIN>;
chomp $name;

print "\nEnter Student Percentage:";
$per=<STDIN>;
chomp $per;

print "Student Information Is:\n";
print "Number\tName\tPercentage\n";
print $no."\t".$name."\t".$per."\n";