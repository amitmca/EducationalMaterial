Public Class WebForm1
    Inherits System.Web.UI.Page
    Protected WithEvents CheckBox1 As System.Web.UI.WebControls.CheckBox
    Protected WithEvents CheckBox2 As System.Web.UI.WebControls.CheckBox
    Protected WithEvents TextBox1 As System.Web.UI.WebControls.TextBox
    Protected WithEvents CheckBoxList1 As _
        System.Web.UI.WebControls.CheckBoxList
    Protected WithEvents Label1 As System.Web.UI.WebControls.Label
    Protected WithEvents TextBox2 As System.Web.UI.WebControls.TextBox

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> _
        Private Sub InitializeComponent()

    End Sub

    Private Sub Page_Init(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles MyBase.Init
        'CODEGEN: This method call is required by the Web Form Designer
        'Do not modify it using the code editor.
        InitializeComponent()
    End Sub

#End Region

    Private Sub Page_Load(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles MyBase.Load
        'Put user code to initialize the page here
    End Sub

    Private Sub CheckBox1_CheckedChanged(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles CheckBox1.CheckedChanged
        If CType(sender, CheckBox).Checked Then
            TextBox1.Text = "Bread: Whole wheat"
        Else
            TextBox1.Text = "Bread: White"
        End If

        If CheckBox2.Checked Then
            TextBox1.Text += " with sesame seeds"
        
        End If
    End Sub

    Private Sub CheckBox2_CheckedChanged(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles CheckBox2.CheckedChanged
        If CheckBox1.Checked Then
            TextBox1.Text = "Bread: Whole wheat"
        Else
            TextBox1.Text = "Bread: White"
        End If

        If CType(sender, CheckBox).Checked Then
            TextBox1.Text += " with sesame seeds"
        End If
    End Sub

    Private Sub CheckBoxList1_SelectedIndexChanged(ByVal sender _
        As System.Object, ByVal e As System.EventArgs) Handles _
        CheckBoxList1.SelectedIndexChanged
        Dim LoopIndex As Integer
        TextBox2.Text = "Filling: "

        For LoopIndex = 0 To 3
            If CheckBoxList1.Items(LoopIndex).Selected Then
                TextBox2.Text &= _
                    CheckBoxList1.Items(LoopIndex).Value & " "
            End If
        Next
    End Sub
End Class
