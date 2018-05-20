Imports System.Console
Module Module1
    Sub main()
        Dim a(10)

        Dim i As Integer
        For i = 0 To 4
            Console.WriteLine(a(i))
        Next

        Dim str1 As String
        Dim str2 As String
        Dim str As String
        Dim len As Integer
        Dim t As String = "   Amit   "
        Console.WriteLine("Enter First String:")
        str1 = Console.ReadLine()
        Console.WriteLine("Enter Second String:")
        str2 = Console.ReadLine()
        len = str1.Length
        Console.WriteLine("Length of First String is:" & len)
        str = String.Concat(str1, str2)
        Console.WriteLine("Concatenated String is:" & str)
        Console.WriteLine("Upper of First String is:" & str1.ToUpper)
        Console.WriteLine("Upper of First String is:" & UCase(str1))
        Console.WriteLine("Lower of Second String is:" & str2.ToLower)
        Console.WriteLine("Lower of Second String is:" & LCase(str2))
        'Console.WriteLine("String without Spaces is : " & t.Trim)
        Console.WriteLine("String without Right Spaces is : " & t.TrimEnd)
        Console.WriteLine("String without Left Spaces is : " & t.TrimStart)
        Console.ReadLine()
    End Sub
End Module
