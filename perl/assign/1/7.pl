#!C:\Perl\bin\perl

print "***** Program to check the year is leap or not *****";

print "\n\n Enter a year:\n";
$year=<STDIN>;
chomp $year;
if(($year%400==0) || ($year%4==0) && ($year%100!=0))
                {
                $leap=1;
                }
        else
                {
                $leap=0;
                }

if($leap==1)
            {
            print "Year $year is a leap year";
             }
else
            {
            print "Year $year is not a leap year";
            }