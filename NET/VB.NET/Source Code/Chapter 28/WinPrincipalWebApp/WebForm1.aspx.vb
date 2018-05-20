Imports System.Security.Principal
Imports System.Threading
Public Class WebForm1
    Inherits System.Web.UI.Page

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()

    End Sub
    Protected WithEvents Button1 As System.Web.UI.WebControls.Button
    Protected WithEvents TextBox1 As System.Web.UI.WebControls.TextBox

    'NOTE: The following placeholder declaration is required by the Web Form Designer.
    'Do not delete or move it.
    Private designerPlaceholderDeclaration As System.Object

    Private Sub Page_Init(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Init
        'CODEGEN: This method call is required by the Web Form Designer
        'Do not modify it using the code editor.
        InitializeComponent()
    End Sub

#End Region

    Private Sub Page_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'Put user code to initialize the page here
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, _
ByVal e As System.EventArgs) Handles Button1.Click
        AppDomain.CurrentDomain.SetPrincipalPolicy(PrincipalPolicy.WindowsPrincipal)
        Dim WP As WindowsPrincipal = Thread.CurrentPrincipal
        Dim WI As WindowsIdentity = WP.Identity
        TextBox1.Text = "Name: " & WI.Name & vbCrLf
        TextBox1.Text += "Authentication Type: " & _
WI.AuthenticationType & vbCrLf
        TextBox1.Text += "Authenticated: " & _
IIf(WI.IsAuthenticated(), "Yes", "No") & vbCrLf
        TextBox1.Text += "Is an Administrator: " & _
           IIf(WP.IsInRole("BUILTIN\Administrators"), "Yes", "No") & vbCrLf
    End Sub

End Class
