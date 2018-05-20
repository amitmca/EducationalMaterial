Module Module1
Sub Main()

	Try
		Throw New OverflowException()
	
	Catch e As Exception
		System.Console.WriteLine(e.Message)
	End Try

End Sub

End Module