Module Module1
Sub Main()
	Dim int1 As Integer=0
	Dim int2 As Integer=1
	Dim int3 As Integer

	Try
		int3=int2/int1
		System.Console.WriteLine("The Answer is {0}",int3)
	Catch when Err.Number=6
		System.Console.WriteLine("Exception: Arithmetic Overflow")
	End Try

End Sub

End Module