Imports System.IO

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
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents Button1 As System.Windows.Forms.Button
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Label1 = New System.Windows.Forms.Label
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.Button1 = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(40, 72)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(162, 16)
        Me.Label1.TabIndex = 5
        Me.Label1.Text = "Integers written and then read:"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(40, 96)
        Me.TextBox1.Multiline = True
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.ScrollBars = System.Windows.Forms.ScrollBars.Vertical
        Me.TextBox1.Size = New System.Drawing.Size(216, 136)
        Me.TextBox1.TabIndex = 4
        Me.TextBox1.Text = ""
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(40, 16)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(216, 32)
        Me.Button1.TabIndex = 3
        Me.Button1.Tag = ""
        Me.Button1.Text = "Write and read file"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Button1_Click_1(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim fs As FileStream = New FileStream("data.dat", _
            FileMode.OpenOrCreate)
        Dim w As BinaryWriter = New BinaryWriter(fs)
        Dim LoopIndex As Int32

        For LoopIndex = 0 To 19
            w.Write(LoopIndex)
        Next

        w.Seek(0, SeekOrigin.Begin)
        Dim r As BinaryReader = New BinaryReader(fs)

        For LoopIndex = 0 To 19
            TextBox1.Text &= r.ReadInt32() & ControlChars.CrLf
        Next
    End Sub
End Class
