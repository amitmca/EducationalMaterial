Public Class Marks
    Dim b = 0

    Private Sub btnok_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnok.Click
        Static count = 0
        Dim a As Integer

        btnok.Enabled = True
      
        a = txtbox.Text
        lstbox.Items.Add("Subject Marks is:" & a)
        count = count + 1
        b = b + a
        If count = 6 Then
            btnavg.Enabled = True
            btnok.Enabled = False
            txtbox.Enabled = False
        End If

        txtbox.Focus()
        txtbox.Text = " "

    End Sub

    Private Sub btnavg_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnavg.Click
        btnavg.Enabled = True
        btnok.Enabled = False
        Label3.Text = b / 6
        'btnq.Enabled = True
        btnavg.Enabled = False
        txtbox.Enabled = False
        btnq.Enabled = True
    End Sub

    Private Sub btnq_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnq.Click
        btnq.Enabled = True
        End
    End Sub

    Private Sub Marks_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        btnok.Enabled = False
        btnavg.Enabled = False
        btnq.Enabled = False

    End Sub

    Private Sub txtbox_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtbox.TextChanged
        btnok.Enabled = True

    End Sub

    Private Sub Panel1_Paint(ByVal sender As System.Object, ByVal e As System.Windows.Forms.PaintEventArgs) Handles Panel1.Paint

    End Sub

    Private Sub Label2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Label2.Click

      
    End Sub
End Class