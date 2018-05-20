Public Class Form1

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        FolderBrowserDialog1.RootFolder = Environment.SpecialFolder.MyComputer
        If FolderBrowserDialog1.ShowDialog() = Windows.Forms.DialogResult.OK Then
            TextBox1.Text = FolderBrowserDialog1.SelectedPath
        End If
    End Sub
End Class
