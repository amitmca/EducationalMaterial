Public Class Form1

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim x As Integer
        ToolStripProgressBar1.Minimum = 1
        ToolStripProgressBar1.Maximum = 10000
        ToolStripProgressBar1.Value = 1
        ToolStripProgressBar1.Step = 1
        For x = 1 To 10000
            ToolStripProgressBar1.PerformStep()
        Next

    End Sub

    Private Sub StatusStrip1_ItemClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ToolStripItemClickedEventArgs) Handles StatusStrip1.ItemClicked

    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

    End Sub
End Class
