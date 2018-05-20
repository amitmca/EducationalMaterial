Public Class MobileWebForm1
    Inherits System.Web.UI.MobileControls.MobilePage

#Region " Web Form Designer Generated Code "
    
    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()

    End Sub
    Protected WithEvents Label1 As System.Web.UI.MobileControls.Label
    Protected WithEvents SelectionList1 As System.Web.UI.MobileControls.SelectionList
    Protected WithEvents Command1 As System.Web.UI.MobileControls.Command
    Protected WithEvents Label2 As System.Web.UI.MobileControls.Label
    Protected WithEvents Form1 As System.Web.UI.MobileControls.Form
    
    Private Sub Page_Init(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Init
        'CODEGEN: This method call is required by the Web Form Designer
        'Do not modify it using the code editor.
        InitializeComponent()
    End Sub
    
#End Region

    Private Sub Page_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'Put user code to initialize the page here
        If Not IsPostBack Then
            SelectionList1.Items.Add("Pistachio")
            SelectionList1.Items.Add("Rocky Road")
            SelectionList1.Items.Remove("Vanila")
        End If
    End Sub

    Private Sub Command1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Command1.Click
        'Label1.Text = "Your favorite is " & SelectionList1.Selection.Text & "!"
        Label2.Text = "Your favorite is " & SelectionList1.Selection.Text & "!"
    End Sub
End Class