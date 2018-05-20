Public Class Form1
    Dim str1 As Double
    Dim str2 As Double
    Dim str As String

    Private Sub btn0_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn0.Click
        txt.Text += (btn0.Text)
    End Sub

    Private Sub btn1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn1.Click
        txt.Text += btn1.Text
    End Sub

    Private Sub btn2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn2.Click
        txt.Text += btn2.Text
    End Sub

    Private Sub btn3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn3.Click
        txt.Text += btn3.Text
    End Sub

    Private Sub btn4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn4.Click
        txt.Text += btn4.Text
    End Sub

    Private Sub btn5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn5.Click
        txt.Text += btn5.Text
    End Sub

    Private Sub btn6_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn6.Click
        txt.Text += btn6.Text
    End Sub

    Private Sub btn7_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn7.Click
        txt.Text += btn7.Text
    End Sub

    Private Sub btn8_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn8.Click
        txt.Text += btn8.Text

    End Sub

    Private Sub btn9_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn9.Click
        txt.Text += btn9.Text
    End Sub

    Private Sub btnpm_Click(ByVal sender As System.Object, ByVal e As System.EventArgs)

    End Sub

    Private Sub btndiv_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btndiv.Click
        str1 = Val(txt.Text)
        txt.Text = ""
        str = btndiv.Text
    End Sub

    Private Sub btnmul_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnmul.Click
        str1 = Val(txt.Text)
        txt.Text = ""
        str = btnmul.Text
    End Sub

    Private Sub btnminus_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnminus.Click
        str1 = Val(txt.Text)
        txt.Text = ""
        str = btnminus.Text
    End Sub

    Private Sub btnplus_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnplus.Click
        str1 = Val(txt.Text)
        txt.Text = ""
        str = btnplus.Text
    End Sub

    Private Sub btnequal_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnequal.Click
        str2 = Val(txt.Text)
        If str = "-" Then
            txt.Text = str1 - str2
        ElseIf str = "+" Then
            txt.Text = str1 + str2
        ElseIf str = "*" Then
            txt.Text = str1 * str2
        ElseIf str = "/" Then
            txt.Text = str1 / str2
        End If
    End Sub

    Private Sub btn00_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn00.Click
        txt.Text = btn00.Text
    End Sub

    Private Sub btnce_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnce.Click
        txt.Text = " "
    End Sub

    Private Sub btnpoint_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnpoint.Click
        txt.Text += btnpoint.Text
    End Sub
End Class
