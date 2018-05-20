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
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents Button2 As System.Windows.Forms.Button
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(80, 184)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(128, 20)
        Me.TextBox1.TabIndex = 0
        Me.TextBox1.Text = ""
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(72, 56)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(144, 32)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "Create a dog..."
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(72, 112)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(144, 32)
        Me.Button2.TabIndex = 2
        Me.Button2.Text = "Create a fish..."
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.TextBox1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Dim spot As Dog

    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        spot = New Dog(Me)
        spot.Breathing()
    End Sub


    Dim jaws As Fish
    'Dim obj As Animal

    Private Sub Button2_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button2.Click
        jaws = New Fish(Me)
        jaws.Breathing()

        'obj = New Fish(Me)
        'obj.Breathing()
    End Sub

End Class
Public Class Animal
    Protected MainForm As Form1
    Public Sub New(ByVal form1 As Form1)
        MainForm = form1
    End Sub

    Public Overridable Sub Breathing()
        MainForm.TextBox1.Text = "Breathing..."
    End Sub
End Class

Public Class Fish
    Inherits Animal

    Public Sub New(ByVal form1 As Form1)
        MyBase.New(form1)
    End Sub

    Public Overrides Sub Breathing()
        MyBase.MainForm.TextBox1.Text = "Bubbling..."
    End Sub
End Class

Public Class Dog
    Inherits Animal

    Public Sub New(ByVal form1 As Form1)
        MyBase.New(form1)
    End Sub

    Public Sub Barking()
        MainForm.TextBox1.Text = "Barking..."
    End Sub
End Class

Public Class Displayer
    Friend Sub Display(ByVal Text As String)
        MsgBox(Text)
    End Sub
End Class
