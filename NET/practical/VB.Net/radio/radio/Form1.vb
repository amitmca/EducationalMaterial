Public Class Form1

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

    End Sub

    Private Sub radMale_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles radMale.CheckedChanged
        lblGender.Text = "You Have Selected Male Gender"
    End Sub

    Private Sub radFemale_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles radFemale.CheckedChanged
        lblGender.Text = "You Have Selected Female Gender"
    End Sub
End Class
