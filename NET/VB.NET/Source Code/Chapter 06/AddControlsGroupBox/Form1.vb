Public Class Form1
    Inherits System.Windows.Forms.Form
    Dim GroupBox1 As New GroupBox
    Dim WithEvents RadioButton1 As RadioButton
    Dim WithEvents RadioButton2 As RadioButton
    Dim WithEvents RadioButton3 As RadioButton



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
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(80, 216)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(120, 23)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Create Group Box"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(56, 176)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(176, 20)
        Me.TextBox1.TabIndex = 1
        Me.TextBox1.Text = "TextBox1"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Button1_Click(ByVal sender As System.Object, _
          ByVal e As System.EventArgs) Handles Button1.Click

        RadioButton1 = New RadioButton
        RadioButton2 = New RadioButton
        RadioButton3 = New RadioButton

        GroupBox1.Text = "GroupBox1"
        GroupBox1.Location = New Point(40, 40)
        GroupBox1.Size = New Size(200, 100)

        RadioButton1.Location = New Point(16, 16)
        RadioButton1.Text = "RadioButton1"
        RadioButton1.Size = New Size(120, 16)

        RadioButton2.Location = New Point(16, 32)
        RadioButton2.Text = "RadioButton2"
        RadioButton2.Size = New Size(120, 20)

        RadioButton3.Location = New Point(16, 48)
        RadioButton3.Text = "RadioButton3"
        RadioButton3.Size = New Size(120, 20)

        GroupBox1.Controls.Add(RadioButton1)
        GroupBox1.Controls.Add(RadioButton2)
        GroupBox1.Controls.Add(RadioButton3)

        Controls.Add(GroupBox1)

        AddHandler RadioButton1.CheckedChanged, AddressOf _
            RadioButton1_CheckedChanged
        AddHandler RadioButton2.CheckedChanged, AddressOf _
            RadioButton2_CheckedChanged
        AddHandler RadioButton3.CheckedChanged, AddressOf _
            RadioButton3_CheckedChanged
    End Sub

    Private Sub RadioButton1_CheckedChanged(ByVal sender As _
        System.Object, ByVal e As System.EventArgs) Handles _
        RadioButton1.CheckedChanged
        TextBox1.Text = "You clicked radio button 1"
    End Sub

    Private Sub RadioButton2_CheckedChanged(ByVal sender As _
        System.Object, ByVal e As System.EventArgs) Handles _
        RadioButton2.CheckedChanged
        TextBox1.Text = "You clicked radio button 2"
    End Sub

    Private Sub RadioButton3_CheckedChanged(ByVal sender As _
        System.Object, ByVal e As System.EventArgs) Handles _
        RadioButton3.CheckedChanged
        TextBox1.Text = "You clicked radio button 3"
    End Sub
End Class

