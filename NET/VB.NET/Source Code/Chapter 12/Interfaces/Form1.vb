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
        Me.TextBox1.Location = New System.Drawing.Point(56, 160)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(176, 20)
        Me.TextBox1.TabIndex = 0
        Me.TextBox1.Text = ""
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(72, 64)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(144, 23)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "Create an employee..."
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(72, 104)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(144, 23)
        Me.Button2.TabIndex = 2
        Me.Button2.Text = "Create an executive..."
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

    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        Dim Edward As New employee
        Edward.SetName("Edward")
        TextBox1.Text = "You created " & Edward.GetName()
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button2.Click
        Dim Sam As New vicepresident
        Sam.SetName("Sam")
        Sam.SetTitle("vice president")
        TextBox1.Text = "You created " & Sam.GetName() & ", " _
            & Sam.GetTitle()
    End Sub

End Class
Public Interface person
    Sub SetName(ByVal PersonName As String)
    Function GetName() As String
End Interface

Public Interface executive
    Sub SetTitle(ByVal PersonName As String)
    Function GetTitle() As String
    Sub SetName(ByVal ExecutiveTitle As String)
    Function GetName() As String
End Interface


Public Class employee
    Implements person
    Dim Name As String

    Sub SetName(ByVal PersonName As String) Implements person.SetName
        Name = PersonName
    End Sub

    Function GetName() As String Implements person.GetName
        Return Name
    End Function
End Class


Public Class vicepresident
    Implements person, executive
    Dim Name As String
    Dim Title As String

    Sub SetTitle(ByVal ExecutiveTitle As String) Implements _
        executive.SetTitle
        Title = ExecutiveTitle
    End Sub

    Function GetTitle() As String Implements executive.GetTitle
        Return Title
    End Function

    Sub SetName(ByVal PersonName As String) Implements person.SetName, _
        executive.SetName
        Name = PersonName
    End Sub

    Function GetName() As String Implements person.GetName, _
        executive.GetName
        Return Name
    End Function
End Class
