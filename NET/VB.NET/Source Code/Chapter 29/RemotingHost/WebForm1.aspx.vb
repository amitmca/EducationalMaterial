Imports System.Security.Permissions
Imports System.Security.Principal
Imports System.Threading
Imports System.IO

Public Class WebForm1
    Inherits System.Web.UI.Page

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()

    End Sub
    Protected WithEvents Label1 As System.Web.UI.WebControls.Label

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

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs)
        'System.Windows.Forms.MessageBox.Show(AppDomain.CurrentDomain.FriendlyName, "AppDomain", Windows.Forms.MessageBoxButtons.OK, Windows.Forms.MessageBoxIcon.Asterisk, Windows.Forms.MessageBoxDefaultButton.Button1, Windows.Forms.MessageBoxOptions.ServiceNotification)
        'AppDomain.CurrentDomain.SetPrincipalPolicy(PrincipalPolicy.WindowsPrincipal)
        'Dim WP As WindowsPrincipal = Thread.CurrentPrincipal
        'Dim WI As WindowsIdentity = WP.Identity
        'If WI.IsAnonymous() Then System.Windows.Forms.MessageBox.Show("Anonymous", "", Windows.Forms.MessageBoxButtons.OK, Windows.Forms.MessageBoxIcon.Asterisk, Windows.Forms.MessageBoxDefaultButton.Button1, Windows.Forms.MessageBoxOptions.ServiceNotification)
        'If WI.IsAuthenticated() Then System.Windows.Forms.MessageBox.Show("Authenticated", "", Windows.Forms.MessageBoxButtons.OK, Windows.Forms.MessageBoxIcon.Asterisk, Windows.Forms.MessageBoxDefaultButton.Button1, Windows.Forms.MessageBoxOptions.ServiceNotification)
        'System.Windows.Forms.MessageBox.Show(WI.Token.ToString, "Token", Windows.Forms.MessageBoxButtons.OK, Windows.Forms.MessageBoxIcon.Asterisk, Windows.Forms.MessageBoxDefaultButton.Button1, Windows.Forms.MessageBoxOptions.ServiceNotification)
        'System.Windows.Forms.MessageBox.Show(WI.AuthenticationType, "Authentication Type", Windows.Forms.MessageBoxButtons.OK, Windows.Forms.MessageBoxIcon.Asterisk, Windows.Forms.MessageBoxDefaultButton.Button1, Windows.Forms.MessageBoxOptions.ServiceNotification)
        'System.Windows.Forms.MessageBox.Show(WI.Name, "Name", Windows.Forms.MessageBoxButtons.OK, Windows.Forms.MessageBoxIcon.Asterisk, Windows.Forms.MessageBoxDefaultButton.Button1, Windows.Forms.MessageBoxOptions.ServiceNotification)

        CheckPrincipal()
        'Try
        '    PrivilegedCall()
        'Catch ex As Exception
        '    System.Windows.Forms.MessageBox.Show(ex.Message, "Error", Windows.Forms.MessageBoxButtons.OK, Windows.Forms.MessageBoxIcon.Asterisk, Windows.Forms.MessageBoxDefaultButton.Button1, Windows.Forms.MessageBoxOptions.ServiceNotification)
        'End Try
    End Sub

    Private Sub CheckPrincipal()
        System.Windows.Forms.MessageBox.Show(HttpContext.Current.User.Identity.Name, "Current User", Windows.Forms.MessageBoxButtons.OK, Windows.Forms.MessageBoxIcon.Asterisk, Windows.Forms.MessageBoxDefaultButton.Button1, Windows.Forms.MessageBoxOptions.ServiceNotification)


        ' Check the identity.
        System.Windows.Forms.MessageBox.Show(HttpContext.Current.User.Identity.Name, "Current User", Windows.Forms.MessageBoxButtons.OK, Windows.Forms.MessageBoxIcon.Asterisk, Windows.Forms.MessageBoxDefaultButton.Button1, Windows.Forms.MessageBoxOptions.ServiceNotification)


        Dim ss As String() = Directory.GetFiles("G:\test")
        For Each a As String In ss
            ListBox1.Items.Add(a)
        Next

        ' Stop impersonating the user.

        'Directory.CreateDirectory("G:\test")
    End Sub

    <PrincipalPermissionAttribute(SecurityAction.Demand, Role:="BUILTIN\Users")> _
    Private Sub PrivilegedCall()
        System.Windows.Forms.MessageBox.Show("In Privileged Call", "Not reached yet", Windows.Forms.MessageBoxButtons.OK, Windows.Forms.MessageBoxIcon.Asterisk, Windows.Forms.MessageBoxDefaultButton.Button1, Windows.Forms.MessageBoxOptions.ServiceNotification)
        Dim OS As New PrincipalPermission("ANKUR\wat", Nothing)
        OS.Demand()
        System.Windows.Forms.MessageBox.Show("Privileged Call", "Called Successfully", Windows.Forms.MessageBoxButtons.OK, Windows.Forms.MessageBoxIcon.Asterisk, Windows.Forms.MessageBoxDefaultButton.Button1, Windows.Forms.MessageBoxOptions.ServiceNotification)
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs)
        Dim aa As New APTC.Class1
        aa.SecuredMethod()
    End Sub
End Class
