<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form4
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        If disposing AndAlso components IsNot Nothing Then
            components.Dispose()
        End If
        MyBase.Dispose(disposing)
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.lblRed = New System.Windows.Forms.Label
        Me.lblGreen = New System.Windows.Forms.Label
        Me.lblBlue = New System.Windows.Forms.Label
        Me.hsbRed = New System.Windows.Forms.HScrollBar
        Me.hsbGreen = New System.Windows.Forms.HScrollBar
        Me.hsbBlue = New System.Windows.Forms.HScrollBar
        Me.SuspendLayout()
        '
        'lblRed
        '
        Me.lblRed.AutoSize = True
        Me.lblRed.Location = New System.Drawing.Point(24, 42)
        Me.lblRed.Name = "lblRed"
        Me.lblRed.Size = New System.Drawing.Size(27, 13)
        Me.lblRed.TabIndex = 0
        Me.lblRed.Text = "Red"
        '
        'lblGreen
        '
        Me.lblGreen.AutoSize = True
        Me.lblGreen.Location = New System.Drawing.Point(24, 101)
        Me.lblGreen.Name = "lblGreen"
        Me.lblGreen.Size = New System.Drawing.Size(36, 13)
        Me.lblGreen.TabIndex = 1
        Me.lblGreen.Text = "Green"
        '
        'lblBlue
        '
        Me.lblBlue.AutoSize = True
        Me.lblBlue.Location = New System.Drawing.Point(24, 165)
        Me.lblBlue.Name = "lblBlue"
        Me.lblBlue.Size = New System.Drawing.Size(28, 13)
        Me.lblBlue.TabIndex = 2
        Me.lblBlue.Text = "Blue"
        '
        'hsbRed
        '
        Me.hsbRed.Location = New System.Drawing.Point(68, 42)
        Me.hsbRed.Maximum = 255
        Me.hsbRed.Name = "hsbRed"
        Me.hsbRed.Size = New System.Drawing.Size(252, 22)
        Me.hsbRed.TabIndex = 3
        '
        'hsbGreen
        '
        Me.hsbGreen.Location = New System.Drawing.Point(68, 101)
        Me.hsbGreen.Maximum = 255
        Me.hsbGreen.Name = "hsbGreen"
        Me.hsbGreen.Size = New System.Drawing.Size(252, 22)
        Me.hsbGreen.TabIndex = 4
        '
        'hsbBlue
        '
        Me.hsbBlue.Location = New System.Drawing.Point(68, 165)
        Me.hsbBlue.Maximum = 255
        Me.hsbBlue.Name = "hsbBlue"
        Me.hsbBlue.Size = New System.Drawing.Size(252, 22)
        Me.hsbBlue.TabIndex = 5
        '
        'Form4
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(329, 271)
        Me.Controls.Add(Me.hsbBlue)
        Me.Controls.Add(Me.hsbGreen)
        Me.Controls.Add(Me.hsbRed)
        Me.Controls.Add(Me.lblBlue)
        Me.Controls.Add(Me.lblGreen)
        Me.Controls.Add(Me.lblRed)
        Me.Name = "Form4"
        Me.Text = "Form4"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents lblRed As System.Windows.Forms.Label
    Friend WithEvents lblGreen As System.Windows.Forms.Label
    Friend WithEvents lblBlue As System.Windows.Forms.Label
    Friend WithEvents hsbRed As System.Windows.Forms.HScrollBar
    Friend WithEvents hsbGreen As System.Windows.Forms.HScrollBar
    Friend WithEvents hsbBlue As System.Windows.Forms.HScrollBar
End Class
