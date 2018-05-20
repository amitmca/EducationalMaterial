Public Class Form3

    Private Sub hsbRed_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles hsbRed.Scroll
        Me.BackColor = ColorTranslator.FromOle(RGB(hsbRed.Value, hsbGreen.Value, hsbBlue.Value))
    End Sub

    Private Sub hsbGreen_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles hsbGreen.Scroll
        Me.BackColor = ColorTranslator.FromOle(RGB(hsbRed.Value, hsbGreen.Value, hsbBlue.Value))
    End Sub

    Private Sub hsbBlue_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles hsbBlue.Scroll
        Me.BackColor = ColorTranslator.FromOle(RGB(hsbRed.Value, hsbGreen.Value, hsbBlue.Value))
    End Sub

    Private Sub Form3_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

    End Sub
End Class