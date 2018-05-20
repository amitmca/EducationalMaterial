Public Class Form1
    Inherits System.Windows.Forms.Form
    Dim WithEvents Button1 As Button
    Dim WithEvents Button2 As Button
    Dim WithEvents Button3 As Button


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
    Friend WithEvents Button4 As System.Windows.Forms.Button
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button4 = New System.Windows.Forms.Button
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.SuspendLayout()
        '
        'Button4
        '
        Me.Button4.Location = New System.Drawing.Point(80, 208)
        Me.Button4.Name = "Button4"
        Me.Button4.Size = New System.Drawing.Size(128, 23)
        Me.Button4.TabIndex = 0
        Me.Button4.Text = "Create Control Array"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(40, 160)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(200, 20)
        Me.TextBox1.TabIndex = 1
        Me.TextBox1.Text = "TextBox1"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button4)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private Sub Button4_Click(ByVal sender As System.Object, _
         ByVal e As System.EventArgs) Handles Button4.Click
        Button1 = New Button
        Button2 = New Button
        Button3 = New Button

        Button1.Size = New Size(80, 30)
        Button1.Location = New Point(115, 20)
        Button1.Text = "Button 1"

        Button2.Size = New Size(80, 30)
        Button2.Location = New Point(115, 60)
        Button2.Text = "Button 2"

        Button3.Size = New Size(80, 30)
        Button3.Location = New Point(115, 100)
        Button3.Text = "Button 3"

        Controls.Add(Button1)
        Controls.Add(Button2)
        Controls.Add(Button3)

        AddHandler Button1.Click, AddressOf Button_Click
        AddHandler Button2.Click, AddressOf Button_Click
        AddHandler Button3.Click, AddressOf Button_Click
    End Sub

    Private Sub Button_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs)
        If sender Is Button1 Then
            TextBox1.Text = "You clicked button 1"
        End If
        If sender Is Button2 Then
            TextBox1.Text = "You clicked button 2"
        End If
        If sender Is Button3 Then
            TextBox1.Text = "You clicked button 3"
        End If
    End Sub

End Class