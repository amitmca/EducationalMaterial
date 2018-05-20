Module Module3
    Sub Main()
        Dim n As Integer
        Dim sum As Integer
        Dim i As Integer

        Console.WriteLine("Enter A Number:")
        n = Console.ReadLine()

        For i = 1 To n
            If n Mod i = 0 Then
                sum = sum + i
                Console.WriteLine(sum)
            End If
        Next

        If sum = n Then
            Console.WriteLine("Perfect")
        Else
            Console.WriteLine("Not an Perfect")
        End If
        Console.ReadLine()
    End Sub
End Module
