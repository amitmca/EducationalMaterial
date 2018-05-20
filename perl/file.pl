 #!/usr/local/bin/perl

 if (open(MYFILE, "first.pl")) {
 $line = <MYFILE>;
 while ($line ne "") {
 print ($line);
 $line = <MYFILE>;
 }
 }
system("type first.pl");