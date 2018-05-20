#!C:\Perl\bin

# PERL MODULE
use Mysql;

# HTTP HEADER
print "Content-type: text/html \n\n";

# CONFIG VARIABLES
$host = "localhost";
$database = "amit";
$tablename = "emp";
$user = "root";
$pw = " ";

# PERL MYSQL CONNECT
$connect = Mysql->connect($host, $database, $user, $pw);


print "Connected Successfully";
