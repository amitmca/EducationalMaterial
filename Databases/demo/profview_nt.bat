Rem Sample Script to run Profview on Windows NT
Rem 
Rem This assumes Java is correctly installed
Rem 

Rem Directory to use for unpacking profview application
Rem May be changed if needed
set profviewdest=%oracle_home%\plsql\demo

Rem Save classpath
set old_cp=%ClassPath%

Rem force jdbc, and ewt into the classpath
Rem
set ClassPath=%oracle_home%\jlib\ewt-3_3_18.jar;%ClassPath%
set ClassPath=%oracle_home%\jlib\share-1_1_9.jar;%ClassPath%
set ClassPath=%oracle_home%\jlib\swingall-1_1_1.jar;%ClassPath%
set ClassPath=%oracle_home%\jdbc\lib\classes111.zip;%ClassPath%

pushd %profviewdest%
mkdir oracle
cd oracle
mkdir de
cd de

Rem Extract and run the profiler viewer
set ClassPath=%profviewdest%;%profviewdest%\oracle\de;%ClassPath%
jar xf %oracle_home%\plsql\demo\profview.jar
java riw

Rem Tidyup
popd
set ClassPath=%old_cp%
