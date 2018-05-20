#include<stdafx.h>
#include <sql.h>
#include <sqlext.h>
#include <sqltypes.h>
#include <iostream>
using namespace std;
int _tmain(int argc, _TCHAR* argv[])
{
SQLHENV sql_hEnv = 0;
SQLHDBC sql_hDBC = 0;
SQLHSTMT sql_hStmt = 0;
SQLCHAR szDNS[1024] ={0};
SQLSMALLINT nSize = 0;
SQLRETURN sqlRet =
SQLAllocHandle( SQL_HANDLE_ENV,
SQL_NULL_HANDLE,
&sql_hEnv );
sqlRet =
SQLSetEnvAttr( sql_hEnv,
SQL_ATTR_ODBC_VERSION,
(void*) SQL_OV_ODBC3,
0 );
sqlRet =
SQLAllocHandle( SQL_HANDLE_DBC,
sql_hEnv,
&sql_hDBC );
// if 0 - use SQLDriverConnect
// if 1 - use SQLConnect
//
#if 0
sqlRet =
SQLConnect( sql_hDBC,
(SQLCHAR*)"MySQL",
SQL_NTS,
(SQLCHAR*)"root",
SQL_NTS,
(SQLCHAR*)"admin",
SQL_NTS );
#else
sqlRet =
SQLDriverConnect( sql_hDBC,
0,
(SQLCHAR*)"DSN=mysql;UID=root;PWD=;",
SQL_NTS,
szDNS,
1024,
&nSize,
SQL_DRIVER_COMPLETE );
#endif
if( SQL_SUCCEEDED( sqlRet ) )
{
cout << "Connected to database " << endl
<< "Connection Info: " << endl
<< szDNS << endl;
}
return 0;
}
