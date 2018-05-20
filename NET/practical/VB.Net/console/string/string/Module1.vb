Option Strict Off
Imports System.Console

Module Module1

    Sub Main()
        Dim str As String
        Dim str1 As String
        Dim str2 As String
        Console.WriteLine("Enter A string:")
        str = Console.ReadLine()
        Console.WriteLine("Enter Another string:")
        str1 = Console.ReadLine()
        str2 = String.Concat(str, str1)
        Console.WriteLine("Concatenated String: " & str2)
        Dim len As Integer
        len = str.Length
        Console.WriteLine("String Length is:" & len)
        Console.ReadLine()
    End Sub

End Module
