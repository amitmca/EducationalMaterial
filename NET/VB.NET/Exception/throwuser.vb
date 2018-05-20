Module Module1
Sub Main()

	Try
		Throw New ApplicationException("This is My Exception")
	
	Catch e As Exception
		System.Console.WriteLine(e.Message)
	End Try

End Sub

End Module