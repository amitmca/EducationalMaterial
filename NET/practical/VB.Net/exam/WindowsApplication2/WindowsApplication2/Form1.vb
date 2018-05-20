Public Class Form1



    Private Sub btnadd_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnadd.Click
        Dim x As Integer
        ToolStripProgressBar1.Minimum = 1
        ToolStripProgressBar1.Maximum = 1000
        ToolStripProgressBar1.Value = 1
        ToolStripProgressBar1.Step = 1
        list.Items.Add(txt.Text)
        txt.Text = ""
        txt.Focus()
        For x = 1 To 1000
            ToolStripProgressBar1.PerformStep()
        Next
        ToolStripProgressBar1.Value = 1
    End Sub

    Private Sub btndel_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btndel.Click
        list.Items.RemoveAt(list.SelectedIndex)
        txt.Focus()
    End Sub

    Private Sub btnclr_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnclr.Click
        list.Items.Clear()
    End Sub
End Class
