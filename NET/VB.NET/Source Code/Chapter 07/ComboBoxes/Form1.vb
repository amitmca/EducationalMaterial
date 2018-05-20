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
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents ComboBox1 As System.Windows.Forms.ComboBox
    Friend WithEvents Button2 As System.Windows.Forms.Button
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.ComboBox1 = New System.Windows.Forms.ComboBox
        Me.Button2 = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(96, 120)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(96, 23)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Fill combo box"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(48, 208)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(184, 20)
        Me.TextBox1.TabIndex = 1
        Me.TextBox1.Text = "TextBox1"
        '
        'ComboBox1
        '
        Me.ComboBox1.Location = New System.Drawing.Point(80, 48)
        Me.ComboBox1.Name = "ComboBox1"
        Me.ComboBox1.Size = New System.Drawing.Size(136, 21)
        Me.ComboBox1.TabIndex = 2
        Me.ComboBox1.Text = "ComboBox1"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(96, 160)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(96, 23)
        Me.Button2.TabIndex = 3
        Me.Button2.Text = "Get selected"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.ComboBox1)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private Sub Button1_Click(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles Button1.Click
        ComboBox1.BeginUpdate()
        Dim intLoopIndex As Integer
        For intLoopIndex = 0 To 20
            ComboBox1.Items.Add("Item " + intLoopIndex.ToString())
        Next
        ComboBox1.Text = "Select one..."
        ComboBox1.EndUpdate()
    End Sub
    Private Sub ComboBox1_TextChanged(ByVal sender As Object, _
    ByVal e As System.EventArgs) Handles ComboBox1.TextChanged
        TextBox1.Text = ComboBox1.Text
    End Sub
    Private Sub ComboBox1_SelectedIndexChanged(ByVal _
        sender As System.Object, ByVal e As System.EventArgs) _
        Handles ComboBox1.SelectedIndexChanged
        Dim SelectedIndex As Integer
        SelectedIndex = ComboBox1.SelectedIndex
        Dim SelectedItem As Object
        SelectedItem = ComboBox1.SelectedItem

        TextBox1.Text = "Selected item text: " & SelectedItem.ToString() & _
            " Selected index: " & SelectedIndex.ToString()
    End Sub
    Private Sub Button2_Click(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles Button2.Click
        Dim selectedIndex As Integer
        selectedIndex = ComboBox1.SelectedIndex
        Dim selectedItem As Object
        selectedItem = ComboBox1.SelectedItem

        TextBox1.Text = "Selected item text: " & selectedItem.ToString() & _
        " Selected index: " & selectedIndex.ToString()
    End Sub
End Class
