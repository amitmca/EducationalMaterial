
Things to do before running the Personnel Application System:

step 1	: make directory PersonnelSystem in c:(c:\PersonnelSystem)
step 2	: place all the files included in the downloaded zip file.
		- PersonnelSystem.java
		- PersonnelSystem.class
		- PersonnelSystem$ButtonHandler.class
		- PersonnelSystem$ComboBoxHandler.class
		- ConvertValue.java
		- ConvertValue.class
		- ComputeValue.java
		- ComputeValue.class
		- personnel.mdb (access database)
step 3 	 : Setup database:
		- click CONTROL PANEL 
		- Select ODBC Data Sources
		- click UserDSN Tab (for stand alone application - for multiple workstation, click
			System DSN instead)
		- Select MS Access Database and click Add Button. Then, select Microsoft Access
 			Driver. Click Finish.
		- Give Datasource Name as Personnel ( this is the one I used in the url. You can 
			change it accordingly as you like)
		- Click Select and select personnel.mdb from c:\PersonnelSystem\personnel.mdb
		- click ok  to finish.
step 4	: run by typing c:\PersonnelSystem\java PersonnelSystem
step 5	: User ID = dhel; Password = 'a';
step 6  : Grab a coffee and start clicking!!!!


P.S.
I hope that this application system will be able to help Java developers in providing a running
example of a JDBC application. I have devoted time and effort to make the source code user-friendly.
I believe that a program should be self-documenting to harness its worth as a tool not only to users
but to developers as well. As a friend of mine said " A good programmer is not someone who does
'fantastic codes' that nobody could read it but him and him alone, but someone who is able to write
codes readable to everyone."