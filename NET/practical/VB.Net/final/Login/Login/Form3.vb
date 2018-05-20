Public Class Form3

    Private Sub btnadd_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnadd.Click
        list.Items.Add(txtname.Text)
        txtname.Text = ""
        txtname.Focus()
    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        txtname.Focus()
    End Sub

    Private Sub btndel_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btndel.Click
        list.Items.RemoveAt(list.SelectedIndex)
        txtname.Focus()
    End Sub

    Private Sub btnclr_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnclr.Click
        list.Items.Clear()
        txtname.Focus()
    End Sub

    Private Sub chk_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles chk.Click
        If rmale.Checked Then
            MsgBox("You have selected Male")
        ElseIf rfemale.Checked Then
            MsgBox("You have selected Female")
        End If

    End Sub

    Private Sub vsbred_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles vsbred.Scroll
        Panel1.BackColor = ColorTranslator.FromOle(RGB(vsbred.Value, vsbgreen.Value, vsbblue.Value))
    End Sub

    Private Sub vsbgreen_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles vsbgreen.Scroll
        Panel1.BackColor = ColorTranslator.FromOle(RGB(vsbred.Value, vsbgreen.Value, vsbblue.Value))
    End Sub

    Private Sub vsbblue_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles vsbblue.Scroll
        Panel1.BackColor = ColorTranslator.FromOle(RGB(vsbred.Value, vsbgreen.Value, vsbblue.Value))
    End Sub

    Private Sub Timer1_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles tmr.Tick
        txt.Text = TimeString
    End Sub
End Class
