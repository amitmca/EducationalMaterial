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
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents TextBox2 As System.Windows.Forms.TextBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.TextBox2 = New System.Windows.Forms.TextBox
        Me.Label1 = New System.Windows.Forms.Label
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(48, 112)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(176, 23)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Send text to clipboard"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(48, 160)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(176, 23)
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "Get text from clipboard"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(48, 64)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(168, 20)
        Me.TextBox1.TabIndex = 2
        Me.TextBox1.Text = ""
        '
        'TextBox2
        '
        Me.TextBox2.Location = New System.Drawing.Point(48, 200)
        Me.TextBox2.Name = "TextBox2"
        Me.TextBox2.Size = New System.Drawing.Size(176, 20)
        Me.TextBox2.TabIndex = 3
        Me.TextBox2.Text = ""
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(48, 24)
        Me.Label1.Name = "Label1"
        Me.Label1.TabIndex = 4
        Me.Label1.Text = "Enter your text:"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 246)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.TextBox2)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        System.Windows.Forms.Clipboard.SetDataObject _
            (TextBox1.SelectedText)
    End Sub
    Private Sub Button2_Click(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles Button2.Click
        Dim ClipboardData As System.Windows.Forms.IDataObject = _
            System.Windows.Forms.Clipboard.GetDataObject()
        If ClipboardData.GetDataPresent(DataFormats.Text) Then
            TextBox2.Text = ClipboardData.GetData(DataFormats.Text)
        End If
    End Sub

End Class
