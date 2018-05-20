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
    Friend WithEvents StatusBar1 As System.Windows.Forms.StatusBar
    Friend WithEvents StatusBarPanel1 As System.Windows.Forms.StatusBarPanel
    Friend WithEvents StatusBarPanel2 As System.Windows.Forms.StatusBarPanel
    Friend WithEvents StatusBarPanel3 As System.Windows.Forms.StatusBarPanel
    Friend WithEvents Button1 As System.Windows.Forms.Button
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.StatusBar1 = New System.Windows.Forms.StatusBar
        Me.StatusBarPanel1 = New System.Windows.Forms.StatusBarPanel
        Me.StatusBarPanel2 = New System.Windows.Forms.StatusBarPanel
        Me.StatusBarPanel3 = New System.Windows.Forms.StatusBarPanel
        Me.Button1 = New System.Windows.Forms.Button
        CType(Me.StatusBarPanel1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.StatusBarPanel2, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.StatusBarPanel3, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'StatusBar1
        '
        Me.StatusBar1.Location = New System.Drawing.Point(0, 250)
        Me.StatusBar1.Name = "StatusBar1"
        Me.StatusBar1.Panels.AddRange(New System.Windows.Forms.StatusBarPanel() {Me.StatusBarPanel1, Me.StatusBarPanel2, Me.StatusBarPanel3})
        Me.StatusBar1.ShowPanels = True
        Me.StatusBar1.Size = New System.Drawing.Size(292, 16)
        Me.StatusBar1.TabIndex = 0
        '
        'StatusBarPanel1
        '
        Me.StatusBarPanel1.Text = "Panel 1"
        '
        'StatusBarPanel2
        '
        Me.StatusBarPanel2.Text = "Panel 2"
        '
        'StatusBarPanel3
        '
        Me.StatusBarPanel3.Text = "Panel 3"
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(80, 88)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(112, 32)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "Set panel caption"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.StatusBar1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        CType(Me.StatusBarPanel1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.StatusBarPanel2, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.StatusBarPanel3, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Button1_Click(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles Button1.Click
        'StatusBarPanel1.Text = "The new text!"
        StatusBar1.Panels(0).Text = "The new text!"
        'StatusBarPanel3.Icon = New Icon("c:\vbnet\ch10\statusbars\waste.ico")
        StatusBar1.Panels(2).Icon = New _
            Icon("C:\VB NET_BB\From Ankur\Chap10\StatusBars\waste.ico")
    End Sub
    Private Sub StatusBar1_PanelClick(ByVal sender As System.Object, _
    ByVal e As System.Windows.Forms.StatusBarPanelClickEventArgs) _
    Handles StatusBar1.PanelClick
        If e.StatusBarPanel Is StatusBar1.Panels(1) Then
            MsgBox("You clicked " & e.StatusBarPanel.Text)
        End If
    End Sub

End Class
