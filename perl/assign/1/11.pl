#!C:\Perl\bin\perl

print "Content-type: text/html\n\n";
@a=1..10;
#print @a;
$n=@a;
$max=$a[0];
for($i=0;$i<$n;$i++)
     {
     print $max."\n";
     print $a[$i];
     if($max>$a[$i])
         {
         print "ok";
         }

     }