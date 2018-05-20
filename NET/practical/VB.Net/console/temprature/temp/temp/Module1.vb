Option Strict Off
Imports System.Console

Module Module1

    Sub Main()
        Dim c As Integer
        Dim f As Integer
        Console.WriteLine("Enter the Temprature in Celcius:")
        c = Console.ReadLine()
        f = (9 / 5) * (c + 32)
        Console.WriteLine("Temprature in Farenhite:" & f)
        Console.ReadLine()
    End Sub

End Module
