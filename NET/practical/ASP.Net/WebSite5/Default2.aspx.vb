
Partial Class Default2
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Dim val As String = Request.QueryString("txt")
        Label4.Text = "This page is a result of Cross Page Posting"
        Label1.Text = "Welcome  " + val

    End Sub

    Protected Sub Submit_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Submit.Click
        Dim var As String
        var = TextBox1.Text
        Label1.Visible = False
        Label4.Text = ""
        Label4.Text = "This is the result of Post Back"
        Label3.Text = "Your Id is " + var
    End Sub
End Class
