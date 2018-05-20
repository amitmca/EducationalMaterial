Module Module2
    Sub main()
        Dim a(10)
        Dim t As Integer
        Dim n As Integer
        Dim i As Integer
        Dim j As Integer
        Dim sum As Integer

        Console.WriteLine("How Many Numbers:")
        n = Console.ReadLine()
        sum = 0
        Console.WriteLine("Enter the array elements")
        For i = 0 To n - 1
            a(i) = Console.ReadLine()
            sum = sum + a(i)
        Next

        Console.WriteLine("Before Sorting....")
        For i = 0 To n - 1
            Console.WriteLine(a(i))
        Next

        For i = 0 To n - 1
            For j = 0 To n - 1
                If a(i) < a(j) Then
                    t = a(i)
                    a(i) = a(j)
                    a(j) = t
                End If
            Next
        Next

        Console.WriteLine("After Sorting....")
        For i = 0 To n
            Console.WriteLine(a(i))
        Next
        Console.WriteLine("Sum is:" & sum)
        Console.ReadLine()
    End Sub
End Module
