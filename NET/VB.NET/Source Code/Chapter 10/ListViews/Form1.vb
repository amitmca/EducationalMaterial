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
    Friend WithEvents ImageList1 As System.Windows.Forms.ImageList
    Friend WithEvents ListView1 As System.Windows.Forms.ListView
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents ComboBox1 As System.Windows.Forms.ComboBox
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents ImageList2 As System.Windows.Forms.ImageList
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container
        Dim resources As System.Resources.ResourceManager = New System.Resources.ResourceManager(GetType(Form1))
        Me.ImageList1 = New System.Windows.Forms.ImageList(Me.components)
        Me.ListView1 = New System.Windows.Forms.ListView
        Me.Button1 = New System.Windows.Forms.Button
        Me.ComboBox1 = New System.Windows.Forms.ComboBox
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.ImageList2 = New System.Windows.Forms.ImageList(Me.components)
        Me.SuspendLayout()
        '
        'ImageList1
        '
        Me.ImageList1.ImageSize = New System.Drawing.Size(16, 16)
        Me.ImageList1.ImageStream = CType(resources.GetObject("ImageList1.ImageStream"), System.Windows.Forms.ImageListStreamer)
        Me.ImageList1.TransparentColor = System.Drawing.Color.Transparent
        '
        'ListView1
        '
        Me.ListView1.Anchor = CType((((System.Windows.Forms.AnchorStyles.Top Or System.Windows.Forms.AnchorStyles.Bottom) _
                    Or System.Windows.Forms.AnchorStyles.Left) _
                    Or System.Windows.Forms.AnchorStyles.Right), System.Windows.Forms.AnchorStyles)
        Me.ListView1.Location = New System.Drawing.Point(16, 16)
        Me.ListView1.Name = "ListView1"
        Me.ListView1.Size = New System.Drawing.Size(424, 200)
        Me.ListView1.TabIndex = 0
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(224, 232)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(120, 23)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "Add check boxes"
        '
        'ComboBox1
        '
        Me.ComboBox1.Location = New System.Drawing.Point(352, 232)
        Me.ComboBox1.Name = "ComboBox1"
        Me.ComboBox1.Size = New System.Drawing.Size(88, 21)
        Me.ComboBox1.TabIndex = 2
        Me.ComboBox1.Text = "ComboBox1"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(24, 232)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(192, 20)
        Me.TextBox1.TabIndex = 3
        Me.TextBox1.Text = ""
        '
        'ImageList2
        '
        Me.ImageList2.ImageSize = New System.Drawing.Size(32, 32)
        Me.ImageList2.ImageStream = CType(resources.GetObject("ImageList2.ImageStream"), System.Windows.Forms.ImageListStreamer)
        Me.ImageList2.TransparentColor = System.Drawing.Color.Transparent
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(456, 266)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.ComboBox1)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.ListView1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region


    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        ListView1.CheckBoxes = True
    End Sub

    Private Sub Form1_Load(ByVal eventSender As System.Object, _
ByVal eventArgs As System.EventArgs) Handles MyBase.Load
        ListView1.Columns.Add("Field 1", ListView1.Width / 4, _
        HorizontalAlignment.Left)
        ListView1.Columns.Add("Field 2", ListView1.Width / 4, _
        HorizontalAlignment.Left)
        ListView1.Columns.Add("Field 3", ListView1.Width / 4, _
        HorizontalAlignment.Left)
        ListView1.Columns.Add("Field 4", ListView1.Width / 4, _
        HorizontalAlignment.Left)
        Dim ListItem1 As ListViewItem
        ListItem1 = ListView1.Items.Add("Item 1", 1)
        ListView1.Items(0).SubItems.Add("Field 2")
        ListView1.Items(0).SubItems.Add("Field 3")
        ListView1.Items(0).SubItems.Add("Field 4")
        Dim ListItem2 As ListViewItem
        ListItem2 = ListView1.Items.Add("Item 2", 1)
        ListView1.Items(1).SubItems.Add("Field 2")
        ListView1.Items(1).SubItems.Add("Field 3")
        ListView1.Items(1).SubItems.Add("Field 4")
        Dim ListItem3 As ListViewItem
        ListItem2 = ListView1.Items.Add("Item 3", 1)
        ListView1.Items(2).SubItems.Add("Field 2")
        ListView1.Items(2).SubItems.Add("Field 3")
        ListView1.Items(2).SubItems.Add("Field 4")
        ListView1.SmallImageList = ImageList1
        ListView1.LargeImageList = ImageList2

        With ComboBox1
            .Items.Add("Large Icon View")
            .Items.Add("Report View")
            .Items.Add("Small Icon View")
            .Items.Add("List View")
        End With
    End Sub

    Private Sub ComboBox1_SelectedIndexChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged
        ListView1.View = ComboBox1.SelectedIndex
    End Sub


    Private Sub ListView1_SelectedIndexChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles ListView1.SelectedIndexChanged

        If ListView1.SelectedIndices.Count > 0 Then
            TextBox1.Text = "You clicked item " & _
            (ListView1.SelectedIndices(0) + 1)
        End If

    End Sub
End Class
