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
        Me.Button1.Location = New System.Drawing.Point(48, 184)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(96, 23)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Create Panel"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(200, 238)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Button1_Click(ByVal sender As System.Object, _
          ByVal e As System.EventArgs) Handles Button1.Click
        Dim Panel1 As New Panel
        Dim TextBox1 As New TextBox
        Dim Label1 As New Label

        Panel1.Location = New Point(60, 20)
        Panel1.Size = New Size(100, 150)
        Panel1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D

        Label1.Location = New Point(16, 16)
        Label1.Text = "Enter text:"
        Label1.Size = New Size(60, 16)
        TextBox1.Location = New Point(16, 32)
        TextBox1.Text = ""
        TextBox1.Size = New Size(60, 20)

        Me.Controls.Add(Panel1)
        Panel1.Controls.Add(Label1)
        Panel1.Controls.Add(TextBox1)
    End Sub
End Class

