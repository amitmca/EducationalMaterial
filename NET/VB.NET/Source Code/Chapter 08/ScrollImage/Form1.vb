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
    Friend WithEvents PictureBox1 As System.Windows.Forms.PictureBox
    Friend WithEvents OpenFileDialog1 As System.Windows.Forms.OpenFileDialog
    Friend WithEvents HScrollBar1 As System.Windows.Forms.HScrollBar
    Friend WithEvents VScrollBar1 As System.Windows.Forms.VScrollBar
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.PictureBox1 = New System.Windows.Forms.PictureBox
        Me.OpenFileDialog1 = New System.Windows.Forms.OpenFileDialog
        Me.HScrollBar1 = New System.Windows.Forms.HScrollBar
        Me.VScrollBar1 = New System.Windows.Forms.VScrollBar
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(96, 160)
        Me.Button1.Name = "Button1"
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Load image"
        '
        'PictureBox1
        '
        Me.PictureBox1.Location = New System.Drawing.Point(32, 32)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(248, 80)
        Me.PictureBox1.TabIndex = 1
        Me.PictureBox1.TabStop = False
        '
        'HScrollBar1
        '
        Me.HScrollBar1.Location = New System.Drawing.Point(32, 96)
        Me.HScrollBar1.Name = "HScrollBar1"
        Me.HScrollBar1.Size = New System.Drawing.Size(232, 17)
        Me.HScrollBar1.TabIndex = 2
        '
        'VScrollBar1
        '
        Me.VScrollBar1.Location = New System.Drawing.Point(264, 24)
        Me.VScrollBar1.Name = "VScrollBar1"
        Me.VScrollBar1.Size = New System.Drawing.Size(16, 88)
        Me.VScrollBar1.TabIndex = 3
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(296, 230)
        Me.Controls.Add(Me.VScrollBar1)
        Me.Controls.Add(Me.HScrollBar1)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub ShowScrollBars()
        VScrollBar1.Visible = True
        HScrollBar1.Visible = True

        If PictureBox1.Height > PictureBox1.Image.Height Then
            VScrollBar1.Visible = False
        End If

        If PictureBox1.Width > PictureBox1.Image.Width Then
            HScrollBar1.Visible = False
        End If
    End Sub

    Public Sub ScrollBars_Scroll(ByVal sender As Object, _
        ByVal se As ScrollEventArgs)
        Dim graphics As Graphics = PictureBox1.CreateGraphics()
        graphics.DrawImage(PictureBox1.Image, New Rectangle(0, 0, _
            PictureBox1.Width - HScrollBar1.Height, _
            PictureBox1.Height - VScrollBar1.Width), _
            New Rectangle(HScrollBar1.Value, VScrollBar1.Value, _
            PictureBox1.Width - HScrollBar1.Height, _
            PictureBox1.Height - VScrollBar1.Width), GraphicsUnit.Pixel)
    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles MyBase.Load
        AddHandler HScrollBar1.Scroll, AddressOf ScrollBars_Scroll
        AddHandler VScrollBar1.Scroll, AddressOf ScrollBars_Scroll
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        If OpenFileDialog1.ShowDialog() <> DialogResult.Cancel Then
            PictureBox1.Image = Image.FromFile(OpenFileDialog1.FileName)
            HScrollBar1.Maximum = PictureBox1.Image.Width - _
                PictureBox1.Width
            VScrollBar1.Maximum = PictureBox1.Image.Height - _
                PictureBox1.Height
            ShowScrollBars()
        End If
    End Sub
End Class

