Public Class Form2
    Dim usr As String = "amit"
    Dim p As String = "123456"
    Dim b As Boolean
    Dim b1 As Boolean
    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        uname.Text = ""
        pass.Text = ""

    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim uname1 As String
        Dim pass1 As String
        Dim f3 As New Form3
        Dim f2 As New Form2
        Dim f1 As New Form1
        uname1 = uname.Text
        pass1 = pass.Text
        b = usr.CompareTo(uname1)
        b1 = p.CompareTo(pass1)
        If b = False And b1 = False Then
            MsgBox("!!!! Congrats !!!!")
            f3.Show()
            f2.Visible = False
            f1.Visible = False
        Else
            MsgBox("!!!! Sorry  !!!!")
            uname.Text = ""
            pass.Text = ""
        End If
    End Sub
End Class