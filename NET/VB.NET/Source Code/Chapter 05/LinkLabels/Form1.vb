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
    Friend WithEvents LinkLabel1 As System.Windows.Forms.LinkLabel
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.LinkLabel1 = New System.Windows.Forms.LinkLabel
        Me.SuspendLayout()
        '
        'LinkLabel1
        '
        Me.LinkLabel1.LinkArea = New System.Windows.Forms.LinkArea(24, 11)
        Me.LinkLabel1.Location = New System.Drawing.Point(40, 48)
        Me.LinkLabel1.Name = "LinkLabel1"
        Me.LinkLabel1.Size = New System.Drawing.Size(208, 23)
        Me.LinkLabel1.TabIndex = 0
        Me.LinkLabel1.TabStop = True
        Me.LinkLabel1.Text = "Want to know more about Black Books?"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 118)
        Me.Controls.Add(Me.LinkLabel1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private Sub LinkLabel1_LinkClicked(ByVal sender As System.Object, _
        ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs) _
        Handles LinkLabel1.LinkClicked
        LinkLabel1.LinkVisited = True
        System.Diagnostics.Process.Start("www.dreamtechpress.com")
    End Sub

End Class
