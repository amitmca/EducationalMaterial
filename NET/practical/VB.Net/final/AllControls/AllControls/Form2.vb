Public Class Form2

    Private Sub btnselect_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnselect.Click
        'FolderBrowserDialog1.RootFolder = Environment.SpecialFolder.MyComputer
        'If FolderBrowserDialog1.ShowDialog() = Windows.Forms.DialogResult.OK Then
        'txt.Text = FolderBrowserDialog1.SelectedPath
        'End If

        ToolStripStatusLabel1.Text = "Loading..."
        Dim x As Integer
        ToolStripProgressBar1.Minimum = 1
        ToolStripProgressBar1.Maximum = 1000
        ToolStripProgressBar1.Value = 1
        ToolStripProgressBar1.Step = 1
        For x = 1 To 1000
            ToolStripProgressBar1.PerformStep()
        Next
        ToolStripStatusLabel1.Text = "Loading Completed"


        If OpenFileDialog1.ShowDialog() <> Windows.Forms.DialogResult.Cancel Then
            PictureBox1.Image = Image.FromFile(OpenFileDialog1.FileName)
            txt.Text = OpenFileDialog1.FileName
        End If

        If SaveFileDialog1.ShowDialog() <> Windows.Forms.DialogResult.Cancel Then
            MsgBox("The File Is Saves with the name" & SaveFileDialog1.FileName)
        End If

        If FontDialog1.ShowDialog() <> Windows.Forms.DialogResult.Cancel Then
            RichTextBox1.Font = FontDialog1.Font
            RichTextBox1.ForeColor = FontDialog1.Color
        End If

        If ColorDialog1.ShowDialog() <> Windows.Forms.DialogResult.Cancel Then
            Me.BackColor = ColorDialog1.Color
        End If
    End Sub

   
End Class