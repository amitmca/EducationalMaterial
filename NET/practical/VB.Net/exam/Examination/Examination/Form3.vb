Public Class Form3

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim f1 As New Form1
        f1.Show()
        f1.MdiParent = Me
    End Sub
End Class