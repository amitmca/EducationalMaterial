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
    Friend WithEvents ToolBar1 As System.Windows.Forms.ToolBar
    Friend WithEvents ToolBarButton1 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton2 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton3 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton4 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton5 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton7 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ComboBox1 As System.Windows.Forms.ComboBox
    Friend WithEvents ToolBarButton8 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton9 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton10 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton11 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton12 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton13 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton14 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton15 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton16 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton17 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton18 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton19 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton20 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton21 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton22 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton23 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton24 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton25 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton26 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton27 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton28 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton29 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton6 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ContextMenu1 As System.Windows.Forms.ContextMenu
    Friend WithEvents MenuItem1 As System.Windows.Forms.MenuItem
    Friend WithEvents MainMenu1 As System.Windows.Forms.MainMenu
    Friend WithEvents MenuItem4 As System.Windows.Forms.MenuItem
    Friend WithEvents MenuItem5 As System.Windows.Forms.MenuItem
    Friend WithEvents MenuItem6 As System.Windows.Forms.MenuItem
    Friend WithEvents MenuItem7 As System.Windows.Forms.MenuItem
    Friend WithEvents MenuItem8 As System.Windows.Forms.MenuItem
    Friend WithEvents MenuItem9 As System.Windows.Forms.MenuItem
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents MenuItem2 As System.Windows.Forms.MenuItem
    Friend WithEvents MenuItem3 As System.Windows.Forms.MenuItem
    Friend WithEvents ImageList1 As System.Windows.Forms.ImageList
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container
        Dim resources As System.Resources.ResourceManager = New System.Resources.ResourceManager(GetType(Form1))
        Me.ToolBar1 = New System.Windows.Forms.ToolBar
        Me.ToolBarButton1 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton2 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton3 = New System.Windows.Forms.ToolBarButton
        Me.ContextMenu1 = New System.Windows.Forms.ContextMenu
        Me.MenuItem1 = New System.Windows.Forms.MenuItem
        Me.MenuItem2 = New System.Windows.Forms.MenuItem
        Me.MenuItem3 = New System.Windows.Forms.MenuItem
        Me.ToolBarButton4 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton5 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton6 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton7 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton8 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton9 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton10 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton11 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton12 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton13 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton14 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton15 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton16 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton17 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton18 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton19 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton20 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton21 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton22 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton23 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton24 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton25 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton26 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton27 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton28 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton29 = New System.Windows.Forms.ToolBarButton
        Me.ComboBox1 = New System.Windows.Forms.ComboBox
        Me.MainMenu1 = New System.Windows.Forms.MainMenu
        Me.MenuItem4 = New System.Windows.Forms.MenuItem
        Me.MenuItem5 = New System.Windows.Forms.MenuItem
        Me.MenuItem6 = New System.Windows.Forms.MenuItem
        Me.MenuItem7 = New System.Windows.Forms.MenuItem
        Me.MenuItem8 = New System.Windows.Forms.MenuItem
        Me.MenuItem9 = New System.Windows.Forms.MenuItem
        Me.Button1 = New System.Windows.Forms.Button
        Me.ImageList1 = New System.Windows.Forms.ImageList(Me.components)
        Me.SuspendLayout()
        '
        'ToolBar1
        '
        Me.ToolBar1.Buttons.AddRange(New System.Windows.Forms.ToolBarButton() {Me.ToolBarButton5, Me.ToolBarButton2, Me.ToolBarButton3, Me.ToolBarButton4, Me.ToolBarButton6, Me.ToolBarButton7, Me.ToolBarButton8, Me.ToolBarButton9, Me.ToolBarButton10, Me.ToolBarButton11, Me.ToolBarButton12, Me.ToolBarButton13, Me.ToolBarButton14, Me.ToolBarButton15, Me.ToolBarButton16, Me.ToolBarButton17, Me.ToolBarButton18, Me.ToolBarButton19, Me.ToolBarButton20, Me.ToolBarButton21, Me.ToolBarButton22, Me.ToolBarButton23, Me.ToolBarButton24, Me.ToolBarButton25, Me.ToolBarButton26, Me.ToolBarButton27, Me.ToolBarButton28, Me.ToolBarButton29, Me.ToolBarButton1})
        Me.ToolBar1.DropDownArrows = True
        Me.ToolBar1.ImageList = Me.ImageList1
        Me.ToolBar1.Location = New System.Drawing.Point(0, 0)
        Me.ToolBar1.Name = "ToolBar1"
        Me.ToolBar1.ShowToolTips = True
        Me.ToolBar1.Size = New System.Drawing.Size(552, 58)
        Me.ToolBar1.TabIndex = 0
        '
        'ToolBarButton1
        '
        Me.ToolBarButton1.Text = "Menu Button"
        '
        'ToolBarButton2
        '
        Me.ToolBarButton2.Style = System.Windows.Forms.ToolBarButtonStyle.ToggleButton
        Me.ToolBarButton2.Text = "Toggle Button"
        '
        'ToolBarButton3
        '
        Me.ToolBarButton3.DropDownMenu = Me.ContextMenu1
        Me.ToolBarButton3.Style = System.Windows.Forms.ToolBarButtonStyle.DropDownButton
        Me.ToolBarButton3.Text = "Drop Down Button"
        '
        'ContextMenu1
        '
        Me.ContextMenu1.MenuItems.AddRange(New System.Windows.Forms.MenuItem() {Me.MenuItem1, Me.MenuItem2, Me.MenuItem3})
        '
        'MenuItem1
        '
        Me.MenuItem1.Index = 0
        Me.MenuItem1.Text = "Red"
        '
        'MenuItem2
        '
        Me.MenuItem2.Index = 1
        Me.MenuItem2.Text = "Blue"
        '
        'MenuItem3
        '
        Me.MenuItem3.Index = 2
        Me.MenuItem3.Text = "Green"
        '
        'ToolBarButton4
        '
        Me.ToolBarButton4.ImageIndex = 0
        Me.ToolBarButton4.Text = "Image Button"
        '
        'ToolBarButton5
        '
        Me.ToolBarButton5.Text = "Push Button"
        '
        'ToolBarButton6
        '
        Me.ToolBarButton6.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton7
        '
        Me.ToolBarButton7.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton8
        '
        Me.ToolBarButton8.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton9
        '
        Me.ToolBarButton9.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton10
        '
        Me.ToolBarButton10.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton11
        '
        Me.ToolBarButton11.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton12
        '
        Me.ToolBarButton12.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton13
        '
        Me.ToolBarButton13.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton14
        '
        Me.ToolBarButton14.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton15
        '
        Me.ToolBarButton15.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton16
        '
        Me.ToolBarButton16.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton17
        '
        Me.ToolBarButton17.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton18
        '
        Me.ToolBarButton18.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton19
        '
        Me.ToolBarButton19.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton20
        '
        Me.ToolBarButton20.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton21
        '
        Me.ToolBarButton21.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton22
        '
        Me.ToolBarButton22.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton23
        '
        Me.ToolBarButton23.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton24
        '
        Me.ToolBarButton24.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton25
        '
        Me.ToolBarButton25.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton26
        '
        Me.ToolBarButton26.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton27
        '
        Me.ToolBarButton27.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton28
        '
        Me.ToolBarButton28.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ToolBarButton29
        '
        Me.ToolBarButton29.Style = System.Windows.Forms.ToolBarButtonStyle.Separator
        '
        'ComboBox1
        '
        Me.ComboBox1.Items.AddRange(New Object() {"Red", "Blue", "Green"})
        Me.ComboBox1.Location = New System.Drawing.Point(359, 19)
        Me.ComboBox1.Name = "ComboBox1"
        Me.ComboBox1.Size = New System.Drawing.Size(88, 21)
        Me.ComboBox1.TabIndex = 1
        Me.ComboBox1.Text = "Select..."
        '
        'MainMenu1
        '
        Me.MainMenu1.MenuItems.AddRange(New System.Windows.Forms.MenuItem() {Me.MenuItem4, Me.MenuItem6})
        '
        'MenuItem4
        '
        Me.MenuItem4.Index = 0
        Me.MenuItem4.MenuItems.AddRange(New System.Windows.Forms.MenuItem() {Me.MenuItem5})
        Me.MenuItem4.Text = "File"
        '
        'MenuItem5
        '
        Me.MenuItem5.Index = 0
        Me.MenuItem5.Text = "Exit"
        '
        'MenuItem6
        '
        Me.MenuItem6.Index = 1
        Me.MenuItem6.MenuItems.AddRange(New System.Windows.Forms.MenuItem() {Me.MenuItem7, Me.MenuItem8, Me.MenuItem9})
        Me.MenuItem6.Text = "Color"
        '
        'MenuItem7
        '
        Me.MenuItem7.Index = 0
        Me.MenuItem7.Text = "Red"
        '
        'MenuItem8
        '
        Me.MenuItem8.Index = 1
        Me.MenuItem8.Text = "Blue"
        '
        'MenuItem9
        '
        Me.MenuItem9.Index = 2
        Me.MenuItem9.Text = "Green"
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(192, 168)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(128, 32)
        Me.Button1.TabIndex = 2
        Me.Button1.Text = "Add button"
        '
        'ImageList1
        '
        Me.ImageList1.ImageSize = New System.Drawing.Size(32, 32)
        Me.ImageList1.ImageStream = CType(resources.GetObject("ImageList1.ImageStream"), System.Windows.Forms.ImageListStreamer)
        Me.ImageList1.TransparentColor = System.Drawing.Color.Transparent
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(552, 266)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.ComboBox1)
        Me.Controls.Add(Me.ToolBar1)
        Me.Menu = Me.MainMenu1
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region


    Private Sub MenuItem1_Click(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles MenuItem1.Click
        MsgBox("You clicked Red")
    End Sub

    Private Sub MenuItem2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MenuItem2.Click
        MsgBox("You clicked Blue")
    End Sub

    Private Sub MenuItem3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MenuItem3.Click
        MsgBox("You clicked Green")
    End Sub

    Private Sub ToolBar1_ButtonClick(ByVal sender As System.Object, _
    ByVal e As System.Windows.Forms.ToolBarButtonClickEventArgs) Handles ToolBar1.ButtonClick
        If e.Button Is ToolBar1.Buttons(28) Then
            MenuItem7.PerformClick()
        End If
    End Sub


    Private Sub ComboBox1_SelectedIndexChanged(ByVal sender As System.Object, _
ByVal e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged
        Dim selectedIndex As Integer
        selectedIndex = ComboBox1.SelectedIndex
        Dim selectedItem As Object
        selectedItem = ComboBox1.SelectedItem
        MsgBox("Selected item text: " & selectedItem.ToString() & _
        " Selected index: " & selectedIndex.ToString())
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles Button1.Click
        Dim ToolBarButton As New ToolBarButton("New Button")
        ToolBar1.Buttons.Add(ToolBarButton)
    End Sub

    Private Sub MenuItem7_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MenuItem7.Click
        MenuItem1.PerformClick()
    End Sub

    Private Sub MenuItem8_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MenuItem8.Click
        MenuItem2.PerformClick()
    End Sub

    Private Sub MenuItem9_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MenuItem9.Click
        MenuItem3.PerformClick()
    End Sub
End Class
