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
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents Button2 As System.Windows.Forms.Button
    Friend WithEvents Button3 As System.Windows.Forms.Button
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.Button3 = New System.Windows.Forms.Button
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(32, 24)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(232, 23)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Show MsgBox"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(32, 80)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(232, 23)
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "Show MessageBox"
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(32, 136)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(232, 23)
        Me.Button3.TabIndex = 2
        Me.Button3.Text = "Show InputBox"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(32, 200)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(232, 20)
        Me.TextBox1.TabIndex = 3
        Me.TextBox1.Text = ""
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 254)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Button3_Click(ByVal sender As System.Object, _
            ByVal e As System.EventArgs) Handles Button3.Click
        Dim Result As String
        Result = InputBox("Enter your text!")
        TextBox1.Text = Result
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button2.Click
        Dim Result As Integer
        Result = MessageBox.Show("This is a message box!", "Message Box", _
            MessageBoxButtons.OKCancel, MessageBoxIcon.Information, _
            MessageBoxDefaultButton.Button1, _
                MessageBoxOptions.DefaultDesktopOnly)
        If (Result = DialogResult.OK) Then
            TextBox1.Text = "You clicked OK"
        End If
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        Dim Result As Integer
        Result = MsgBox("This is a message box!", MsgBoxStyle.OKCancel + _
            MsgBoxStyle.Information + MsgBoxStyle.SystemModal, "Message Box")
        If (Result = MsgBoxResult.OK) Then
            TextBox1.Text = "You clicked OK"
        End If
    End Sub

End Class
