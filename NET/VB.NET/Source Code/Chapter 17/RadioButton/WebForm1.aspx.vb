Public Class WebForm1
    Inherits System.Web.UI.Page

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()

    End Sub
    Protected WithEvents RadioButtonList1 As System.Web.UI.WebControls.RadioButtonList
    Protected WithEvents Label2 As System.Web.UI.WebControls.Label
    Protected WithEvents Label1 As System.Web.UI.WebControls.Label
    Protected WithEvents TextBox2 As System.Web.UI.WebControls.TextBox
    Protected WithEvents RadioButton2 As System.Web.UI.WebControls.RadioButton
    Protected WithEvents RadioButton1 As System.Web.UI.WebControls.RadioButton
    Protected WithEvents TextBox1 As System.Web.UI.WebControls.TextBox
    Protected WithEvents Label3 As System.Web.UI.WebControls.Label

    'NOTE: The following placeholder declaration is required by the Web Form Designer.
    'Do not delete or move it.
    Private designerPlaceholderDeclaration As System.Object

    Private Sub Page_Init(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Init
        'CODEGEN: This method call is required by the Web Form Designer
        'Do not modify it using the code editor.
        InitializeComponent()
    End Sub

#End Region

    Private Sub Page_Load(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles MyBase.Load
        If RadioButton1.Checked Then
            TextBox1.Text = "Car is selected."
            TextBox2.Text = "Your car is: blue"
        End If
    End Sub

    Private Sub RadioButtonList1_SelectedIndexChanged(ByVal sender _
        As System.Object, ByVal e As System.EventArgs) Handles _
        RadioButtonList1.SelectedIndexChanged
        If RadioButton1.Checked Then
            TextBox2.Text = "Your car is: "
        Else
            TextBox2.Text = "Your truck is: "
        End If

        TextBox2.Text &= RadioButtonList1.SelectedItem.Value
    End Sub

    Private Sub RadioButton1_CheckedChanged(ByVal sender As _
        System.Object, ByVal e As System.EventArgs) Handles _
        RadioButton1.CheckedChanged
        If RadioButton1.Checked Then
            TextBox1.Text = "Car is selected."
        End If

        If RadioButton1.Checked Then
            TextBox2.Text = "Your car is: "
        Else
            TextBox2.Text = "Your truck is: "
        End If

        TextBox2.Text &= RadioButtonList1.SelectedItem.Value
    End Sub

    Private Sub RadioButton2_CheckedChanged(ByVal sender As _
        System.Object, ByVal e As System.EventArgs) Handles _
        RadioButton2.CheckedChanged
        If RadioButton2.Checked Then
            TextBox1.Text = "Truck is selected."
        End If

        If RadioButton1.Checked Then
            TextBox2.Text = "Your car is: "
        Else
            TextBox2.Text = "Your truck is: "
        End If

        TextBox2.Text &= RadioButtonList1.SelectedItem.Value
    End Sub

End Class
