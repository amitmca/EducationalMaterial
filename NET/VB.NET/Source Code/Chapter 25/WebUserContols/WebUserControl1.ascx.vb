Public Class WebUserControl1
    Inherits System.Web.UI.UserControl

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

    Private Labelcolor As Color
    Public Event TextModified(ByVal NewText As String)


    Property DisplayColor() As Color
        Get
            Return Labelcolor
        End Get
        Set(ByVal Value As Color)
            Labelcolor = Value
            Label1.BackColor = Labelcolor

        End Set
    End Property
    Public Sub SetText(ByVal NewText As String)
        Label1.Text = NewText
        RaiseEvent TextModified(NewText)

    End Sub

    
End Class
