Public Class Add

    Private Sub btnok_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnok.Click
        Static N
        N = N + 1
        lstoutput.Items.Add("The Number of Times You Click=" & N)
    End Sub
End Class