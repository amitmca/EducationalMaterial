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
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(72, 160)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(168, 48)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Create menu"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Dim mainMenu1 As New MainMenu

    Dim WithEvents menuItem1 As New MenuItem
    Dim WithEvents menuItem2 As New MenuItem
    Dim WithEvents menuItem3 As New MenuItem
    Dim WithEvents menuItem4 As New MenuItem

    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        menuItem1.Text = "File"
        menuItem2.Text = "New"
        menuItem3.Text = "Text File..."
        menuItem3.Checked = True
        menuItem3.Shortcut = Shortcut.CtrlT
        menuItem4.Text = "Image..."
        menuItem4.Shortcut = Shortcut.CtrlI
        menuItem2.MenuItems.Add(menuItem3)
        menuItem2.MenuItems.Add(menuItem4)
        AddHandler menuItem3.Click, AddressOf MenuItem3_Click
        menuItem1.MenuItems.Add(menuItem2)
        mainMenu1.MenuItems.Add(menuItem1)
        Menu = mainMenu1
    End Sub

    Private Sub MenuItem3_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles menuItem2.Click
        MsgBox("You clicked me!")
    End Sub

End Class
