#!C:\Perl\bin

print "content-type:text/html\n\n";

%data=("n",10);

$data{"color"}="Red";

$data{"f"}="10.5";

@keysa=keys(%data);

$l=@keysa;

print "@keysa<br>";

@valuesa=values(%data);

$l1=@valuesa;

print "@valuesa<br>";

print $data{"f"};



