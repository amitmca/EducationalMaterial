Public Class Form2

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        If SaveFileDialog1.ShowDialog() <> Windows.Forms.DialogResult.Cancel Then
            MsgBox("You have selected the file" + SaveFileDialog1.FileName)
        End If
    End Sub
End Class