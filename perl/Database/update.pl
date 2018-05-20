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
print "Enter Roll Number to modify:";
$rno=<STDIN>;
print "Enter New Student Name:";
$name=<STDIN>;
print "Enter Newe Student Address:";
$addr=<STDIN>;
# DEFINE A MySQL QUERY
$myquery = "update student set name='$name' and addr='$addr' where rno='$rno'";

# EXECUTE THE QUERY FUNCTION
$execute = $connect->query($myquery);

print "Updated Successfully\n";
