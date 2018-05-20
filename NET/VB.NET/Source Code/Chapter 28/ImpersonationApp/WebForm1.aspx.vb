Imports System.Threading
Imports System.Security.Principal
Imports System.IO
Imports System.Security.Permissions

Public Class WebForm1
    Inherits System.Web.UI.Page

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()

    End Sub
    Protected WithEvents Button1 As System.Web.UI.WebControls.Button
    Protected WithEvents ListBox1 As System.Web.UI.WebControls.ListBox

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

    '<PrincipalPermissionAttribute(SecurityAction.Demand, Name:="ANIL\KumarAnil")> _
    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        'AppDomain.CurrentDomain.SetPrincipalPolicy(PrincipalPolicy.WindowsPrincipal)
        'Dim WP As WindowsPrincipal = System.Web.HttpContext.Current.User()
        'Dim WI As WindowsIdentity = WP.Identity

        'If Not WP.IsInRole("BUILTIN\Administrators") Then Return

        'Dim PI As New PrincipalPermission("ANIL\KumarAnil", "BUILTIN\Administrators")
        'PI.Demand()

        Dim ss As String() = Directory.GetFiles("C:\test")
        For Each a As String In ss
            ListBox1.Items.Add(a)
        Next

    End Sub
End Class
