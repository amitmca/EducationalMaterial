Public Class UserControl1
    Inherits System.Windows.Forms.UserControl

#Region " Windows Form Designer generated code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Windows Form Designer.
        InitializeComponent()

        'Add any initialization after the InitializeComponent() call

    End Sub

    'UserControl1 overrides dispose to clean up the component list.
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
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Label1 = New System.Windows.Forms.Label
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(20, 32)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(104, 32)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Label1"
        '
        'UserControl1
        '
        Me.Controls.Add(Me.Label1)
        Me.Name = "UserControl1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Labelcolor As Color
    Public Event textmodified(ByVal NewText As String)

    Property Displaycolor() As Color
        Get
            Return Labelcolor

        End Get
        Set(ByVal Value As Color)
            Labelcolor = Value
            Label1.BackColor = Labelcolor
        End Set
    End Property
    Public Sub SetText(ByVal NewText As String)
        Label1.Text = NewText
        RaiseEvent textmodified(NewText)
    End Sub
End Class
