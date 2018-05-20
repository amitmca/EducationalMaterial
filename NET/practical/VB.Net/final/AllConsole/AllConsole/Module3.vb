Module Module3
    Sub main()
        Dim str1 As String
        Dim str2 As String
        Dim str As String
        Dim len As Integer
        Console.WriteLine("Enter first String:")
        str1 = Console.ReadLine()
        len = str1.Length
        Console.WriteLine("String length:" & len)
        Console.WriteLine("Enter second String:")
        str2 = Console.ReadLine()
        str = String.Concat(str1, str2)
        Console.WriteLine("Concatenated String is:" & str)
        Console.ReadLine()

    End Sub
End Module
