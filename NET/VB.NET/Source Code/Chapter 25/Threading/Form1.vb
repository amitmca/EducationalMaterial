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
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents TextBox2 As System.Windows.Forms.TextBox
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents Button2 As System.Windows.Forms.Button
    Friend WithEvents Button3 As System.Windows.Forms.Button
    Friend WithEvents Button4 As System.Windows.Forms.Button
    Friend WithEvents Button5 As System.Windows.Forms.Button
    Friend WithEvents Button6 As System.Windows.Forms.Button
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Label1 = New System.Windows.Forms.Label
        Me.Label2 = New System.Windows.Forms.Label
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.TextBox2 = New System.Windows.Forms.TextBox
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.Button3 = New System.Windows.Forms.Button
        Me.Button4 = New System.Windows.Forms.Button
        Me.Button5 = New System.Windows.Forms.Button
        Me.Button6 = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(104, 24)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(100, 16)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Count to:"
        '
        'Label2
        '
        Me.Label2.Location = New System.Drawing.Point(104, 80)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(100, 13)
        Me.Label2.TabIndex = 1
        Me.Label2.Text = "Counted to:"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(104, 48)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.TabIndex = 2
        Me.TextBox1.Text = "100000"
        '
        'TextBox2
        '
        Me.TextBox2.Location = New System.Drawing.Point(104, 112)
        Me.TextBox2.Name = "TextBox2"
        Me.TextBox2.TabIndex = 3
        Me.TextBox2.Text = ""
        '
        'Button1
        '
        Me.Button1.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button1.Location = New System.Drawing.Point(96, 152)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(127, 23)
        Me.Button1.TabIndex = 4
        Me.Button1.Text = "Start Counting"
        '
        'Button2
        '
        Me.Button2.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button2.Location = New System.Drawing.Point(96, 192)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(127, 23)
        Me.Button2.TabIndex = 5
        Me.Button2.Text = "Suspend Counting"
        '
        'Button3
        '
        Me.Button3.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button3.Location = New System.Drawing.Point(96, 232)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(127, 23)
        Me.Button3.TabIndex = 6
        Me.Button3.Text = "Resume Counting"
        '
        'Button4
        '
        Me.Button4.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button4.Location = New System.Drawing.Point(96, 272)
        Me.Button4.Name = "Button4"
        Me.Button4.Size = New System.Drawing.Size(127, 23)
        Me.Button4.TabIndex = 7
        Me.Button4.Text = "Cancel Counting"
        '
        'Button5
        '
        Me.Button5.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button5.Location = New System.Drawing.Point(96, 312)
        Me.Button5.Name = "Button5"
        Me.Button5.Size = New System.Drawing.Size(127, 23)
        Me.Button5.TabIndex = 8
        Me.Button5.Text = "Sleep 10 seconds"
        '
        'Button6
        '
        Me.Button6.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button6.Location = New System.Drawing.Point(96, 352)
        Me.Button6.Name = "Button6"
        Me.Button6.Size = New System.Drawing.Size(127, 23)
        Me.Button6.TabIndex = 9
        Me.Button6.Text = "Set Low Priority"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(328, 394)
        Me.Controls.Add(Me.Button6)
        Me.Controls.Add(Me.Button5)
        Me.Controls.Add(Me.Button4)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.TextBox2)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form1"
        Me.Text = "Threading Example"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Dim Counter1 As New counter
    Dim Thread1 As New System.Threading.Thread(AddressOf Counter1.Count)



    Public Class counter
        Public CountTo As Integer
        Public Event FinishedCounting(ByVal NumberOfMatches As Integer)
        Sub Count()
            Dim Loopindex, Total As Integer
            Total = 0

            For Loopindex = 1 To CountTo
                Total += 1
            Next Loopindex
            RaiseEvent FinishedCounting(Total)
        End Sub
    End Class


    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        TextBox2.Text = ""
        Counter1.CountTo = TextBox1.Text
        AddHandler Counter1.FinishedCounting, AddressOf FinishedCountingEventhandler
        Thread1.Start()

    End Sub
    Sub FinishedCountingEventhandler(ByVal count As Integer)
        TextBox2.Text = count.ToString
    End Sub


    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Thread1.Suspend()
    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        Thread1.Resume()

    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Thread1.Abort()

    End Sub

    Private Sub Button5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button5.Click
        Thread1.Sleep(10 * 10000)
    End Sub

    Private Sub Button6_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button6.Click
        Thread1.Priority = System.Threading.ThreadPriority.BelowNormal
    End Sub
End Class
