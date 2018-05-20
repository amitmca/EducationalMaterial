Public Class WebForm1
    Inherits System.Web.UI.Page

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()

    End Sub
    Protected WithEvents Button1 As System.Web.UI.WebControls.Button
    Protected WithEvents Panel1 As System.Web.UI.WebControls.Panel
    Protected WithEvents PlaceHolder1 As System.Web.UI.WebControls.PlaceHolder

    'NOTE: The following placeholder declaration is required by the Web Form Designer.
    'Do not delete or move it.
    Private designerPlaceholderDeclaration As System.Object

    Private Sub Page_Init(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Init
        'CODEGEN: This method call is required by the Web Form Designer
        'Do not modify it using the code editor.
        InitializeComponent()
    End Sub

#End Region
    Dim textbox1, textbox2 As New System.Web.UI.WebControls.TextBox
    Private Sub Page_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'Put user code to initialize the page here
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        textbox1.Text = "TextBox1"
        textbox2.Text = "TextBox2"
        textbox1.Style("POSITION") = "ABSOLUTE"
        textbox1.Style("TOP") = "60px"
        textbox1.Style("LEFT") = "150px"
        PlaceHolder1.Controls.Add(textbox1)
        Panel1.Controls.Add(textbox2)

    End Sub
End Class
