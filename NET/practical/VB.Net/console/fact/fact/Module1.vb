Option Strict Off
Imports System.Console


Module Module1

    Sub Main()
        Dim f As Integer
        Dim i As Integer
        Dim n As Integer
        Console.WriteLine("Enter A number:")
        n = CInt(Console.ReadLine())
        f = 1
        For i = 1 To n
            f = f * i
        Next
        Console.WriteLine("Factorial is : " & f)
        Console.Read()
    End Sub

End Module