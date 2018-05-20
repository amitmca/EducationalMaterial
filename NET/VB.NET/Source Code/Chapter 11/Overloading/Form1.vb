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
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(56, 56)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(184, 24)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Call Display version 1"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(56, 96)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(184, 24)
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "Call Display version 2"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Dim notifierObject As New Notifier

    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        notifierObject.Display("Hello from Visual Basic!")
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button2.Click
        notifierObject.Display("Hello from Visual Basic!", _
            MsgBoxStyle.Exclamation)
    End Sub

    Public Class Notifier
        Public Sub Display(ByVal Message As String)
            MsgBox(Message)
        End Sub

        Public Sub Display(ByVal Message As String, ByVal Icon _
            As MsgBoxStyle)
            MsgBox(Message, Icon)
        End Sub
    End Class

End Class
