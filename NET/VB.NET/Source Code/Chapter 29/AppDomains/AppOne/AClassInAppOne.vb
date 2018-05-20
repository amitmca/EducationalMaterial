Public Class AClassInAppOne
    Public Sub New(ByVal Msg As String)
        MsgBox("Creating Instance with messgae = " & Msg & " in AppDomain " & AppDomain.CurrentDomain.FriendlyName)
    End Sub

    Public Sub ASimpleMethod()
        MsgBox("Called In AppDomain " & AppDomain.CurrentDomain.FriendlyName)
    End Sub
End Class
