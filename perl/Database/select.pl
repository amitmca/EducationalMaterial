#!/usr/bin/perl

use Mysql;

# HTTP HEADER
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

# EXECUTE THE QUERY
$execute = $connect->query($myquery);

$rownumber = $execute->numrows();
$fieldnumber = $execute->numfields();

# PRINT THE RESULTS
print $rownumber."\n";
print $fieldnumber."\n";
