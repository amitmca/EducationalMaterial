Module Module1
Sub Main()
	Dim int1 As Integer=0
	Dim int2 As Integer=1
	Dim int3 As Integer

	On Error Goto Handler

	int3=int2 / int1

	NextLine:

	System.Console.WriteLine("Program Completed")

	Exit Sub
Handler:
	If(TypeOf Err.GetException() Is OverflowException) Then
		
		System.Console.WriteLine("Error Number{0} occured: {1} ",Err.Number,Err.Description)
	
	Resume NextLine
	End If
	Resume Next
End Sub

End Module