#!/usr/bin/perl -w

        sub fact($n)
        {
        $f=1;
        for($i=1;$i<=$_[0];$i++)
             {
             $f=$f*$i;
             }
        print "Factorial is:$f";
        }
print "Enter A number:";

$n=<STDIN>;
$ans=&fact($n);

