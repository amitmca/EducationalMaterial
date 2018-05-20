Public Class Form4

    Private Sub hsbBlue_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles hsbBlue.Scroll

    End Sub
    Private Sub hsbRed_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles hsbRed.Scroll
        Me.BackColor = ColorTranslator.FromOle(RGB(hsbRed.Value, hsbGreen.Value, hsbBlue.Value))
    End Sub
    Private Sub hsbGreen_Scroll(ByVal sender As System.Object, ByVal e As System.Windows.Forms.ScrollEventArgs) Handles hsbGreen.Scroll
        Me.BackColor = ColorTranslator.FromOle(RGB(hsbRed.Value, hsbGreen.Value, hsbBlue.Value))
    End Sub
    Private Sub Form4_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Me.BackColor = ColorTranslator.FromOle(RGB(hsbRed.Value, hsbGreen.Value, hsbBlue.Value))
    End Sub
End Class