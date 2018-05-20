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
        Me.Button1.Location = New System.Drawing.Point(48, 104)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(200, 23)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "Inheritance-based Polymorphism"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(48, 144)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(200, 23)
        Me.Button2.TabIndex = 2
        Me.Button2.Text = "Interface-based Polymorphism"
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

    Public Sub Display(ByVal AnimalObject As Animal)
        AnimalObject.Breathe()
    End Sub



    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        Dim pet1 As New Animal
        Dim pet2 As New Fish
        Display(pet1)
        Display(pet2)
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button2.Click
        Dim pet1 As New Animal2
        Dim pet2 As New Fish2
        Display2(pet1)
        Display2(pet2)
    End Sub

    Public Sub Display2(ByVal AnimalObject As AnimalInterface)
        AnimalObject.Breathe()
    End Sub

End Class
Public Class Animal
    Overridable Sub Breathe()
        MsgBox("Breathing...")
    End Sub
End Class

Public Class Fish
    Inherits Animal
    Overrides Sub Breathe()
        MsgBox("Bubbling...")
    End Sub
End Class



Public Interface AnimalInterface
    Sub Breathe()
End Interface

Public Class Animal2
    Implements AnimalInterface
    Sub Breathe() Implements AnimalInterface.Breathe
        MsgBox("Breathing...")
    End Sub
End Class

Public Class Fish2
    Implements AnimalInterface
    Sub Breathe() Implements AnimalInterface.Breathe
        MsgBox("Bubbling...")
    End Sub
End Class
