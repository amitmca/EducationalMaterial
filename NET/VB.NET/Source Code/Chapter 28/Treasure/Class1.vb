Imports System.Security.Principal
Imports System.Security.Permissions
Imports System.Threading

Public Class MoneyBox

    Function Money() As String
        'AppDomain.CurrentDomain.SetPrincipalPolicy(PrincipalPolicy.WindowsPrincipal)
        'Dim WP As WindowsPrincipal = Thread.CurrentPrincipal
        'If WP.Identity.Name = "ANIL\KumarAnil" Then
        '    Return "Stop trying Peter"
        'Else
            Return "Lots of money."
        'End If
    End Function

End Class
