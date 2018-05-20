Public Class Form2
    Dim b = 0
    Dim a As Integer
    Private Sub btnquit_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnquit.Click
        End
    End Sub

    Private Sub TextBox1_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txt.TextChanged
        btnok.Enabled = True
    End Sub

    Private Sub Form2_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        btnok.Enabled = False
        btnavg.Enabled = False
        btnquit.Enabled = False
    End Sub

    Private Sub btnok_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnok.Click
        Static count = 0
        btnok.Enabled = True
        a = txt.Text
        count = count + 1
        b = b + a
        list.Items.Add("Marks:" & a)
        If count = 6 Then
            btnok.Enabled = False
            txt.Enabled = False
            btnavg.Enabled = True
        End If
        txt.Focus()
        txt.Text = ""
    End Sub

    Private Sub btnavg_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnavg.Click
        btnavg.Enabled = True
        btnok.Enabled = False
        txt.Enabled = False
        avg.Visible = True
        lbl.Visible = True
        lbl.Text = b / 6
        btnavg.Enabled = False
        btnquit.Enabled = True
    End Sub
End Class