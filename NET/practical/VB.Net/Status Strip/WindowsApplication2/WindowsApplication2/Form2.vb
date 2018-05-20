Public Class Form2

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        FolderBrowserDialog1.RootFolder = Environment.SpecialFolder.Desktop
        If FolderBrowserDialog1.ShowDialog() = Windows.Forms.DialogResult.OK Then
    End Sub
End Class