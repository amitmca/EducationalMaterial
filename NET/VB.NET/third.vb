Imports System 

Public Class third
	Shared Sub Main()

	Dim h As Integer
	
	h=14


	If(h<12) Then
		Console.WriteLine("Good Morning")
	End If

	If(h>=12) And (h<18) Then
		Console.WriteLine("Good Afternoon")
	End If

	If(h>=18) Then
		Console.WriteLine("Good Evening")
	End If

	End Sub
End Class