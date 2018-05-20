Module Module1
Sub Main()
	Dim int1 As Integer=0
	Dim int2 As Integer=1
	Dim int3 As Integer

	On Error Goto Handler

	int3=int2 / int1

	System.Console.WriteLine("The Answer is {0}",int3)

	Exit Sub
Handler:
	System.Console.WriteLine("Divide By Zero Error")
	Resume Next
End Sub

End Module