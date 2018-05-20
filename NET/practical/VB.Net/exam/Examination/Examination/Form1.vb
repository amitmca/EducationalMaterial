Public Class Form1
    Dim str1 As Double
    Dim str2 As Double
    Dim str As String
    Private Sub btnclr_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnclr.Click
        txt.Text = ""
    End Sub

    Private Sub btnexit_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnexit.Click
        End
    End Sub

    Private Sub nine_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles nine.Click
        txt.Text += nine.Text
    End Sub

    Private Sub eight_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles eight.Click
        txt.Text += eight.Text
    End Sub

    Private Sub seven_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles seven.Click
        txt.Text += seven.Text
    End Sub

    Private Sub six_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles six.Click
        txt.Text += six.Text
    End Sub

    Private Sub five_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles five.Click
        txt.Text += five.Text
    End Sub

    Private Sub four_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles four.Click
        txt.Text += four.Text
    End Sub

    Private Sub three_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles three.Click
        txt.Text += three.Text
    End Sub

    Private Sub two_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles two.Click
        txt.Text += two.Text
    End Sub

    Private Sub one_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles one.Click
        txt.Text += one.Text
    End Sub

    Private Sub zero_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles zero.Click
        txt.Text += zero.Text
    End Sub

    Private Sub tzero_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles tzero.Click
        txt.Text += tzero.Text
    End Sub

    Private Sub point_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles point.Click
        txt.Text += point.Text
    End Sub

    Private Sub btnplus_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnplus.Click
        str1 = Val(txt.Text)
        txt.Text = ""
        str = btnplus.Text
    End Sub

    Private Sub btnminus_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnminus.Click
        str1 = Val(txt.Text)
        txt.Text = ""
        str = btnminus.Text
    End Sub

    Private Sub btnmul_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnmul.Click
        str1 = Val(txt.Text)
        txt.Text = ""
        str = btnmul.Text
    End Sub

    Private Sub btndiv_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btndiv.Click
        str1 = Val(txt.Text)
        txt.Text = ""
        str = btndiv.Text
    End Sub

    Private Sub btnequal_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnequal.Click
        str2 = Val(txt.Text)
        If str = "+" Then
            txt.Text = str1 + str2
        ElseIf str = "-" Then
            txt.Text = str1 - str2
        ElseIf str = "*" Then
            txt.Text = str1 * str2
        ElseIf str = "/" Then
            txt.Text = str1 / str2
        End If
    End Sub
End Class
