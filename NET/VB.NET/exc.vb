Imports System 

Public Class myexception
	Shared Sub Main()

	Dim a As Integer=5
	Dim b As Integer=5
	Dim c As Integer

	Try
		c=a/b
	Catch e As Exception
		Console.WriteLine("Exception Caught")

	Finally
		Console.WriteLine("In Finally{0}  ",a*5)
	End Try

	End Sub

End Class