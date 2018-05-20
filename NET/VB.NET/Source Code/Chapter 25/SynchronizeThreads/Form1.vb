Public Class Form1
    Inherits System.Windows.Forms.Form

#Region " Windows Form Designer generated code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Windows Form Designer.
        InitializeComponent()
        Application.EnableVisualStyles()

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
        Me.Button1.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button1.Location = New System.Drawing.Point(112, 32)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(144, 23)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Start both Threads"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(112, 96)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(144, 20)
        Me.TextBox1.TabIndex = 1
        Me.TextBox1.Text = ""
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(112, 72)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(100, 16)
        Me.Label1.TabIndex = 2
        Me.Label1.Text = "Total Count"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(400, 218)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Synchronize Threads Example"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Dim c As New Counter
    Dim Thread1 As New System.Threading.Thread(AddressOf Counter1)
    Dim Thread2 As New System.Threading.Thread(AddressOf Counter2)

    Public Class Counter
        Public Total As Integer

    End Class

    Private Sub Counter1()
        Dim loopIndex As Integer
        For loopIndex = 1 To 100

            SyncLock c
                Dim Temp = c.Total
                Thread1.Sleep(1)
                c.Total = Temp + 1
            End SyncLock

        Next loopIndex
    End Sub

    Private Sub Counter2()
        Dim loopindex As Integer
        For loopindex = 1 To 100
            SyncLock c
                Dim Temp = c.Total
                Thread2.Sleep(1)
                c.Total = Temp + 1
            End SyncLock
            
        Next loopindex
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Thread1.Start()
        Thread2.Start()
        Thread1.Join()
        Thread2.Join()
        TextBox1.Text = c.Total
    End Sub

   
End Class
