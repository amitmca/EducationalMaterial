Public Class Form2

    Private Sub radmale_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles radmale.CheckedChanged
        lblgender.Text = "Male"
    End Sub

    Private Sub radfemale_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles radfemale.CheckedChanged
        lblgender.Text = "Female"
    End Sub
End Class