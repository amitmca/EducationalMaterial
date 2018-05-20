#!/usr/bin/perl

use Mysql;

print "Content-type: text/html \n\n";

# MYSQL CONFIG VARIABLES
$host = "localhost";
$database = "amit";
$tablename = "student";
$user = "root";
$pw = "123456";

# PERL MYSQL CONNECT()
$connect = Mysql->connect($host, $database, $user, $pw);

# SELECT DB
$connect->selectdb($database);

# DEFINE A MySQL QUERY
$myquery = "SELECT * FROM $tablename";

# EXECUTE THE QUERY FUNCTION
$execute = $connect->query($myquery);

# HTML TABLE

# FETCHROW ARRAY

while (@results = $execute->fetchrow()) {
	print "$results[0]\t$results[1]\t$results[2]\n";
}


