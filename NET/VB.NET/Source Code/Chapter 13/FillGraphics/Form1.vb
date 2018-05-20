Imports System.Drawing.Drawing2D
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
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.BackColor = System.Drawing.Color.White
        Me.ClientSize = New System.Drawing.Size(184, 182)
        Me.Name = "Form1"
        Me.Text = "Form1"

    End Sub

#End Region

    Private Sub Form1_Paint(ByVal sender As Object, _
        ByVal e As System.Windows.Forms.PaintEventArgs) _
        Handles MyBase.Paint
        Dim g As Graphics
        Dim r As Rectangle
        g = Me.CreateGraphics()

        r = New Rectangle(20, 20, 60, 60)
        Dim lb As New LinearGradientBrush( _
           r, Color.Red, Color.Yellow, LinearGradientMode.Horizontal)
        g.FillEllipse(lb, r)

        r = New Rectangle(20, 100, 60, 60)
        Dim hb As New HatchBrush(HatchStyle.DarkDownwardDiagonal, _
            Color.LightBlue)
        g.FillEllipse(hb, r)

        r = New Rectangle(100, 20, 60, 60)
        Dim sb As New SolidBrush(Color.Coral)
        g.FillEllipse(sb, r)

        r = New Rectangle(100, 100, 60, 60)
        Dim tb As New TextureBrush(Bitmap.FromFile("Coffee Bean.bmp"))
        g.FillEllipse(tb, r)
    End Sub

End Class
