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
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.SuspendLayout()
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(48, 80)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(184, 20)
        Me.TextBox1.TabIndex = 0
        Me.TextBox1.Text = "TextBox1"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 238)
        Me.Controls.Add(Me.TextBox1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private Sub Form1_MouseDown(ByVal sender As Object, _
   ByVal e As System.Windows.Forms.MouseEventArgs) _
   Handles MyBase.MouseDown
        If e.Button = MouseButtons.Left Then
            TextBox1.Text = "Mouse down at " + CStr(e.X) + ", " + CStr(e.Y)
        End If
    End Sub

    Private Sub Form1_MouseEnter(ByVal sender As Object, _
        ByVal e As System.EventArgs) Handles MyBase.MouseEnter
        TextBox1.Text = "Mouse entered."
    End Sub

    Private Sub Form1_MouseHover(ByVal sender As Object, _
        ByVal e As System.EventArgs) Handles MyBase.MouseHover
        TextBox1.Text = "Mouse is hovering."
    End Sub

    Private Sub Form1_MouseLeave(ByVal sender As Object, _
        ByVal e As System.EventArgs) Handles MyBase.MouseLeave
        TextBox1.Text = "Mouse left."
    End Sub

    Private Sub Form1_MouseMove(ByVal sender As Object, _
        ByVal e As System.Windows.Forms.MouseEventArgs) _
        Handles MyBase.MouseMove
        TextBox1.Text = "Mouse moved: " + CStr(e.X) + ", " + CStr(e.Y)
    End Sub

    Private Sub Form1_MouseUp(ByVal sender As Object, _
        ByVal e As System.Windows.Forms.MouseEventArgs) _
        Handles MyBase.MouseUp
        If e.Button = MouseButtons.Left Then
            TextBox1.Text = "Mouse up at " + CStr(e.X) + ", " + CStr(e.Y)
        End If
    End Sub

    Private Sub Form1_MouseWheel(ByVal sender As Object, _
        ByVal e As System.Windows.Forms.MouseEventArgs) _
        Handles MyBase.MouseWheel
        TextBox1.Text = "Mouse rotated " + CStr(e.Delta) + " detents"
    End Sub

End Class
