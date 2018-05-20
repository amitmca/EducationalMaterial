Public Class Form1
    Inherits System.Windows.Forms.Form
    Dim Object1, Object2 As New Mathematics
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
    Friend WithEvents TextBox2 As System.Windows.Forms.TextBox
    Friend WithEvents TextBox3 As System.Windows.Forms.TextBox
    Friend WithEvents TextBox4 As System.Windows.Forms.TextBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.Button3 = New System.Windows.Forms.Button
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.TextBox2 = New System.Windows.Forms.TextBox
        Me.TextBox3 = New System.Windows.Forms.TextBox
        Me.TextBox4 = New System.Windows.Forms.TextBox
        Me.Label1 = New System.Windows.Forms.Label
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(104, 112)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(72, 23)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "="
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(40, 192)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(224, 23)
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "Increment count with Object 1"
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(40, 232)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(224, 23)
        Me.Button3.TabIndex = 2
        Me.Button3.Text = "Increment count with Object 2"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(88, 16)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.TabIndex = 3
        Me.TextBox1.Text = ""
        '
        'TextBox2
        '
        Me.TextBox2.Location = New System.Drawing.Point(88, 72)
        Me.TextBox2.Name = "TextBox2"
        Me.TextBox2.TabIndex = 4
        Me.TextBox2.Text = ""
        '
        'TextBox3
        '
        Me.TextBox3.Location = New System.Drawing.Point(88, 152)
        Me.TextBox3.Name = "TextBox3"
        Me.TextBox3.TabIndex = 5
        Me.TextBox3.Text = ""
        '
        'TextBox4
        '
        Me.TextBox4.Location = New System.Drawing.Point(32, 272)
        Me.TextBox4.Name = "TextBox4"
        Me.TextBox4.Size = New System.Drawing.Size(232, 20)
        Me.TextBox4.TabIndex = 6
        Me.TextBox4.Text = ""
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(128, 48)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(16, 16)
        Me.Label1.TabIndex = 7
        Me.Label1.Text = "+"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 310)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.TextBox4)
        Me.Controls.Add(Me.TextBox3)
        Me.Controls.Add(Me.TextBox2)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Button1_Click(ByVal sender As System.Object, _
            ByVal e As System.EventArgs) Handles Button1.Click
        TextBox3.Text = Mathematics.Add(TextBox1.Text, TextBox2.Text)
    End Sub


    Private Sub Button2_Click(ByVal sender As System.Object, _
           ByVal e As System.EventArgs) Handles Button2.Click
        TextBox4.Text = "Count = " & Object1.Increment
    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, _
            ByVal e As System.EventArgs) Handles Button3.Click
        TextBox4.Text = "Count = " & Object2.Increment
    End Sub

End Class
Public Class Mathematics

    Public Shared Pi As Double = 3.1415926535
    Shared Data As Integer = 0

    Shared Function Add(ByVal x As Integer, ByVal y As Integer) _
    As Integer
        Return x + y
    End Function

    Public Function Increment() As Integer
        Data += 1
        Return Data
    End Function
End Class
