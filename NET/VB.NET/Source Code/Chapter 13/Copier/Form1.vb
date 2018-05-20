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
    Friend WithEvents Button2 As System.Windows.Forms.Button
    Friend WithEvents OpenFileDialog1 As System.Windows.Forms.OpenFileDialog
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.OpenFileDialog1 = New System.Windows.Forms.OpenFileDialog
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.Label1 = New System.Windows.Forms.Label
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(56, 128)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(192, 32)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Create directory"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(56, 176)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(192, 32)
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "Copy file to new directory"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(56, 72)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(192, 20)
        Me.TextBox1.TabIndex = 2
        Me.TextBox1.Text = "TextBox1"
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(56, 48)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(160, 16)
        Me.Label1.TabIndex = 3
        Me.Label1.Text = "Full path of directory to create:"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        Try
            Directory.CreateDirectory(TextBox1.Text)
        Catch
            MsgBox("Could not create directory.")
            Exit Sub
        End Try
        MsgBox("Directory created.")
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button2.Click
        Try
            If OpenFileDialog1.ShowDialog <> DialogResult.Cancel Then
                File.Copy(OpenFileDialog1.FileName, TextBox1.Text & "\" & _
                    OpenFileDialog1.FileName.Substring( _
                    OpenFileDialog1.FileName.LastIndexOf("\")))
            End If
        Catch
            MsgBox("Could not copy file.")
            Exit Sub
        End Try
        MsgBox("File copied.")
    End Sub
End Class