Imports Microsoft.VisualBasic
Imports System
Imports System.Data
Imports System.XML
Module m
Sub Main( )
'Try
Dim myconn As New Data.mySqlClient.mySqlConnection("server=localhost\mysql;database=aditi;")
myconn.Open()
	Console.WriteLine("Connected To Database")
 myconn.Close()
'Catch e As SqlException
	Console.WriteLine("Exception Has been Caught")
'End Try
 End Sub
End Module
