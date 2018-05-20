Public Class Form3
    Dim b = 0
    Dim a As Integer

    Private Sub quit_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnquit.Click
        End
    End Sub

    Private Sub Form3_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        btnok.Enabled = False
        btnavg.Enabled = False
        btnquit.Enabled = False

    End Sub

    Private Sub btnok_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnok.Click
        Static count = 0
        btnok.Enabled = True
        a = txtbox.Text
        list.Items.Add("Subject mark is: " & a)
        count = count + 1
        b = b + a
        If count = 6 Then
            btnok.Enabled = False
            txtbox.Enabled = False
            btnavg.Enabled = True
        End If
        txtbox.Focus()
        txtbox.Text = ""

    End Sub

    Private Sub txtbox_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtbox.TextChanged
        btnok.Enabled = True
    End Sub

    Private Sub btnavg_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnavg.Click
        btnavg.Enabled = True
        btnok.Enabled = False
        avg.Visible = True
        lbl.Visible = True
        lbl.Text = b / 6
        btnavg.Enabled = False
        txtbox.Enabled = False
        btnquit.Enabled = True
    End Sub
End Class