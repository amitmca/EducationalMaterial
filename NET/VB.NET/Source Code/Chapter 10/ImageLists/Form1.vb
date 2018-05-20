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
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents PictureBox1 As System.Windows.Forms.PictureBox
    Friend WithEvents ImageList1 As System.Windows.Forms.ImageList
    Friend WithEvents Panel1 As System.Windows.Forms.Panel
    Friend WithEvents OpenFileDialog1 As System.Windows.Forms.OpenFileDialog
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container
        Dim resources As System.Resources.ResourceManager = New System.Resources.ResourceManager(GetType(Form1))
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.Button3 = New System.Windows.Forms.Button
        Me.Button4 = New System.Windows.Forms.Button
        Me.Label1 = New System.Windows.Forms.Label
        Me.PictureBox1 = New System.Windows.Forms.PictureBox
        Me.ImageList1 = New System.Windows.Forms.ImageList(Me.components)
        Me.Panel1 = New System.Windows.Forms.Panel
        Me.OpenFileDialog1 = New System.Windows.Forms.OpenFileDialog
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(96, 104)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(80, 24)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "New image"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(96, 240)
        Me.Button2.Name = "Button2"
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "New image"
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(96, 368)
        Me.Button3.Name = "Button3"
        Me.Button3.TabIndex = 2
        Me.Button3.Text = "New image"
        '
        'Button4
        '
        Me.Button4.Location = New System.Drawing.Point(96, 400)
        Me.Button4.Name = "Button4"
        Me.Button4.TabIndex = 3
        Me.Button4.Text = "Add image"
        '
        'Label1
        '
        Me.Label1.ImageList = Me.ImageList1
        Me.Label1.Location = New System.Drawing.Point(40, 16)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(208, 80)
        Me.Label1.TabIndex = 4
        '
        'PictureBox1
        '
        Me.PictureBox1.Location = New System.Drawing.Point(40, 144)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(200, 80)
        Me.PictureBox1.TabIndex = 5
        Me.PictureBox1.TabStop = False
        '
        'ImageList1
        '
        Me.ImageList1.ImageSize = New System.Drawing.Size(208, 80)
        Me.ImageList1.ImageStream = CType(resources.GetObject("ImageList1.ImageStream"), System.Windows.Forms.ImageListStreamer)
        Me.ImageList1.TransparentColor = System.Drawing.Color.Transparent
        '
        'Panel1
        '
        Me.Panel1.Location = New System.Drawing.Point(40, 272)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(200, 88)
        Me.Panel1.TabIndex = 6
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 438)
        Me.Controls.Add(Me.Panel1)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.Label1)
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
        If Label1.ImageIndex < ImageList1.Images.Count - 1 Then
            Label1.ImageIndex += 1
        Else
            Label1.ImageIndex = 0
        End If
    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles MyBase.Load
        PictureBox1.Image = ImageList1.Images(0)
    End Sub
    Private Sub Button2_Click(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles Button2.Click
        Static ImageIndex As Integer = 0
        If ImageIndex < ImageList1.Images.Count - 1 Then
            ImageIndex += 1
        Else
            ImageIndex = 0
        End If
        PictureBox1.Image = ImageList1.Images(ImageIndex)
    End Sub

    Private Sub Panel1_Paint(ByVal sender As Object, _
    ByVal e As System.Windows.Forms.PaintEventArgs) Handles Panel1.Paint
        ImageList1.Draw(e.Graphics, 0, 0, ImageIndex)
    End Sub


    Dim ImageIndex As Integer = 0
    Private Sub Button3_Click(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles Button3.Click
        If ImageIndex < ImageList1.Images.Count - 1 Then
            ImageIndex += 1
        Else
            ImageIndex = 0
        End If
        ImageList1.Draw(Graphics.FromHwnd(Panel1.Handle), 0, 0, ImageIndex)
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles Button4.Click
        If openFileDialog1.ShowDialog() = DialogResult.OK Then
            If Not (openFileDialog1.FileNames Is Nothing) Then
                Dim intLoopIndex As Integer
                For intLoopIndex = 0 To OpenFileDialog1.FileNames.Length - 1
                    ImageList1.Images.Add( _
                    Image.FromFile( _
                    OpenFileDialog1.FileNames(intLoopIndex)))
                Next intLoopIndex
            Else
                ImageList1.Images.Add( _
                Image.FromFile( _
                OpenFileDialog1.FileNames(OpenFileDialog1.FileName)))
            End If
        End If
    End Sub

End Class
