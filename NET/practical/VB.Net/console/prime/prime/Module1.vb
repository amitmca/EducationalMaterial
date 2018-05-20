Option Strict Off
Imports System.Console
Module Module1

    Sub Main()
        Dim n As Integer
        Dim i As Integer
        Dim count As Integer
        count = 0
        Console.WriteLine("Enter A Number:")
        n = CInt(Console.ReadLine())
        For i = 2 To n
            If n Mod i = 0 Then
                count = count + 1
                Exit For
            End If
        Next
        Console.Write(count)
        If count > 0 Then
            Console.WriteLine("Number is prime")
            Console.ReadLine()
        Else
            Console.WriteLine("Number is not prime")
            Console.ReadLine()
        End If
    End Sub

End Module
