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
    Friend WithEvents TreeView1 As System.Windows.Forms.TreeView
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents ImageList1 As System.Windows.Forms.ImageList
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container
        Dim resources As System.Resources.ResourceManager = New System.Resources.ResourceManager(GetType(Form1))
        Me.Button1 = New System.Windows.Forms.Button
        Me.TreeView1 = New System.Windows.Forms.TreeView
        Me.ImageList1 = New System.Windows.Forms.ImageList(Me.components)
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(72, 224)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(128, 23)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Show check boxes"
        '
        'TreeView1
        '
        Me.TreeView1.ImageList = Me.ImageList1
        Me.TreeView1.Location = New System.Drawing.Point(16, 16)
        Me.TreeView1.Name = "TreeView1"
        Me.TreeView1.Nodes.AddRange(New System.Windows.Forms.TreeNode() {New System.Windows.Forms.TreeNode("Options", 0, 1, New System.Windows.Forms.TreeNode() {New System.Windows.Forms.TreeNode("Colors", New System.Windows.Forms.TreeNode() {New System.Windows.Forms.TreeNode("Red", 2, 2), New System.Windows.Forms.TreeNode("Green", 2, 2), New System.Windows.Forms.TreeNode("Blue", 2, 2)}), New System.Windows.Forms.TreeNode("Sizes", New System.Windows.Forms.TreeNode() {New System.Windows.Forms.TreeNode("Big", 2, 2), New System.Windows.Forms.TreeNode("Little", 2, 2)})})})
        Me.TreeView1.Size = New System.Drawing.Size(264, 160)
        Me.TreeView1.TabIndex = 1
        '
        'ImageList1
        '
        Me.ImageList1.ImageSize = New System.Drawing.Size(16, 16)
        Me.ImageList1.ImageStream = CType(resources.GetObject("ImageList1.ImageStream"), System.Windows.Forms.ImageListStreamer)
        Me.ImageList1.TransparentColor = System.Drawing.Color.Transparent
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(56, 192)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(160, 20)
        Me.TextBox1.TabIndex = 2
        Me.TextBox1.Text = ""
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.TreeView1)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        TreeView1.CheckBoxes = True
    End Sub

    Private Sub TreeView1_AfterSelect(ByVal sender As Object, ByVal e As System.Windows.Forms.TreeViewEventArgs) Handles TreeView1.AfterSelect
        TextBox1.Text = "You clicked: " & e.Node.Text
    End Sub


    Private Sub TreeView1_AfterCheck(ByVal sender As Object, ByVal e As System.Windows.Forms.TreeViewEventArgs) Handles TreeView1.AfterCheck
        If e.Node.Checked Then
            TextBox1.Text = "You checked: " & e.Node.Text
        Else
            TextBox1.Text = "You unchecked: " & e.Node.Text
        End If

    End Sub
End Class
