Public Class Form1

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        FolderBrowserDialog1.RootFolder = Environment.SpecialFolder.MyComputer
        If FolderBrowserDialog1.ShowDialog() <> Windows.Forms.DialogResult.Cancel Then
            txt.Text = FolderBrowserDialog1.SelectedPath
        End If
    End Sub

    Private Sub hsbred_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles hsbred.Scroll
        Label1.ForeColor = ColorTranslator.FromOle(RGB(hsbred.Value, hsbgreen.Value, hsbblue.Value))
    End Sub

    Private Sub hsbgreen_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles hsbgreen.Scroll
        Label1.ForeColor = ColorTranslator.FromOle(RGB(hsbred.Value, hsbgreen.Value, hsbblue.Value))
    End Sub

    Private Sub hsbblue_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles hsbblue.Scroll
        Label1.ForeColor = ColorTranslator.FromOle(RGB(hsbred.Value, hsbgreen.Value, hsbblue.Value))
    End Sub

    Private Sub Label1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Label1.Click

    End Sub
End Class
