Public Class WebForm1
    Inherits System.Web.UI.Page
    Protected WithEvents Panel1 As System.Web.UI.WebControls.Panel
    Protected WithEvents RadioButton1 As _
        System.Web.UI.WebControls.RadioButton
    Protected WithEvents RadioButton2 As _
        System.Web.UI.WebControls.RadioButton
    Protected WithEvents RadioButton3 As _
        System.Web.UI.WebControls.RadioButton
    Protected WithEvents RadioButton4 As _
        System.Web.UI.WebControls.RadioButton
    Protected WithEvents TextBox1 As System.Web.UI.WebControls.TextBox
    Protected WithEvents Label1 As System.Web.UI.WebControls.Label
    Protected WithEvents TextBox2 As System.Web.UI.WebControls.TextBox
    Protected WithEvents Label2 As System.Web.UI.WebControls.Label
    Protected WithEvents TextBox3 As System.Web.UI.WebControls.TextBox
    Protected WithEvents Label3 As System.Web.UI.WebControls.Label
    Protected WithEvents Button1 As System.Web.UI.WebControls.Button
    Protected WithEvents Panel2 As System.Web.UI.WebControls.Panel

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> _
        Private Sub InitializeComponent()

    End Sub

    Private Sub Page_Init(ByVal sender As System.Object, ByVal e As _
        System.EventArgs) Handles MyBase.Init
        'CODEGEN: This method call is required by the Web Form Designer
        'Do not modify it using the code editor.
        InitializeComponent()
    End Sub

#End Region

    Private Sub RadioButton1_CheckedChanged(ByVal sender As _
        System.Object, ByVal e As System.EventArgs) Handles _
        RadioButton1.CheckedChanged
        If CType(sender, RadioButton).Checked Then
            Panel1.BackColor = Color.Red
        End If
    End Sub

    Private Sub RadioButton2_CheckedChanged(ByVal sender As _
        System.Object, ByVal e As System.EventArgs) Handles _
        RadioButton2.CheckedChanged
        If CType(sender, RadioButton).Checked Then
            Panel1.BackColor = Color.Green
        End If
    End Sub

    Private Sub RadioButton3_CheckedChanged(ByVal sender As _
        System.Object, ByVal e As System.EventArgs) Handles _
        RadioButton3.CheckedChanged
        If CType(sender, RadioButton).Checked Then
            Panel1.BackColor = Color.Blue
        End If
    End Sub

    Private Sub RadioButton4_CheckedChanged(ByVal sender As _
        System.Object, ByVal e As System.EventArgs) Handles _
        RadioButton4.CheckedChanged
        If CType(sender, RadioButton).Checked Then
            Panel2.Visible = True
        Else
            Panel2.Visible = False
        End If
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        Panel1.BackColor = Color.FromArgb(TextBox1.Text, _
            TextBox2.Text, TextBox3.Text)
    End Sub

    Private Sub Page_Load(ByVal sender As System.Object, ByVal e _
        As System.EventArgs) Handles MyBase.Load

    End Sub
End Class
