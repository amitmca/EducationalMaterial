Public Class Form5

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim x As Integer
        ToolStripStatusLabel1.Text = "Preparing to load..."
        ToolStripProgressBar1.Minimum = 1
        ToolStripProgressBar1.Maximum = 1000
        ToolStripProgressBar1.Value = 1
        ToolStripProgressBar1.Step = 1
        For x = 1 To 1000
            ' ToolStripStatusLabel1.Text = "Loading..."
            ToolStripProgressBar1.PerformStep()
        Next
        ToolStripStatusLabel1.Text = "Loading Completed..."
    End Sub
End Class