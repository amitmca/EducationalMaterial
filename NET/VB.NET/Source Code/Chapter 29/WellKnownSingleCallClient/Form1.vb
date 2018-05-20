Imports System.Runtime.Remoting
Imports System.Runtime.Remoting.Channels
Imports System.Runtime.Remoting.Channels.Tcp
Imports System.Runtime.Remoting.Activation
Imports SharedObject


Public Class Form1
    Inherits System.Windows.Forms.Form

    Dim Obj As SharedObject.SharedObject
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
    Friend WithEvents Button3 As System.Windows.Forms.Button
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.Button3 = New System.Windows.Forms.Button
        Me.Label1 = New System.Windows.Forms.Label
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(64, 72)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(128, 32)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Connect"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(64, 120)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(128, 32)
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "Call Greetings"
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(64, 168)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(128, 32)
        Me.Button3.TabIndex = 2
        Me.Button3.Text = "Get Count"
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(24, 24)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(96, 16)
        Me.Label1.TabIndex = 25
        Me.Label1.Text = "My Code Name :"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(128, 24)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(112, 20)
        Me.TextBox1.TabIndex = 24
        Me.TextBox1.Text = ""
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(264, 238)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        ChannelServices.RegisterChannel(New TcpChannel)
        Obj = CType(Activator.GetObject(GetType(SharedObject.SharedObject), "tcp://localhost:8086/HiServerApp/HiServer"), SharedObject.SharedObject)
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        If Not Obj Is Nothing Then
            Obj.Greeting(TextBox1.Text)
        End If
    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        If Not Obj Is Nothing Then
            MsgBox(Obj.GetCount)
        End If
    End Sub
End Class
