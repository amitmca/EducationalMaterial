#include <mysql.h>
#include <stdio.h>

main() {
   MYSQL *conn;
   MYSQL_RES *res;
   MYSQL_ROW row;

   char *server = "localhost";
   char *user = "root";
   char *password = "123456"; /* set me first */
   char *database = "amit";
   const char *db="ajit"; 
   int a;
   conn = mysql_init(NULL);

   /* Connect to database */
   if (!mysql_real_connect(conn, server,
         user, password, database, 0, NULL, 0)) {
      fprintf(stderr, "%s\n", mysql_error(conn));
      exit(1);
   }

   /* send SQL query */
   if (mysql_query(conn, "show tables")) {
      fprintf(stderr, "%s\n", mysql_error(conn));
      exit(1);
   }

   res = mysql_use_result(conn);

   /* output table name */
   printf("MySQL Tables in amit database:\n");
   while ((row = mysql_fetch_row(res)) != NULL)
      printf("%s \n", row[0]);

   a=mysql_create_db(conn,db);
   if(a)
	{
	printf("Database %s is created\n",*db);
	}	

   /* close connection */
   mysql_free_result(res);
   mysql_close(conn);
  
}

//Run the program with this ......
//[root@localhost c]#gcc -o output-file $(mysql_config --cflags) mysqlconn.c $(my sql_config --libs)
//[root@localhost c]# ./output-file 
