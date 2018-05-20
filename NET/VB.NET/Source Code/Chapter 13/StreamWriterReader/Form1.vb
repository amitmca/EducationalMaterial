Imports System
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
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.Label1 = New System.Windows.Forms.Label
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(48, 24)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(200, 32)
        Me.Button1.TabIndex = 0
        Me.Button1.Tag = ""
        Me.Button1.Text = "Write and read file"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(48, 96)
        Me.TextBox1.Multiline = True
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(200, 136)
        Me.TextBox1.TabIndex = 1
        Me.TextBox1.Text = ""
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(48, 72)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(80, 16)
        Me.Label1.TabIndex = 2
        Me.Label1.Text = "File contents:"
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
        Dim fs As New System.IO.FileStream("file.txt", FileMode.Create, _
            FileAccess.Write)

        Dim w As New StreamWriter(fs)
        w.BaseStream.Seek(0, SeekOrigin.End)
        w.WriteLine("Here is the file's text.")
        w.Write("Here is more file text." & ControlChars.CrLf)
        w.WriteLine("And that's about it.")
        w.Flush()
        w.Close()

        fs = New System.IO.FileStream("file.txt", FileMode.Open, _
            FileAccess.Read)

        Dim r As New StreamReader(fs)
        r.BaseStream.Seek(0, SeekOrigin.Begin)
        While r.Peek() > -1
            TextBox1.Text &= r.ReadLine() & ControlChars.CrLf
        End While
        r.Close()
    End Sub
End Class
