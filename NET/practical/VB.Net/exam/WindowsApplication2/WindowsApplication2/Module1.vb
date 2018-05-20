Imports System.Console

Module Module1
    Sub Main()
        Dim n As Integer
        Dim a As Integer
        Dim b As Integer
        Dim c As Integer
        Dim i As Integer
        Console.WriteLine("How many numbers:")
        n = Console.ReadLine()
        a = 0
        b = 1
        For i = 1 To n
            c = a + b
            Console.WriteLine(b)
            a = b
            b = c
        Next
        Console.ReadLine()
    End Sub
End Module
