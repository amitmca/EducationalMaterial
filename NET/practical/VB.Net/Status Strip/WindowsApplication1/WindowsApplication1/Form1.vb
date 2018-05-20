Public Class Form1

    Private Sub StatusStrip1_ItemClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ToolStripItemClickedEventArgs) Handles StatusStrip1.ItemClicked

    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim x As Integer
        ToolStripProgressBar1.Minimum = 1
        ToolStripProgressBar1.Maximum = 1000
        ToolStripProgressBar1.Value = 1
        ToolStripProgressBar1.Step = 1
        For x = 1 To 10000
            ToolStripProgressBar1.PerformStep()

        Next
    End Sub

    Private Sub ToolStripProgressBar1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ToolStripProgressBar1.Click

    End Sub
End Class
