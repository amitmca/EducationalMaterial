Module Module2
    Sub Main()
        Dim n As Integer
        Dim sum As Integer
        Dim r As Integer
        Dim t As Integer
        Console.WriteLine("Enter A Number:")
        n = Console.ReadLine()
        t = n
        sum = 0
        r = 0
        While n > 0
            r = n Mod 10
            sum = sum + r * r * r
            n = n / 10
        End While

        If sum = t Then
            Console.WriteLine("ArmStrong")
        Else
            Console.WriteLine("Not an Armstrong")
        End If
        Console.ReadLine()
    End Sub
End Module
