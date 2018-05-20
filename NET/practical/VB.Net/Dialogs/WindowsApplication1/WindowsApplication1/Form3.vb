Public Class Form3

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        FontDialog1.ShowColor = True
        If FontDialog1.ShowDialog() <> Windows.Forms.DialogResult.Cancel Then
            TextBox1.Font = FontDialog1.Font
            TextBox1.ForeColor = FontDialog1.Color
        End If
    End Sub
End Class