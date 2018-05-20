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
    Friend WithEvents ToolBar1 As System.Windows.Forms.ToolBar
    Friend WithEvents ToolBarButton1 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton2 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton3 As System.Windows.Forms.ToolBarButton
    Friend WithEvents ToolBarButton4 As System.Windows.Forms.ToolBarButton
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.ToolBar1 = New System.Windows.Forms.ToolBar
        Me.ToolBarButton1 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton2 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton3 = New System.Windows.Forms.ToolBarButton
        Me.ToolBarButton4 = New System.Windows.Forms.ToolBarButton
        Me.SuspendLayout()
        '
        'ToolBar1
        '
        Me.ToolBar1.Buttons.AddRange(New System.Windows.Forms.ToolBarButton() {Me.ToolBarButton1, Me.ToolBarButton2, Me.ToolBarButton3, Me.ToolBarButton4})
        Me.ToolBar1.ButtonSize = New System.Drawing.Size(56, 38)
        Me.ToolBar1.DropDownArrows = True
        Me.ToolBar1.Location = New System.Drawing.Point(0, 0)
        Me.ToolBar1.Name = "ToolBar1"
        Me.ToolBar1.ShowToolTips = True
        Me.ToolBar1.Size = New System.Drawing.Size(292, 44)
        Me.ToolBar1.TabIndex = 0
        '
        'ToolBarButton1
        '
        Me.ToolBarButton1.Text = "Rectangle"
        '
        'ToolBarButton2
        '
        Me.ToolBarButton2.Text = "Ellipse"
        '
        'ToolBarButton3
        '
        Me.ToolBarButton3.Text = "Line"
        '
        'ToolBarButton4
        '
        Me.ToolBarButton4.Text = "Draw"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.BackColor = System.Drawing.Color.White
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.ToolBar1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Dim g As Graphics
    Dim up, down As Point
    Dim r As Rectangle
    Dim Tool As Tools
    Dim Points() As Point
    Dim NumberPoints As Integer = 0


    Private Sub Form1_Load(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles MyBase.Load
        g = Me.CreateGraphics()
    End Sub


    Private Sub ToolBar1_ButtonClick(ByVal sender As System.Object, _
        ByVal e As System.Windows.Forms.ToolBarButtonClickEventArgs) _
        Handles ToolBar1.ButtonClick
        If (ToolBar1.Buttons(0) Is e.Button) Then
            Tool = Tools.Rectangle
        End If
        If (ToolBar1.Buttons(1) Is e.Button) Then
            Tool = Tools.Ellipse
        End If
        If (ToolBar1.Buttons(2) Is e.Button) Then
            Tool = Tools.Line
        End If
        If (ToolBar1.Buttons(3) Is e.Button) Then
            Tool = Tools.Draw
        End If
    End Sub


    Private Sub Form1_MouseDown(ByVal sender As Object, _
        ByVal e As System.Windows.Forms.MouseEventArgs) Handles _
        MyBase.MouseDown
        down = New Point(e.X, e.Y)
    End Sub



    Private Sub Form1_MouseUp(ByVal sender As Object, _
        ByVal e As System.Windows.Forms.MouseEventArgs) _
        Handles MyBase.MouseUp
        up = New Point(e.X, e.Y)
        r = New Rectangle(Math.Min(up.X, down.X), _
            Math.Min(up.Y, down.Y), Math.Abs(up.X - down.X), _
            Math.Abs(up.Y - down.Y))

        Select Case Tool
            Case Tools.Rectangle
                g.DrawRectangle(Pens.BlueViolet, r)
            Case Tools.Ellipse
                g.DrawEllipse(Pens.BlueViolet, r)
            Case Tools.Line
                g.DrawLine(Pens.BlueViolet, up, down)
        End Select
    End Sub
    Private Sub Form1_MouseMove(ByVal sender As Object, _
            ByVal e As System.Windows.Forms.MouseEventArgs) Handles _
            MyBase.MouseMove
        If Tool = Tools.Draw And e.Button = MouseButtons.Left Then
            Dim p As New Point(e.X, e.Y)

            ReDim Preserve Points(NumberPoints)

            Points(NumberPoints) = p
            NumberPoints += 1

            If NumberPoints >= 2 Then
                g.DrawLines(Pens.BlueViolet, Points)
            End If
        End If
    End Sub

    Private Sub Form1_Paint(ByVal sender As Object, _
        ByVal e As System.Windows.Forms.PaintEventArgs) _
            Handles MyBase.Paint
        Select Case Tool
            Case Tools.Rectangle
                g.DrawRectangle(Pens.BlueViolet, r)
            Case Tools.Ellipse
                g.DrawEllipse(Pens.BlueViolet, r)
            Case Tools.Line
                g.DrawLine(Pens.BlueViolet, up, down)
            Case Tools.Draw
                If NumberPoints >= 2 Then
                    g.DrawLines(Pens.BlueViolet, Points)
                End If
        End Select
    End Sub

End Class
Enum Tools
    Rectangle
    Ellipse
    Line
    Draw
End Enum
