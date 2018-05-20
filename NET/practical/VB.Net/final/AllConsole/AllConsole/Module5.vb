Imports System.Console
Module Module5
    Sub main()
        Dim radius As Double
        Dim area As Double
        Console.WriteLine("Enter The Radius:")
        radius = Console.ReadLine()
        area = 2 * 3.14 * radius * radius
        Console.WriteLine("Area Of Circle with radius " & radius & " is= " & area)
        Console.ReadLine()
    End Sub
End Module
