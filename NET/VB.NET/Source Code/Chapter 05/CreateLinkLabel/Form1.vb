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
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(72, 152)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(144, 23)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Create LinkLabel"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 214)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private WithEvents LinkLabel1 As LinkLabel

    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        LinkLabel1 = New LinkLabel
        LinkLabel1.AutoSize = True
        LinkLabel1.Location = New Point(15, 15)
        LinkLabel1.Size = New Size(135, 15)
        LinkLabel1.Text = _
            "Interested in Black Books? Click here to see them all!"

        LinkLabel1.Links.Add(14, 11, "info")
        LinkLabel1.Links.Add(33, 4, "www.dreamtechpress.com")

        AddHandler LinkLabel1.LinkClicked, AddressOf Me.LinkLabel1_LinkClicked
        Me.Controls.Add(LinkLabel1)
    End Sub
    Private Sub LinkLabel1_LinkClicked(ByVal sender As Object, _
        ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs)
        LinkLabel1.Links(LinkLabel1.Links.IndexOf(e.Link)).Visited = True
        If (e.Link.LinkData.ToString() = "info") Then
            Dim InfoWindow As New Form2
            InfoWindow.Show()
        End If
    End Sub

End Class
