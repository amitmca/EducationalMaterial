Public Class Form1

    Private Sub btnAdd_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnAdd.Click
        If txtcon.Text = "" Then
            MsgBox("Please enter the name")
        Else
            lstcon.Items.Add(txtcon.Text)
            txtcon.Text = ""
            txtcon.Focus()
        End If
    End Sub

    Private Sub btnDel_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnDel.Click
        lstcon.Items.RemoveAt(lstcon.SelectedIndex)
        txtcon.Focus()
    End Sub

    Private Sub btnClr_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnClr.Click
        lstcon.Items.Clear()
        txtcon.Focus()
    End Sub
End Class
