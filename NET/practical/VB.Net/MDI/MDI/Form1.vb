Public Class Form1

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
       

    End Sub

    Private Sub FormatToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles FormatToolStripMenuItem.Click
        Dim f2 As New Form2
        f2.Show()
        f2.MdiParent = Me
    End Sub
End Class
