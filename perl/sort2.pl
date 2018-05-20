
my @numbers = (20,1,10,2);
my @correctly_sorted_numbers = sort {$a <=> $b} @numbers;
print "\n\nNumbers, correctly sorted\n";
print join "\n",@correctly_sorted_numbers;
