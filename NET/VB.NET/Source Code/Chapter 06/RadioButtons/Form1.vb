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
    Friend WithEvents RadioButton1 As System.Windows.Forms.RadioButton
    Friend WithEvents RadioButton2 As System.Windows.Forms.RadioButton
    Friend WithEvents RadioButton3 As System.Windows.Forms.RadioButton
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.RadioButton1 = New System.Windows.Forms.RadioButton
        Me.RadioButton2 = New System.Windows.Forms.RadioButton
        Me.RadioButton3 = New System.Windows.Forms.RadioButton
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.SuspendLayout()
        '
        'RadioButton1
        '
        Me.RadioButton1.Location = New System.Drawing.Point(80, 40)
        Me.RadioButton1.Name = "RadioButton1"
        Me.RadioButton1.TabIndex = 0
        Me.RadioButton1.Text = "RadioButton1"
        '
        'RadioButton2
        '
        Me.RadioButton2.Location = New System.Drawing.Point(80, 80)
        Me.RadioButton2.Name = "RadioButton2"
        Me.RadioButton2.TabIndex = 1
        Me.RadioButton2.Text = "RadioButton2"
        '
        'RadioButton3
        '
        Me.RadioButton3.Location = New System.Drawing.Point(80, 120)
        Me.RadioButton3.Name = "RadioButton3"
        Me.RadioButton3.TabIndex = 2
        Me.RadioButton3.Text = "RadioButton3"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(56, 176)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(184, 20)
        Me.TextBox1.TabIndex = 3
        Me.TextBox1.Text = "TextBox1"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 230)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.RadioButton3)
        Me.Controls.Add(Me.RadioButton2)
        Me.Controls.Add(Me.RadioButton1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private Sub RadioButton1_CheckedChanged(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles RadioButton1.CheckedChanged
        TextBox1.Text = "You clicked radio button 1"
    End Sub
End Class
