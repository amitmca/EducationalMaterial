
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
    Friend WithEvents StatusBar1 As System.Windows.Forms.StatusBar
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents TextBox2 As System.Windows.Forms.TextBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.Label1 = New System.Windows.Forms.Label
        Me.StatusBar1 = New System.Windows.Forms.StatusBar
        Me.Label2 = New System.Windows.Forms.Label
        Me.TextBox2 = New System.Windows.Forms.TextBox
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(32, 24)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(224, 40)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Write and read file"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(16, 112)
        Me.TextBox1.Multiline = True
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.ScrollBars = System.Windows.Forms.ScrollBars.Vertical
        Me.TextBox1.Size = New System.Drawing.Size(256, 80)
        Me.TextBox1.TabIndex = 1
        Me.TextBox1.Text = ""
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(16, 88)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(200, 16)
        Me.Label1.TabIndex = 2
        Me.Label1.Text = "File Contents Accessed Through App:"
        '
        'StatusBar1
        '
        Me.StatusBar1.Location = New System.Drawing.Point(0, 325)
        Me.StatusBar1.Name = "StatusBar1"
        Me.StatusBar1.Size = New System.Drawing.Size(292, 16)
        Me.StatusBar1.TabIndex = 4
        Me.StatusBar1.Text = "Click the button to access c:\file.txt"
        '
        'Label2
        '
        Me.Label2.Location = New System.Drawing.Point(16, 208)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(192, 16)
        Me.Label2.TabIndex = 6
        Me.Label2.Text = "File Contents Accessed Through Lib:"
        '
        'TextBox2
        '
        Me.TextBox2.Location = New System.Drawing.Point(16, 232)
        Me.TextBox2.Multiline = True
        Me.TextBox2.Name = "TextBox2"
        Me.TextBox2.ScrollBars = System.Windows.Forms.ScrollBars.Vertical
        Me.TextBox2.Size = New System.Drawing.Size(256, 80)
        Me.TextBox2.TabIndex = 5
        Me.TextBox2.Text = ""
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 341)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.TextBox2)
        Me.Controls.Add(Me.StatusBar1)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button1)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog
        Me.Name = "Form1"
        Me.Text = "Application Two"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        StatusBar1.Text = ""
        Dim bAF As Boolean
        Dim bLF As Boolean
        Try
            Dim fs As New System.IO.FileStream("C:\file.txt", FileMode.OpenOrCreate, _
                    FileAccess.Write)

            Dim w As New StreamWriter(fs)
            w.BaseStream.Seek(0, SeekOrigin.End)
            w.WriteLine("Here is the file's text.")
            w.Write("Here is more file text." & ControlChars.CrLf)
            w.WriteLine("And that's about it.")
            w.Flush()
            w.Close()

            fs = New System.IO.FileStream("C:\file.txt", FileMode.Open, _
                FileAccess.Read)

            Dim r As New StreamReader(fs)
            r.BaseStream.Seek(0, SeekOrigin.Begin)
            TextBox1.Text = ""
            While r.Peek() > -1
                TextBox1.Text &= r.ReadLine() & ControlChars.CrLf
            End While
            r.Close()
            bAF = True
        Catch ' ex As Exception
            bAF = False
        End Try

        Try
            Dim FA As New FileAccessLib.Class1
            Dim FileText As String
            bLF = FA.AccessFile(FileText)
            TextBox2.Text = FileText
        Catch
        End Try

        StatusBar1.Text = IIf(bAF And bLF, "Both app and the lib were allowed access.", _
        IIf(bAF Or bLF, IIf(bAF And Not bLF, "App was but lib was not allowed access", _
        "App wansn't but lib was allowed access"), "Neither app nor lib was allowed access."))

    End Sub
End Class
