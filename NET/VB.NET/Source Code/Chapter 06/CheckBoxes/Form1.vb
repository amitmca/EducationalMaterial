Public Class Form1
    Inherits System.Windows.Forms.Form

#Region " Windows Form Designer generated code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Windows Form Designer.
        InitializeComponent()

        'Add any initialization after the InitializeComponent() call

    End Sub

    'Form overrides dispose to clean up the component list.
    Protected Overloads Overrides Sub Dispose(ByVal disposing As Boolean)
        If disposing Then
            If Not (components Is Nothing) Then
                components.Dispose()
            End If
        End If
        MyBase.Dispose(disposing)
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    Friend WithEvents CheckBox1 As System.Windows.Forms.CheckBox
    Friend WithEvents CheckBox2 As System.Windows.Forms.CheckBox
    Friend WithEvents CheckBox3 As System.Windows.Forms.CheckBox
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.CheckBox1 = New System.Windows.Forms.CheckBox
        Me.CheckBox2 = New System.Windows.Forms.CheckBox
        Me.CheckBox3 = New System.Windows.Forms.CheckBox
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.SuspendLayout()
        '
        'CheckBox1
        '
        Me.CheckBox1.Location = New System.Drawing.Point(80, 48)
        Me.CheckBox1.Name = "CheckBox1"
        Me.CheckBox1.TabIndex = 0
        Me.CheckBox1.Text = "CheckBox1"
        '
        'CheckBox2
        '
        Me.CheckBox2.Location = New System.Drawing.Point(80, 88)
        Me.CheckBox2.Name = "CheckBox2"
        Me.CheckBox2.TabIndex = 1
        Me.CheckBox2.Text = "CheckBox2"
        '
        'CheckBox3
        '
        Me.CheckBox3.Location = New System.Drawing.Point(80, 128)
        Me.CheckBox3.Name = "CheckBox3"
        Me.CheckBox3.TabIndex = 2
        Me.CheckBox3.Text = "CheckBox3"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(40, 176)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(208, 20)
        Me.TextBox1.TabIndex = 3
        Me.TextBox1.Text = "TextBox1"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 238)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.CheckBox3)
        Me.Controls.Add(Me.CheckBox2)
        Me.Controls.Add(Me.CheckBox1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private Sub CheckBox1_CheckedChanged(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles CheckBox1.CheckedChanged
        TextBox1.Text = "You clicked check box 1"
    End Sub

    Private Sub CheckBox2_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CheckBox2.CheckedChanged
        TextBox1.Text = "You clicked check box 2"
    End Sub

    Private Sub CheckBox3_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CheckBox3.CheckedChanged
        TextBox1.Text = "You clicked check box 3"
    End Sub
End Class
