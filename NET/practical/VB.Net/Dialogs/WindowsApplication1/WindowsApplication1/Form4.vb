Public Class Form4

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        If ColorDialog1.ShowDialog <> Windows.Forms.DialogResult.Cancel Then
            Button1.BackColor = ColorDialog1.Color
        End If
    End Sub
End Class