Imports System.Console
Module Module4
    Sub main()
        Dim f As Integer
        Dim c As Integer
        Console.WriteLine("Enter the Temprature in Celcius:")
        c = Console.ReadLine()
        f = (9 / 5) * (c + 32)
        Console.WriteLine("Temprature in Farenhite is : " & f)

        Console.WriteLine("Enter the Temprature in Farenhite :")
        f = Console.ReadLine()
        c = (5 / 9) * (f - 32)
        Console.WriteLine("Temprature in Celcius is : " & c)

        Console.ReadLine()
    End Sub
End Module
