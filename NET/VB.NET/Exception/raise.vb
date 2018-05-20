Module Module1
Sub Main()

	On Error Goto Handler

	Err.Raise(vbObjectError+51)

	System.Console.WriteLine("Program Completed")

	Exit Sub
Handler:
	System.Console.WriteLine("Error Number{0} occured: {1} ",Err.Number-vbObjectError,Err.Description)
	
End Sub

End Module