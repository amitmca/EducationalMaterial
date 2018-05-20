Module Module1
	Sub Main()
		Dim i,j AS Integer
		i=2
		j=2
		add(i,j)
	End Sub
	
	Function add(ByVal int1 as Integer,ByVal int2 As Integer) As Long
		Dim int3 as Integer
		int3=int1+int2
		System.Console.WriteLine(int3)
	End Function		
End Module