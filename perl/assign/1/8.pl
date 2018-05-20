#!C:\Perl\bin\perl   

@a=();
@b=(10,20);
@c=qw(10 20);

print @a;
print "\n";
print @b;
print @c;

use strict;
    use warnings;

    my $developer = 'Thompson';
    my @names = qw(Kernighan Ritchie Pike $developer);
    foreach my $name (@names) {
        print "name: $name\n";
    }
