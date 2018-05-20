Option Strict Off
Imports System.Console

Module Module1

    Sub Main()
        Dim a As Integer
        Dim b As Integer

        Console.WriteLine("Enter First Number:")
        a = CInt(Console.ReadLine())
        Console.WriteLine("Enter Second Number:")
        b = CInt(Console.ReadLine())

        If a > b Then
            Console.WriteLine("Maximum is:" & a)
            Console.ReadLine()
        Else
            Console.WriteLine("Maximum is:" & b)
            Console.ReadLine()
        End If
    End Sub

End Module
