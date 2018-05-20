Public Class WebForm1
    Inherits System.Web.UI.Page

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()

    End Sub
    Protected WithEvents DIV1 As System.Web.UI.HtmlControls.HtmlGenericControl
    Protected WithEvents TD1 As System.Web.UI.HtmlControls.HtmlTableCell
    Protected WithEvents Radio1 As System.Web.UI.HtmlControls.HtmlInputRadioButton
    Protected WithEvents Checkbox1 As System.Web.UI.HtmlControls.HtmlInputCheckBox
    Protected WithEvents Text1 As System.Web.UI.HtmlControls.HtmlInputText
    Protected WithEvents Submit1 As System.Web.UI.HtmlControls.HtmlInputButton
    Protected WithEvents Reset1 As System.Web.UI.HtmlControls.HtmlInputButton
    Protected WithEvents TEXTAREA1 As System.Web.UI.HtmlControls.HtmlTextArea
    Protected WithEvents Button1 As System.Web.UI.HtmlControls.HtmlInputButton

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
        Text1.Attributes("onblur") = "javascript:alert('Text field lost the focus')"
    End Sub

    Private Sub Button1_ServerClick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.ServerClick
        Text1.Value = "You have clicked the button"
    End Sub

    
    Private Sub Checkbox1_ServerChange(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Checkbox1.ServerChange
        Text1.Value = "You have clicked the check box"
    End Sub
End Class
