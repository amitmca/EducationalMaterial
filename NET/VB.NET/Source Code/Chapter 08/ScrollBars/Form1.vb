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
    Friend WithEvents HScrollBar1 As System.Windows.Forms.HScrollBar
    Friend WithEvents VScrollBar1 As System.Windows.Forms.VScrollBar
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents HScrollBar2 As System.Windows.Forms.HScrollBar
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.HScrollBar1 = New System.Windows.Forms.HScrollBar
        Me.VScrollBar1 = New System.Windows.Forms.VScrollBar
        Me.Label1 = New System.Windows.Forms.Label
        Me.HScrollBar2 = New System.Windows.Forms.HScrollBar
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.SuspendLayout()
        '
        'HScrollBar1
        '
        Me.HScrollBar1.Dock = System.Windows.Forms.DockStyle.Top
        Me.HScrollBar1.Location = New System.Drawing.Point(0, 0)
        Me.HScrollBar1.Name = "HScrollBar1"
        Me.HScrollBar1.Size = New System.Drawing.Size(292, 17)
        Me.HScrollBar1.TabIndex = 0
        '
        'VScrollBar1
        '
        Me.VScrollBar1.Dock = System.Windows.Forms.DockStyle.Right
        Me.VScrollBar1.Location = New System.Drawing.Point(276, 17)
        Me.VScrollBar1.Name = "VScrollBar1"
        Me.VScrollBar1.Size = New System.Drawing.Size(16, 249)
        Me.VScrollBar1.TabIndex = 1
        '
        'Label1
        '
        Me.Label1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.Label1.Location = New System.Drawing.Point(56, 64)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(112, 23)
        Me.Label1.TabIndex = 2
        Me.Label1.Text = "Label1"
        '
        'HScrollBar2
        '
        Me.HScrollBar2.Location = New System.Drawing.Point(48, 128)
        Me.HScrollBar2.Name = "HScrollBar2"
        Me.HScrollBar2.Size = New System.Drawing.Size(176, 17)
        Me.HScrollBar2.TabIndex = 3
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(48, 184)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(176, 20)
        Me.TextBox1.TabIndex = 4
        Me.TextBox1.Text = "TextBox1"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.HScrollBar2)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.VScrollBar1)
        Me.Controls.Add(Me.HScrollBar1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private Sub HScrollBar1_Scroll(ByVal sender As System.Object, _
        ByVal e As System.Windows.Forms.ScrollEventArgs) Handles _
            HScrollBar1.Scroll
        Label1.Location = New Point(e.NewValue * Me.Size.Width / 100, _
            Label1.Location.Y)
        Label1.Text = "I'm moving!"
    End Sub

    Private Sub VScrollBar1_Scroll(ByVal sender As System.Object, _
        ByVal e As System.Windows.Forms.ScrollEventArgs) Handles _
            VScrollBar1.Scroll
        Label1.Location = New Point(Label1.Location.X, _
            e.NewValue * Me.Size.Height / 100)
        Label1.Text = "I'm moving!"
    End Sub
    Private Sub HScrollBar2_Scroll(ByVal sender As System.Object, _
        ByVal e As System.Windows.Forms.ScrollEventArgs) Handles _
            HScrollBar2.Scroll
        TextBox1.Text = "Scroll position: " & e.NewValue
    End Sub

End Class
