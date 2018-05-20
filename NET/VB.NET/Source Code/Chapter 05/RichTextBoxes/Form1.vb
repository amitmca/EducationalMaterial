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
    Friend WithEvents Button4 As System.Windows.Forms.Button
    Friend WithEvents Button5 As System.Windows.Forms.Button
    Friend WithEvents Button6 As System.Windows.Forms.Button
    Friend WithEvents RichTextBox1 As System.Windows.Forms.RichTextBox
    Friend WithEvents RichTextBox2 As System.Windows.Forms.RichTextBox
    Friend WithEvents RichTextBox3 As System.Windows.Forms.RichTextBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.Button3 = New System.Windows.Forms.Button
        Me.Button4 = New System.Windows.Forms.Button
        Me.Button5 = New System.Windows.Forms.Button
        Me.Button6 = New System.Windows.Forms.Button
        Me.RichTextBox1 = New System.Windows.Forms.RichTextBox
        Me.RichTextBox2 = New System.Windows.Forms.RichTextBox
        Me.RichTextBox3 = New System.Windows.Forms.RichTextBox
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(16, 24)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(136, 23)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Format text"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(16, 64)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(136, 23)
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "Copy text"
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(16, 104)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(136, 23)
        Me.Button3.TabIndex = 2
        Me.Button3.Text = "Indent text"
        '
        'Button4
        '
        Me.Button4.Location = New System.Drawing.Point(16, 144)
        Me.Button4.Name = "Button4"
        Me.Button4.Size = New System.Drawing.Size(136, 23)
        Me.Button4.TabIndex = 3
        Me.Button4.Text = "Add bullets"
        '
        'Button5
        '
        Me.Button5.Location = New System.Drawing.Point(16, 184)
        Me.Button5.Name = "Button5"
        Me.Button5.Size = New System.Drawing.Size(136, 23)
        Me.Button5.TabIndex = 4
        Me.Button5.Text = "Color text"
        '
        'Button6
        '
        Me.Button6.Location = New System.Drawing.Point(16, 224)
        Me.Button6.Name = "Button6"
        Me.Button6.Size = New System.Drawing.Size(136, 23)
        Me.Button6.TabIndex = 5
        Me.Button6.Text = "Save and restore text"
        '
        'RichTextBox1
        '
        Me.RichTextBox1.Location = New System.Drawing.Point(176, 8)
        Me.RichTextBox1.Name = "RichTextBox1"
        Me.RichTextBox1.Size = New System.Drawing.Size(100, 72)
        Me.RichTextBox1.TabIndex = 6
        Me.RichTextBox1.Text = "Here is italic, bold, underlined, and strikeout text."
        '
        'RichTextBox2
        '
        Me.RichTextBox2.Location = New System.Drawing.Point(176, 90)
        Me.RichTextBox2.Name = "RichTextBox2"
        Me.RichTextBox2.Size = New System.Drawing.Size(100, 72)
        Me.RichTextBox2.TabIndex = 7
        Me.RichTextBox2.Text = ""
        '
        'RichTextBox3
        '
        Me.RichTextBox3.Location = New System.Drawing.Point(176, 172)
        Me.RichTextBox3.Name = "RichTextBox3"
        Me.RichTextBox3.Size = New System.Drawing.Size(100, 72)
        Me.RichTextBox3.TabIndex = 8
        Me.RichTextBox3.Text = "This rich text box supports font colors like red and blue and green."
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.RichTextBox3)
        Me.Controls.Add(Me.RichTextBox2)
        Me.Controls.Add(Me.RichTextBox1)
        Me.Controls.Add(Me.Button6)
        Me.Controls.Add(Me.Button5)
        Me.Controls.Add(Me.Button4)
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
        RichTextBox1.SelectionStart = RichTextBox1.Find("italic")
        Dim ItalicFont As New Font(RichTextBox1.Font, FontStyle.Italic)
        RichTextBox1.SelectionFont = ItalicFont

        RichTextBox1.SelectionStart = RichTextBox1.Find("bold")
        Dim BoldFont As New Font(RichTextBox1.Font, FontStyle.Bold)
        RichTextBox1.SelectionFont = BoldFont

        RichTextBox1.SelectionStart = RichTextBox1.Find("underlined")
        Dim UnderlineFont As New Font(RichTextBox1.Font, FontStyle.Underline)
        RichTextBox1.SelectionFont = UnderlineFont

        RichTextBox1.SelectionStart = RichTextBox1.Find("strikeout")
        Dim StrikeoutFont As New Font(RichTextBox1.Font, FontStyle.Strikeout)
        RichTextBox1.SelectionFont = StrikeoutFont
    End Sub
    Private Sub Button2_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button2.Click
        RichTextBox2.Rtf = RichTextBox1.Rtf
    End Sub
    Private Sub Button3_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button3.Click
        RichTextBox1.SelectionIndent = 20
        RichTextBox1.SelectionHangingIndent = -25
        RichTextBox1.SelectionRightIndent = 10
    End Sub
    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As _
    System.EventArgs) Handles Button4.Click
        RichTextBox1.Text = "This rich text box shows how to use bullets " + _
            "and indent bulleted text."
        RichTextBox1.SelectionIndent = 20
        RichTextBox1.BulletIndent = 10
        RichTextBox1.SelectionBullet = True
    End Sub
    Private Sub Button5_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button5.Click
        RichTextBox3.SelectionStart = RichTextBox3.Find("red")
        RichTextBox3.SelectionColor = Color.Red

        RichTextBox3.SelectionStart = RichTextBox3.Find("green")
        RichTextBox3.SelectionColor = Color.Green

        RichTextBox3.SelectionStart = RichTextBox3.Find("blue")
        RichTextBox3.SelectionColor = Color.Blue
    End Sub
    Private Sub Button6_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button6.Click
        RichTextBox3.SaveFile("text.rtf")
        RichTextBox1.LoadFile("text.rtf")
    End Sub

End Class
