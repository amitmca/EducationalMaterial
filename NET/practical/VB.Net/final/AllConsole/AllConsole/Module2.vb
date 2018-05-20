Imports System.Console

Module Module2
    Sub main()
        Dim n As Integer
        Dim i As Integer
        Dim prime As Integer = 0
        Console.WriteLine("Enter a Number:")
        n = Console.ReadLine()
        For i = 2 To n
            If n Mod i = 0 Then
                prime = prime + 1
                Exit For
            End If
        Next
        If prime <> 0 Then
            Console.WriteLine("Not Prime")
        Else
            Console.WriteLine("Prime")
        End If

        Console.ReadLine()
    End Sub
End Module
