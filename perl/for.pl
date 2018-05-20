#!/usr/bin/perl

print "content-type: text/html \n\n";

# SET UP THE HTML TABLE
print "<table border='1'>";

# START THE LOOP, $i is the most common counter name for a loop!
for($i = 1; $i < 5; $i++) {
	# PRINT A NEW ROW EACH TIME THROUGH W/ INCREMENT
	print "<tr><td>$i</td><td>This is row $i</td></tr>";
}
# FINISH THE TABLE
print "</table>";
