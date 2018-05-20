Imports System.Console

Module Module1
    Sub Main()
        Dim n As Integer
        Dim f As Integer
        Dim i As Integer
        Console.WriteLine("Enter A Number:")
        n = Console.ReadLine()
        f = 1
        For i = 1 To n
            f = f * i
        Next
        Console.WriteLine("Factorial is:" & f)
        Console.ReadLine()
    End Sub
End Module
