#!/usr/bin/perl

use Mysql;

$host = "localhost";
$database = "amit";
$tablename = "student";
$user = "root";
$pw = "123456";

$connect = Mysql->connect($host, $database, $user, $pw);

$connect->selectdb($database);
print "Enter Roll Number to delete:";
$rno=<STDIN>;

$myquery = "DELETE from $tablename where $rno='$rno'";

$execute = $connect->query($myquery);

print "Deleted Successfully\n";
