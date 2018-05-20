Module Module1
	Sub Main()
		System.Console.WriteLine(Module2.Function1())
	End Sub
End Module

Module Module2
	private Function Function1() As String 
		Return "Hello"
	End Function
End Module	