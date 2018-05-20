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
print "Enter Roll Number:";
$rno=<STDIN>;
print "Enter Student Name:";
$name=<STDIN>;
print "Enter Student Address:";
$addr=<STDIN>;
# DEFINE A MySQL QUERY
$myquery = "INSERT INTO 
$tablename (rno, name,addr) 
VALUES ('$rno','$name','$addr')";

# EXECUTE THE QUERY FUNCTION
$execute = $connect->query($myquery);

print "Inserted Successfully\n";
