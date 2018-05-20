Public Class Form1

 

    Private Sub btnshw_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnshw.Click
        If txtname.Text = "" Or txtaddr.Text = "" Or txtcontact.Text = "" Or country.Text = "" Then
            MsgBox("Please enter all the fields")
        Else
            showbox.Text = txtname.Text
            showbox.AppendText(txtaddr.Text)
            showbox.AppendText(txtcontact.Text)
            If radm.Enabled = True Then
                showbox.AppendText(radm.Text)
            Else
                showbox.AppendText(radf.Text)
            End If
            showbox.AppendText(country.Text)

        End If
    End Sub


End Class
