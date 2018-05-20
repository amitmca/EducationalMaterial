#include<iostream.h>
int main()
{
sql::mysql::MySQL_Driver *driver;
sql::Connection	*con;

driver = sql::mysql::MySQL_Driver::get_mysql_driver_instance();
con = driver->connect("http://127.0.0.1:3306", "root", "");
cout<<"Connected";
delete con;
return 0;
}
